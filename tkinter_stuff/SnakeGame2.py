import tkinter as tk
from AnimalBehavior import *
from FoodBehavior import *

class Grid:

    def __init__(self, master):

        #Initialize grid
        self.master = master
        self.keypressed=None
        self.animalType = None
        self.master.title("Snake Game")
        self.height = 36 
        self.width = 24 
        self.rectangle_size = 15
        self.canvas = tk.Canvas(width=self.width*self.rectangle_size, 
            height=(self.height*self.rectangle_size)+self.height/2)
        self.drawGrid()
        self.end_game = False
        self.game_started = False
        self.food = Food( )
        self.foodEaten = 0
        
        # Initialize buttons in a special button frame at bottom of screen
        self.button_frame = tk.Frame(self.master)
        self.button_frame.pack(side="bottom", fill="x", expand=False)
        self.canvas.pack(side="top", fill="both", expand=True)
        
        ######################################################################
        ## TO DO: Create buttons for caterpillar and worm here.  Add them to the grid.
        ######################################################################
        self.button1 = tk.Button(self.button_frame, text="Snake", command=self.createSnake)
        self.button1.grid(row=0, column=1, sticky="ew")
        self.button2 = tk.Button(self.button_frame, text="Worm", command=self.createWorm)
        self.button2.grid(row=0, column=2, sticky="ew")
        self.button3 = tk.Button(self.button_frame, text="Caterpillar", command=self.createCaterpillar)
        self.button3.grid(row=0, column=3, sticky="ew")
        self.Scoreboard = tk.Button(self.button_frame, text="Current State: Content")
        self.Scoreboard.grid( row=0, column = 6, sticky="ew")
    

        self.canvas.pack()    
        self.slowdown = 0

        # Setup a matrix to track the current state of each grid
        self.matrix = [[0 for x in range(self.height+1)] for y in range(self.width+1)] 
        
        ######################################################################
        # bind arrow keys to handlers
        # TO DO: Add Left and Right keypress handlers
        ######################################################################
        master.bind("<Down>", self.handle_down_key)
        master.bind("<Up>", self.handle_up_key)
        master.bind("<Right>", self.handle_right_key)
        master.bind("<Left>", self.handle_left_key) 
        master.bind("<Tab>", self.handle_tab_key)
        
        # ####################################################################
        # IF YOU HAVE TIME replace this coarse-grained update with a more fine-grained change mechanism
        # Your game will be much less jerky if you do that.
        ######################################################################
        self.fillGrid(self.matrix)
        self.drawFood( 0,0 )
        

    def displayMovedAnimal( self, matrix, animal):   # counts steps and also moves the snake
        for segment in animal.body:
            self.placeMarker( segment[0], segment[1] )
        self.clearMarker( animal.tail_end[0], animal.tail_end[1] )
        self.animalType.state.count_steps()
        

    # Special move function.  
    # Snakes game requires us to keep moving in one direction until we 
    # press another key (a bit of a pain to figure out)
    # TO DO: You need to make the move method actuall move the snake!
    def move(self):
        if (self.keypressed == 1):
            self.animalType.moveHead( self.animalType.getX(), self.animalType.getY() -1 )
            self.animalType.changeDirection( 1 )  

        elif (self.keypressed == 2):
            self.animalType.moveHead( self.animalType.getX() + 1, self.animalType.getY() )
            self.animalType.changeDirection(  2)  

        elif (self.keypressed == 3):
            self.animalType.moveHead( self.animalType.getX(), self.animalType.getY() +1 )
            self.animalType.changeDirection( 3 )  

        elif (self.keypressed == 4):
            self.animalType.moveHead( self.animalType.getX() - 1, self.animalType.getY() )
            self.animalType.changeDirection( 4 )  

            
        # After 1 second, call scanning again (create a recursive loop)
        # This construct is very important because it allows the system to
        # continually check for keypresses!
        #if not endgame:
        self.displayMovedAnimal( self.matrix, self.animalType)
        self.drawFood( self.animalType.getX(), self.animalType.getY() )
        self.showState( )
        self.slowdown += 15

        self.master.after( self.animalType.getSpeed() * 500 + self.slowdown, self.move)    # Replace the 1000 with speeds from animal behavior classes.   
        
    #######################################################################
    #Handlers for keypresses
    #######################################################################
    def handle_up_key(self,event):
        self.keypressed = 1
        self.move()
            
    def handle_right_key(self,event):
        self.keypressed = 2
        self.move()
            
    def handle_down_key(self,event):
        self.keypressed = 3
        self.move()

    def handle_left_key(self,event):
        self.keypressed = 4
        self.move()

    def handle_tab_key( self, event):
        print("feeding animal")
        self.animalType.getFood()
        
    ########################################################################
    # Create animals
    # TO DO: Create the two other animals. 
    ########################################################################
    def createSnake(self):
        # Place the 'snake'
        self.animalType = Snake() 
        self.animalType.setStartingPosition(self.width,self.height) #Send the dimensions of the grid
        self.matrix[self.animalType.getX()][self.animalType.getY()] = 1
        self.fillGrid(self.matrix) 
        self.drawFood( 0,0)
        self.game_started = True

    def createWorm(self):
        # Place the 'worm'
        self.animalType = Worm() 
        self.animalType.setStartingPosition(self.width,self.height) #Send the dimensions of the grid
        self.matrix[self.animalType.getX()][self.animalType.getY()] = 1
        self.fillGrid(self.matrix) 
        self.drawFood(0,0)
        self.game_started = True

    def createCaterpillar(self):
        # Place the 'caterpillar'
        self.animalType = Caterpillar() 
        self.animalType.setStartingPosition(self.width,self.height) #Send the dimensions of the grid
        self.matrix[self.animalType.getX()][self.animalType.getY()] = 1
        self.fillGrid(self.matrix) 
        self.drawFood(0,0)
        self.game_started = True
    # Draws the grid
    def drawGrid(self):
        # Creates all vertical lines at intervals of rectangle_size
        for i in range(0, self.width*self.rectangle_size, self.rectangle_size):
            self.canvas.create_line([(i, 0), (i, self.height*self.rectangle_size)])

        # Creates all horizontal lines at intervals of 10
        for i in range(0, self.height*self.rectangle_size, self.rectangle_size):
            self.canvas.create_line([(0, i), (self.width*self.rectangle_size, i)])
	
    def drawFood(self, snakeX, snakeY):
        if (self.food.check_coordinates( snakeX, snakeY) ):   # snake ate!
            self.clearOval(self.food.getCoords() )
            coords = self.food.update_coordinates( )
            self.animalType.getFood()                      # update the current state
            self.foodEaten += 1
        else:
            coords = self.food.getCoords()
        self.canvas.create_oval( coords[0], coords[1], coords[0]+22, coords[1] +22, fill="red")
        self.canvas.pack()


    # Fills the grid given an underlying 2D array where cells are marked 1 if a snake 
    # is present, and 0 otherwise.    
    def fillGrid(self,matrix): #This is more for testing as it is uneconomical
        for w in range(self.width+1):
            for h in range(self.height+1):
                if matrix[w][h] == 1:
                    self.placeMarker(w,h)
                else:
                    self.clearMarker(w,h)
    # Clears one marker from the grid
    # If you want to use this function you will need to ALSO add an update to the underlying matrix
    def clearOval(self, coords):    
        self.canvas.create_oval( coords[0], coords[1], coords[0]+22, coords[1] +22, fill="white")
    
    def clearMarker(self,x,y):
        x1 = (x-1) * self.rectangle_size
        y1 = (y-1) * self.rectangle_size
        self.canvas.create_rectangle(x1,y1, x1+self.rectangle_size, y1+self.rectangle_size, fill="white")
        if ( x <= 23 and x > 0 and y <= 36 and y > 0):
            self.matrix[x][y] = 0
            self.canvas.pack()
        elif self.game_started:
            self.end_game = True	
         
    # Places one marker on the grid
    # If you want to use this function you will need to also update the underlying matrix    
    def placeMarker(self,x,y):
        x1 = (x-1) * self.rectangle_size
        y1 = (y-1) * self.rectangle_size
        self.canvas.create_rectangle(x1,y1, x1+self.rectangle_size, y1+self.rectangle_size, fill=self.animalType.getColor()) #"blue")
        if ( x <= 23 and x > 0 and y <= 36 and y > 0):
            self.matrix[x][y] = 1
            self.canvas.pack()
        elif self.game_started:
            self.end_game = True

    def showState( self):
        self.Scoreboard['text'] = f'Current State: {self.animalType.state.get_state()}'
        self.canvas.pack()

def main(): #run mainloop 
    root = tk.Tk()
    app = Grid(root)
    #root.mainloop()
    
    while True:
        root.update_idletasks()
        root.update()
        if app.end_game:
            print(f'Game over! Final score: {app.foodEaten}')
            root.destroy()
            break
    
if __name__ == '__main__':
    main()
