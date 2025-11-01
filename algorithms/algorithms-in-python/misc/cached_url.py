from dataclasses import dataclass


@dataclass
class CachedUrl:
    url: str
    html: str
    expiry_time: float

    def is_alive(self, current_time: float) -> bool:
        return current_time < self.expiry_time