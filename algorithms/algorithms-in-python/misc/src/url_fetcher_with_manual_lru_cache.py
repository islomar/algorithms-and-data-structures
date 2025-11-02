from misc.src.lru_cache import LRUCache
from misc.src.url_caches import UrlCaches
from misc.src.url_fetcher_without_cache import UrlFetcherWithoutCache


class URLFetcherWithManualLRUCache:
    def __init__(self, url_fetcher_without_cache: UrlFetcherWithoutCache, maxsize=128):
        self.cache: UrlCaches = UrlCaches()
        self.url_fetcher_without_cache = url_fetcher_without_cache
        self.maxsize = maxsize
        self._lru_cache = LRUCache(maxsize)

    def _fetch_without_cache(self, url: str) -> str:
        return self.url_fetcher_without_cache.execute(url)

    def fetch(self, url: str) -> str:
        if self._is_url_not_cached(url):
            self._lru_cache.put(
                url,
                self._fetch_without_cache(url)
            )
        return self._lru_cache.get(url)

    def _is_url_not_cached(self, url: str) -> bool:
        return self._lru_cache.get(url) == -1