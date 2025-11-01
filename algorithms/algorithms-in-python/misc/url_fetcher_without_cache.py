import requests


class UrlFetcherWithoutCache:

    def execute(self, url: str, ttl_seconds: int = 300) -> str:
        response = requests.get(url)
        response.raise_for_status()
        return response.text
