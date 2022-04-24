from random import randint

class Food():

    def __init__(self):
        self.xval = randint(6, 12*24)
        self.yval = randint(6, 12*36)
        self.eaten_count = 0

    def check_coordinates( self, snake_x, snake_y):
        x = (snake_x -1) *  15   # rectangle size on grid = 15
        y = (snake_y ) * 15
        if (x >= (self.xval-5) and x <=  self.xval + 25):
            if (y >= (self.yval-5) and y <= self.yval + 25):
                print("Food has been eaten!")
                self.eaten_count += 1
                return True

        return False


    def update_coordinates( self ):
        self.xval = randint(6, 12*24)
        self.yval = randint(6, 12*36)

        return [self.xval, self.yval]

   
    def getX():
        return self.xval

    def getY():
        return self.yval 

    def getCoords( self):
        return [self.xval, self.yval]
