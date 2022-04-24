import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;
import java.lang.String;

public class Race{

    private List<RaceHorse> Horses = new ArrayList<>();
    private boolean GameOver = false;
    private boolean winnerFound = false;
    private String winnerName = " ";


    public Race(){
        System.out.println("Beginning a new Race! Welcome race fans");
    }
    public void setup( ArrayList<String> Horsetypes){
        System.out.println("Creating horses");

        for (String horseInfo : Horsetypes){
            String[] horseChars = horseInfo.split(":");

            if (horseChars.length < 1){
                System.out.println("Entered string is too short");
                return;
            }

            if (horseChars[2].equals( "Red") ){
                RaceHorse tempHorse = new RedHorse( horseChars[0] ,horseChars[1], horseChars[0]);
                this.Horses.add(tempHorse);
            } else if(horseChars[2].equals( "Brown")){
                RaceHorse tempHorse = new BrownHorse( horseChars[0] ,horseChars[1], horseChars[0]);
                this.Horses.add(tempHorse);
            }
            else if(horseChars[2].equals( "White")){
                RaceHorse tempHorse = new WhiteHorse( horseChars[0] ,horseChars[1], horseChars[0]);
                this.Horses.add(tempHorse);
            }
        }
    }

    public void runRace(){

        int seconds = 0;
        while (!GameOver){
            
            GameOver = true;
            System.out.println("------------------------------------------------------");
            System.out.printf("%d seconds \n", seconds);

            for ( RaceHorse racehorse : this.Horses){
           
                if (racehorse.done == false){
                    racehorse.AdvanceHorse();
                    GameOver = false;
                }else{
                    if (!this.winnerFound){
                        this.winnerName = racehorse.name;
                        this.winnerFound = true;
                    }
                }
            }
            try{
                Thread.sleep( 2500);
                seconds += 30;

            }catch(InterruptedException ioe){
                System.out.println("System issue with sleep command");
            }
        }
    }

    public void giveResults(){
        System.out.printf("The winner is: %s ", this.winnerName);
    }
    
}