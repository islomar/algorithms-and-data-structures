from functools import lru_cache

from misc.src.url_caches import UrlCaches
from misc.src.url_fetcher_without_cache import UrlFetcherWithoutCache


class URLFetcherWithLRUCache:
    def __init__(self, url_fetcher_without_cache: UrlFetcherWithoutCache, maxsize=128):
        self.cache: UrlCaches = UrlCaches()
        self.url_fetcher_without_cache = url_fetcher_without_cache
        self.maxsize = maxsize
        self._fetch_cached = lru_cache(maxsize)(self._fetch_without_cache)

    def _fetch_without_cache(self, url: str) -> str:
        return self.url_fetcher_without_cache.execute(url)

    def fetch(self, url: str) -> str:
        return self._fetch_cached(url)
