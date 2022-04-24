from abc import ABC, abstractmethod
from random import randint
import timeit
from timeit import repeat

class mySort(ABC):

    def __init__(self):
        super().__init__()

    @abstractmethod
    def sort(self, data):
        pass

    @abstractmethod
    def explain(self, data):
        pass

    @abstractmethod
    def get_time(self, data):
        pass
        

class BubbleSort( mySort):

    def sort(self, data):
        n = len(data)
        array = data

        for i in range(n):
            already_sorted = True

            for j in range(n - i - 1):
                if array[j] > array[j + 1]:
                    array[j], array[j+1] = array[j+1], array[j]

                    already_sorted = False

            if already_sorted:
                break

        return array

    def get_time( self, data):
        function = BubbleSort.sort( self, data)
        stmt = f"{function}"
        times = repeat( stmt=stmt, repeat=3, number=5)
        print(f'BubbleSort: Minimum execution time: {min(times)}') 

    def explain( self, data):
        print(f'\nThis is bubble sort. It functions by making n passes through the data, swapping adjacent elements if they are in the wrong position.  Each of these passes checks each data item, resulting in a runtime complexit of O(n^2). The advantages of bubble sort include its readability, guaranteed accuracy, and simplicity to implement. Downsides are mainly just performance, and that the best case is also O(n^2). In this implementation, we have a flag already_sorted that diminishes unnecessary outer loop iterations.\n')

class QuickSort( mySort ):

    def sort(self, array):
    
        if len(array) < 2:
            return array

        low, same, high = [], [], []

        pivot = array[randint(0, len(array) -1)]
        for item in array:
            if item < pivot:
                low.append(item)
            elif item == pivot:
                same.append(item)
            elif item > pivot:
                high.append(item)

        return self.sort(low) + same + self.sort(high)

    def explain( self, data):
        print(f'\nThis is quicksort. It runs by randomly choosing a `pivot` element, and organizing the other elements into buckets that are (> pivot) and (< pivot), then recursing upon these two buckets. It is easy to parallelize quicksort, but it uses a lot of memory in exchange for speed because it allocates so many copies of little sections of the array, and is best used on medium-sized data sets.  The worst-case complextity is still O(n^2), but because choosing a random int and copying data are fast operations, it often beats other algorithms in practice.\n')

    def get_time( self, data):
        function = QuickSort.sort( self, data)
        stmt = f"{function}"
        times = repeat( stmt=stmt, repeat=3, number=5)
        print(f'QuickSort: Minimum execution time: {min(times)}')
