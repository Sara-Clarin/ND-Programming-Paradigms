# Animal behavior hierarchies 
from abc import ABC, abstractmethod
from random import randint  
from collections import deque
from State import *

class AnimalBehavior(ABC): 
    def __init__(self):
        super().__init__()
        self.head_x = 0
        self.head_y = 0
        self.body = deque()
        self.tail_end = tuple()
        self.previous = tuple()
        self.direction = None

        self.engorged  = Engorged( self)    # state pattern classes
        self.content   = Content( self)
        self.hungry    = Hungry( self )
        self.state     = self.content
            
    @abstractmethod
    def getColor(self):
        pass

    @abstractmethod
    def getSpeed(self):
        pass

    def getFood(self):
        if self.direction == "up":
            self.body.append( (self.head_x, self.head_y + 1 ))
        elif self.direction == "right":
            self.body.append( (self.head_x + 1, self.head_y))
        elif self.direction == "left":
            self.body.append( (self.head_x - 1, self.head_y))
        else:
            self.body.append( (self.head_x, self.head_y -1 ))
       
        self.state.eat_meal()
	
    def set_state( self, new_state):
        self.state = new_state

    def get_state( self):
        return self.state

    def get_engorged(self):
        return self.engorged

    def get_content(self):
        return self.content

    def get_hungry( self):
        return self.hungry

    def moveHead(self,x,y):
        #self.tail_end = (self.head_x, self.head_y)
        self.tail_end= self.body[0 ]
        self.head_x = x
        self.head_y = y	
        self.body.popleft()
        self.body.append( (self.head_x, self.head_y + 1) )
        
    def setStartingPosition(self,width,height):
        self.head_x = randint(4, width)
        self.head_y = randint(4, height)
        self.body.append( (self.head_x, self.head_y ))

    def changeDirection( self, dir_num):
        if dir_num == 1:
            self.direction = "up"
        elif dir_num == 2:
            self.direction = "right"
        elif dir_num == 3:
            self.direction = "down"
        else:
            self.direction = "left"
        
    def getX( self):
        return self.head_x

    def getY( self):
        return self.head_y

    def getTailEnd(self):
        return self.tail_end

class Snake(AnimalBehavior): 
    def getColor(self):
        return "green"
    def getSpeed(self):
        return 1
         
class Caterpillar(AnimalBehavior): 
    def getColor(self):
        return "red"
    def getSpeed(self):
        return 2
		
class Worm(AnimalBehavior): 
    def getColor(self):
        return "brown"
    def getSpeed(self):
        return 3
