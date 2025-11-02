import asyncio, aiohttp

class AsyncUrlFetcherWithAiohttp:

    def execute(self, urls: list[str]):
        return asyncio.run(self._execute(urls))

    async def _execute(self, urls: list[str]):
        async with aiohttp.ClientSession() as session:
            tasks = [asyncio.create_task(self._fetch(session, url)) for url in urls]
            return await asyncio.gather(*tasks)

    async def _fetch(self, session, url):
        async with session.get(url) as response:
            return await response.text()  # or response.status, etc.