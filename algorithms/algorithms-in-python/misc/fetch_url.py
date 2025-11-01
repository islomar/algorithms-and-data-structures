import time
from collections import defaultdict
from dataclasses import dataclass, field

import requests

from misc.url_caches import UrlCaches


class UrlFetcher:
    def __init__(self):
        self.cache: UrlCaches = UrlCaches()

    def fetch_html_with_ttl_cache(self, url: str, ttl_seconds: int = 300) -> str:
        current_time = time.time()

        if self.cache.is_url_alive_in_cache(url, current_time):
            return self.cache.get_cached_html(url)

        response = requests.get(url)
        response.raise_for_status()
        html_content = response.text

        self.cache.cache_url(url, html_content, current_time + ttl_seconds)

        return html_content

