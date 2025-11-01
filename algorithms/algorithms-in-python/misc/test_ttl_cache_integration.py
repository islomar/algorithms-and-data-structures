from expects import contain, expect

from misc.fetch_url import UrlFetcher


class TestFetchUrlIntegration:
    def test_cache_with_ttl(self) -> None:
        url_fetcher = UrlFetcher()

        fetched_html: str = url_fetcher.fetch_html_with_ttl_cache("https://islomar.es")

        expect(fetched_html).to(contain("Vertical Slicing Listicle"))


