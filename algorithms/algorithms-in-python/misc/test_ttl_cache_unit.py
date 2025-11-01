import requests
import pytest
from unittest.mock import Mock, patch

from misc.fetch_url import UrlFetcher
from misc.url_fetcher_with_ttl_cache import UrlFetcherWithTtlCache
from misc.url_fetcher_without_cache import UrlFetcherWithoutCache


class TestFetchHTMLWithTTLCache:
    @patch('requests.get')
    def test_fetches_html_from_url(self, mock_get):
        """Test that the function fetches HTML content from a URL"""
        mock_response = Mock()
        mock_response.text = "<html><body>Hello World</body></html>"
        mock_response.raise_for_status = Mock()
        mock_get.return_value = mock_response

        result = UrlFetcher().fetch_html_with_ttl_cache("https://example.com")

        assert result == "<html><body>Hello World</body></html>"
        mock_get.assert_called_once_with("https://example.com")

    @patch('requests.get')
    def test_uses_default_ttl_of_300_seconds(self, mock_get):
        """Test that the default TTL is 300 seconds"""
        mock_response = Mock()
        mock_response.text = "<html>Content</html>"
        mock_response.raise_for_status = Mock()
        mock_get.return_value = mock_response

        result = UrlFetcher().fetch_html_with_ttl_cache("https://example.com")

        assert result == "<html>Content</html>"
        assert mock_get.call_count == 1

    @patch('requests.get')
    def test_caches_html_content(self, mock_get):
        """Test that HTML content is cached and reused"""
        mock_response = Mock()
        mock_response.text = "<html>Cached Content</html>"
        mock_response.raise_for_status = Mock()
        mock_get.return_value = mock_response

        # First call - should fetch
        url_fetcher = UrlFetcher()
        result1 = url_fetcher.fetch_html_with_ttl_cache("https://example.com", ttl_seconds=10)

        # Second call - should use cache
        result2 = url_fetcher.fetch_html_with_ttl_cache("https://example.com", ttl_seconds=10)

        assert result1 == "<html>Cached Content</html>"
        assert result2 == "<html>Cached Content</html>"
        # Should only call requests.get once due to caching
        assert mock_get.call_count == 1

    @patch('requests.get')
    @patch('time.time')
    def test_cache_expires_after_ttl(self, mock_time, mock_get):
        """Test that cache expires after TTL and fetches fresh content"""
        mock_response1 = Mock()
        mock_response1.text = "<html>First Content</html>"
        mock_response1.raise_for_status = Mock()

        mock_response2 = Mock()
        mock_response2.text = "<html>Second Content</html>"
        mock_response2.raise_for_status = Mock()

        mock_get.side_effect = [mock_response1, mock_response2]

        # First call at time 0
        mock_time.return_value = 0
        url_fetcher = UrlFetcher()
        result1 = url_fetcher.fetch_html_with_ttl_cache("https://example.com", ttl_seconds=5)

        # Second call at time 6 (after TTL expired)
        mock_time.return_value = 6
        result2 = url_fetcher.fetch_html_with_ttl_cache("https://example.com", ttl_seconds=5)

        assert result1 == "<html>First Content</html>"
        assert result2 == "<html>Second Content</html>"
        assert mock_get.call_count == 2

    @patch('requests.get')
    def test_raises_exception_on_http_error(self, mock_get):
        """Test that HTTP errors are propagated"""
        mock_response = Mock()
        mock_response.raise_for_status.side_effect = requests.exceptions.HTTPError("404 Not Found")
        mock_get.return_value = mock_response

        with pytest.raises(requests.exceptions.HTTPError):
            UrlFetcher().fetch_html_with_ttl_cache("https://example.com/notfound")

    @patch('requests.get')
    def test_custom_ttl_value(self, mock_get):
        """Test that custom TTL values are respected"""
        mock_response = Mock()
        mock_response.text = "<html>Custom TTL</html>"
        mock_response.raise_for_status = Mock()
        mock_get.return_value = mock_response

        result = UrlFetcher().fetch_html_with_ttl_cache("https://example.com", ttl_seconds=600)

        assert result == "<html>Custom TTL</html>"
        assert mock_get.call_count == 1

    @patch('requests.get')
    @patch('time.time')
    def test_different_urls_cached_separately(self, mock_time, mock_get):
        """Test that different URLs are cached independently"""
        mock_response1 = Mock()
        mock_response1.text = "<html>URL 1</html>"
        mock_response1.raise_for_status = Mock()

        mock_response2 = Mock()
        mock_response2.text = "<html>URL 2</html>"
        mock_response2.raise_for_status = Mock()

        mock_get.side_effect = [mock_response1, mock_response2]
        mock_time.return_value = 0

        url_fetcher = UrlFetcher()
        result1 = url_fetcher.fetch_html_with_ttl_cache("https://example.com/page1", ttl_seconds=10)
        result2 = url_fetcher.fetch_html_with_ttl_cache("https://example.com/page2", ttl_seconds=10)

        assert result1 == "<html>URL 1</html>"
        assert result2 == "<html>URL 2</html>"
        assert mock_get.call_count == 2
