public class RedHorse extends RaceHorse {

    public RedHorse( String runstrategy, String name, String color ){
        super( runstrategy, name, color);
    };
   
    public double AdvanceHorse(){
        this.metersRan = this.runstrategy.Advance( this.location );  // implement strategy pattern
        this.metersLeft = this.metersLeft - this.metersRan;
        this.location = 10 - this.metersLeft;

        if (this.metersLeft <= 0){
            this.done = true;
            System.out.printf("Horse %s wearing red is at 10km and is finished!", this.name);
            
            System.out.println();
            return metersLeft;
        }
        System.out.printf("Horse %s wearing red is at %f kilometers", this.name, this.location);
        System.out.println();

        return metersLeft;
    }
}