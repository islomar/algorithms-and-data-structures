from expects import expect

from misc.src.url_fetcher_with_lru_cache import URLFetcherWithLRUCache
from doublex import Mimic, Spy
from doublex_expects import have_been_called_with

from misc.src.url_fetcher_with_manual_lru_cache import URLFetcherWithManualLRUCache
from misc.src.url_fetcher_without_cache import UrlFetcherWithoutCache


class TestURLFetcherWithLRUCacheUnit:

    def test_url_fetcher_with_lrucache_function(self):
        url_fetcher_without_cache_spy: UrlFetcherWithoutCache = Mimic(Spy, UrlFetcherWithoutCache)
        url_fetcher_with_lru_cache = URLFetcherWithLRUCache(url_fetcher_without_cache_spy, maxsize=2)

        url_fetcher_with_lru_cache.fetch("url1")
        url_fetcher_with_lru_cache.fetch("url2")
        url_fetcher_with_lru_cache.fetch("url1")

        expect(url_fetcher_without_cache_spy.execute).to(have_been_called_with("url1").once)
        expect(url_fetcher_without_cache_spy.execute).to(have_been_called_with("url2").once)

        url_fetcher_with_lru_cache.fetch("url3")
        url_fetcher_with_lru_cache.fetch("url2")

        expect(url_fetcher_without_cache_spy.execute).to(have_been_called_with("url3").once)
        expect(url_fetcher_without_cache_spy.execute).to(have_been_called_with("url2").twice) # url2 was evicted, so a new call was required

    def test_url_fetcher_with_lrucache_manual(self):
        url_fetcher_without_cache_spy: UrlFetcherWithoutCache = Mimic(Spy, UrlFetcherWithoutCache)
        url_fetcher_with_lru_cache = URLFetcherWithManualLRUCache(url_fetcher_without_cache_spy, maxsize=2)

        url_fetcher_with_lru_cache.fetch("url1")
        url_fetcher_with_lru_cache.fetch("url2")
        url_fetcher_with_lru_cache.fetch("url1")

        expect(url_fetcher_without_cache_spy.execute).to(have_been_called_with("url1").once)
        expect(url_fetcher_without_cache_spy.execute).to(have_been_called_with("url2").once)

        url_fetcher_with_lru_cache.fetch("url3")
        url_fetcher_with_lru_cache.fetch("url2")

        expect(url_fetcher_without_cache_spy.execute).to(have_been_called_with("url3").once)
        expect(url_fetcher_without_cache_spy.execute).to(have_been_called_with("url2").twice) # url2 was evicted, so a new call was required