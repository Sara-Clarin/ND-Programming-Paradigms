from abc import ABC, abstractmethod

class Average( ABC):

    def __init__(self):
        super().__init__()

    @abstractmethod
    def average(self, data):
        pass

class GetMedian( Average):
    def average( self, data):
        n = len(data)
        sorted_copy = sorted(data)

        if n % 2:   # list has odd length
            print(f'Average measure = median :  { sorted_copy[n//2]}')
            return sorted_copy[n/2]
        else:
            m1 = sorted_copy[n//2]
            m2 = sorted_copy[ (n//2 - 1) ]
            median = (m1 + m2)/2
            print(f'Average measure = median :  {median}')
            return median

class GetMode( Average):
    def average( self, data):
        mode = max(data, key=data.count)
        print(f'Average measure =  mode :  {mode}')
        return mode

class GetMean( Average):
    def average( self, data):
        mean = sum(data) / len(data)
        print(f'Average measure = mean :{mean}')
        return mean
