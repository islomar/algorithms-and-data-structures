import time
from collections import defaultdict
from dataclasses import dataclass, field

import requests

@dataclass
class CachedUrl:
    url: str
    html: str
    expiry_time: float

    def is_alive(self, current_time: float) -> bool:
        return current_time < self.expiry_time

@dataclass
class UrlCache:
    cached_urls: dict[str, CachedUrl] = field(default_factory=dict)

    def cache_url(self, url: str, html: str, expiry_time: float) -> None:
        self.cached_urls[url] = CachedUrl(url, html, expiry_time)

    def is_url_alive_in_cache(self, url: str, current_time: float) -> bool:
        if not self.is_url_cached(url):
            return False
        cached_url = self.cached_urls[url]
        return cached_url.is_alive(current_time)

    def is_url_cached(self, url: str) -> bool:
        return url in self.cached_urls

    def get_cached_html(self, url: str) -> str:
        return self.cached_urls[url].html

class UrlFetcher:
    def __init__(self):
        self.cache: UrlCache = UrlCache()

    def fetch_html_with_ttl_cache(self, url: str, ttl_seconds: int = 300) -> str:
        current_time = time.time()

        if self.cache.is_url_alive_in_cache(url, current_time):
            return self.cache.get_cached_html(url)

        response = requests.get(url)
        response.raise_for_status()
        html_content = response.text

        self.cache.cache_url(url, html_content, current_time + ttl_seconds)

        return html_content

