from DataSet import *
from math import floor
from random import random, shuffle

class DataSets( ):
    def __init__(self):
        super().__init__()
        self.data_set_list = []
        
        tri_floats = list( random() * 3 for n in range(100))
        squares = list(n*n for n in range(50))
        rand_ints = list( floor(random() * 10) for n in range(250))

        tri_float_dataset   = DataSet( BubbleSort(), GetMedian(), FilterAboveMean(),  tri_floats) 
        squares_dataset     = DataSet( QuickSort(),  GetMean(),  FilterByOdds(),   squares)
        rand_ints_dataset   = DataSet( BubbleSort(), GetMode(),   FilterByEvens(), rand_ints)

        self.data_set_list.append( tri_float_dataset)
        self.data_set_list.append( squares_dataset)
        self.data_set_list.append( rand_ints_dataset)


    def print_datasets( self):
        for dataset in self.data_set_list:
            print(f'***********************************************************************************************')
            print(f'Original dataset: {dataset.data}', end = "\n\n")
            print(f'Length of dataset: {len(dataset.data)}', end = "\n\n")
            dataset.average()
            print(" ")
            dataset.filter()

            dataset.explain()
            print(f'Dataset after sorting: {dataset.sort()}', end = "\n\n")
            dataset.get_time()
            print(' ')

        print('***********************************************************************************************')
