import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class RobotSim {

   
    private int currentX;
    private int currentY;
    private int rowSize = 50;
    private char direction = 'N';


    public boolean turnRight(){
        if (this.direction == 'N'){
            this.currentX ++;
            this.direction = 'E';
        }else if (this.direction == 'S'){
            this.currentX --;
            this.direction = 'W';
        }else if (this.direction == 'E'){
            this.currentY --;
            this.direction = 'S';
        }else{                  // facing West
            this.currentY++;
            this.direction = 'N';
        }
        if (this.currentX > rowSize || this.currentY > rowSize){
            return false;
        }
        return true;
    }
    public boolean turnLeft(){
        if (this.direction == 'N'){
            this.currentX --;
            this.direction = 'W';
        }else if (this.direction == 'S'){
            this.currentX++;
            this.direction = 'E';
        }else if (this.direction == 'E'){
            this.currentY++;
            this.direction = 'N';
        }else{
            this.currentY--;
            this.direction = 'S';
        }
        return true;
    }
    public boolean Advance(){
        if (this.direction == 'N'){
            this.currentY++;
        }else if (this.direction == 'S'){
            this.currentY--;
        }else if (this.direction == 'W'){
            this.currentX--;
        }else{
            this.currentX++;
        }
        return false;
    }

    public void parseInstructions(String instructs){
        
        for (int i = 0; i < instructs.length(); i++){
            if (instructs.charAt(i) == 'R'){
                turnRight();
            }else if (instructs.charAt(i) == 'A'){
                 Advance();
            }else if (instructs.charAt(i) == 'L'){
                turnLeft();
            }
            if (this.currentX > rowSize || this.currentY > rowSize){
                System.out.print("Robot out of bounds");
                return;
            }
        }
    }
    public void printPosition(){
        System.out.printf("\nFinal position of the robot is {%d, %d} \n", this.currentX, this.currentY);
    }
    public boolean setStartingPosition(int x, int y, char dir){
        if (x > 50 || x < 0 || y > 50 || y < 0 ){
            return false;
        }else if (dir != 'N' && dir != 'S' && dir != 'E' && dir != 'W'){
            return false;
        }
        this.currentX = x;
        this.currentY = y;
        this.direction = dir;
        return true;
    }
    public void process_input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> tokens = new ArrayList<>();
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && st != null){
                tokens.add( st.nextToken());
            }
            if (!setStartingPosition( Integer.parseInt(tokens.get(0)), Integer.parseInt(tokens.get(1)), tokens.get(2).charAt(0)  )){
                System.out.println("Invalid input. Ensure coordinates are in bounds, and commands correctly formatted");
                System.out.println("Coordinates: {-1, -1}");
                System.exit( -1);
            }
        }catch(IOException ioe){
            System.out.println("Input reading error. Try again");
        }
        parseInstructions(tokens.get(3));
    }
    public static void main(String[] args){

        RobotSim R = new RobotSim();

        System.out.println("Enter initial coordinates, directions, command string in form {x} {y} {direction} {commandstr}");
        System.out.println("Example: 7 4 S RAALAL");
        System.out.println("Input here: ");
        R.process_input();
        R.printPosition();
    }
}
