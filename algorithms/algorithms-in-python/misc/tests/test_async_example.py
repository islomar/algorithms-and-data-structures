import asyncio, aiohttp

from expects import have_length, expect

from misc.src.async_url_fetcher_with_aiohttp import AsyncUrlFetcherWithAiohttp


class TestAsyncExample:
    def test_fetch_urls_concurrently(self) -> None:
        results = AsyncUrlFetcherWithAiohttp().execute(["https://islomar.es", "https://google.com"])

        expect(results).to(have_length(2))


