from dataclasses import dataclass
from http.client import OK


import requests
from bs4 import BeautifulSoup
from expects import expect, equal, contain, have_properties, have_key, be_none, be, have_length


@dataclass
class HttpBinResponse:
    slideshow: dict


def test_basic_json_request() -> None:
    result = requests.get("https://httpbin.org/json")

    data = result.json()
    http_bin_response = HttpBinResponse(**data)

    expect(result.status_code).to(equal(OK))
    expect(http_bin_response.slideshow).not_to(be_none)
    expect(http_bin_response.slideshow["author"]).to(equal("Yours Truly"))


def test_basic_render_html() -> None:
    page = requests.get("https://islomar.es")

    soup = BeautifulSoup(page.content, "html.parser")
    articles = soup.find_all("article")

    expect(articles).to(have_length(5))
    expect(articles[0].find("a").text).to(contain("Vertical Slicing Listicle"))
