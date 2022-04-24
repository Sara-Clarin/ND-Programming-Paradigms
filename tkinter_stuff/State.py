from abc import ABC, abstractmethod


class State(ABC):

    def __init__(self, slither_animal):
        self.slither_animal = slither_animal
        self.steps = 0
        self.meals = 0

    @abstractmethod
    def count_steps( self):
        pass

    @abstractmethod
    def eat_meal( self):
        pass

    @abstractmethod
    def get_state( self):
        pass
   
class Engorged( State):

    def __init__(self, slither_animal):
        super().__init__(slither_animal)

    def count_steps(self):
        self.steps += 1

        if self.steps >= 20:
            self.steps = 0
            if self.meals == 0:  # go to content
                print("changing from state engorged to content")
                self.slither_animal.set_state( self.slither_animal.get_content() )

    def eat_meal(self):
        self.meals += 1

    def get_state(self):
        return "engorged" 

class Content( State):
    

    def __init__(self, slither_animal):
        super().__init__(slither_animal)

    def count_steps(self):
        self.steps += 1

    def count_steps(self):
        self.steps += 1

        if self.steps >= 20:
            self.steps = 0
            if self.meals == 0:  # go to hungry
                print("changing from state content to hungry")
                self.slither_animal.set_state( self.slither_animal.get_hungry() )

    def eat_meal(self):
        self.meals += 1

        if self.meals >= 3:
            self.meals = 0
            print("changing state from content to engorged")
            self.slither_animal.set_state( self.slither_animal.get_engorged() )

    def get_state(self):
        return "content"
 

class Hungry( State):

    def __init__(self, slither_animal):
        super().__init__(slither_animal)

    def count_steps(self):
        self.steps += 1

    def eat_meal(self):
        self.meals += 1

        if self.meals >= 5:
            self.meals = 0
            print("changing state from hungry to engorged")
            self.slither_animal.set_state( self.slither_animal.get_engorged() )

    def get_state(self):
        return "hungry" 
