from abc import ABC, abstractmethod
from AverageBehavior import *
from FilterBehavior import *
from SortBehavior import *


class DataSet(ABC):
    def __init__(self, sortBehavior, averageBehavior, filterBehavior,dataList):
        super().__init__()
        self.data = dataList
        self.averageBehavior = averageBehavior
        self.filterBehavior = filterBehavior
        self.sortBehavior = sortBehavior


    def average(self):
        self.averageBehavior.average( self.data)


    def filter(self):
        self.filterBehavior.filter( self.data)

    def sort(self):
        return self.sortBehavior.sort( self.data)

    def explain(self):
        self.sortBehavior.explain( self.data)

    def get_time(self):
        self.sortBehavior.get_time( self.data)




