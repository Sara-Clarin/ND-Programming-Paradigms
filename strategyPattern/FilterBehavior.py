from abc import ABC, abstractmethod


class myFilter(ABC):

    def __init__(self):
        super().__init__()

    @abstractmethod
    def filter(self, data):
        pass

class FilterByEvens( myFilter):
    def filter(self, data):
        filtered_copy = filter(lambda x: (x % 2 == 0), data)
        print(f'Filtering by evens: {list(filtered_copy)}')
        return list(filtered_copy)

class FilterByOdds( myFilter):
    def filter(self, data):
        filtered_copy = filter(lambda x: (x % 2 == 1), data)
        print(f'Filtering by odds: {list(filtered_copy)}')
        return list(filtered_copy)

class FilterAboveMean( myFilter):
    def filter( self, data):
        threshold = sum(data)/ len(data)
        filtered_copy = filter(lambda x: (x > threshold), data)
        print(f'Filtering above {threshold}: {list(filtered_copy)}')
        return list(filtered_copy)
