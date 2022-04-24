public abstract class RaceHorse {
    public double metersRan = 0;
    public double metersLeft = 10;
    public double location = 0;
    public RunStrategy runstrategy;
    public boolean done = false;
    public String name;
    public  String color; 

    //abstract void showStatus();
    public RaceHorse( String myrunstrategy, String name, String color ){
        //this.myhorse = myhorse;
            if (myrunstrategy.equals("steadyRunStrategy")){
                setRunStrategy( new steadyRunStrategy());
            }else if (myrunstrategy.equals("slowStartStrategy")){
                setRunStrategy( new slowStartStrategy());
            }else{
                setRunStrategy( new earlySprintStrategy());
            }
            setName(name);
    }
    public RaceHorse(){
        //do nothing
    }
    public void setName( String name ){
        this.name = name;
    }
    public void setRunStrategy( RunStrategy runstrat ){
        this.runstrategy = runstrat;
    }
    
    abstract double AdvanceHorse();
    /*
    abstract void setName(String name);
    abstract void setRunStrategy( RunStrategy runstrategy);*/
    
}
