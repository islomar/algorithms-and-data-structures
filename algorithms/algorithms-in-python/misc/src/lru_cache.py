from collections import OrderedDict


class LRUCache:
    def __init__(self, capacity):
        self.cache = OrderedDict()
        self.capacity = capacity

    def get(self, key):
        if key not in self.cache:
            return -1
        # Move the key to the end to show that it was recently used
        self.cache.move_to_end(key)
        return self.cache[key]

    def put(self, key, value):
        if key in self.cache:
            # Move the key to the end to show that it was recently used
            self.cache.move_to_end(key)
        else:
            if len(self.cache) >= self.capacity:
                # Pop the first item from the ordering which is the least-recently used
                self.cache.popitem(last=False)
        self.cache[key] = value