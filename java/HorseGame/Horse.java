import java.io.PrintStream;

public class Horse {
    
    private double metersRan = 0;
    private double metersLeft = 10;
    private double location = 0;
    private RunStrategy runstrategy;
    public boolean done = false;
    public String name;
  private  String color; 

    // constructor
    public Horse( RunStrategy runstrategy, String name, String color){
        setRunStrategy(runstrategy);
        setName(name);
        this.color = color;
    }

    public void setName( String name ){
        this.name = name;
    }
    public void setRunStrategy( RunStrategy runstrat ){
        this.runstrategy = runstrat;
    }

    public double AdvanceHorse(){
        this.metersRan = this.runstrategy.Advance( this.location );  // implement strategy pattern
        this.metersLeft = this.metersLeft - this.metersRan;
        this.location = 10 - this.metersLeft;

        if (this.metersLeft <= 0){
            this.done = true;
            System.out.printf("Horse %s is at 10km and is finished!", this.name);
            
            System.out.println();
            return metersLeft;
        }
        System.out.printf("Horse %s is at %f kilometers", name, this.location);
        System.out.println();

        return metersLeft;
    }
}
