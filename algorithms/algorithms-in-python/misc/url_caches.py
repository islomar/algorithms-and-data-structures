from dataclasses import dataclass, field

from misc.cached_url import CachedUrl


@dataclass
class UrlCaches:
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