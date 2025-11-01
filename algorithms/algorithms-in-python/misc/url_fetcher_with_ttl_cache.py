import time

from misc.url_caches import UrlCaches
from misc.url_fetcher_without_cache import UrlFetcherWithoutCache


class UrlFetcherWithTtlCache:
    def __init__(self, url_fetcher_without_cache: UrlFetcherWithoutCache, maxsize=128):
        self.cache: UrlCaches = UrlCaches()
        self.url_fetcher_without_cache = url_fetcher_without_cache
        self.maxsize = maxsize

    def fetch(self, url: str, ttl_seconds: int = 300) -> str:
        current_time = time.time()

        if self.cache.is_url_alive_in_cache(url, current_time):
            return self.cache.get_cached_html(url)

        html_content = self.url_fetcher_without_cache.execute(url)

        self.cache.cache_url(url, html_content, current_time + ttl_seconds)

        return html_content