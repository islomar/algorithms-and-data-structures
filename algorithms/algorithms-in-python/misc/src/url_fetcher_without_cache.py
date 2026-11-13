from abc import ABC, abstractmethod

import requests


class UrlFetcherWithoutCache(ABC):

    @abstractmethod
    def execute(self, url: str, ttl_seconds: int = 300) -> str:
        pass
