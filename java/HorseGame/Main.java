import java.util.*;

public class Main{

    static void testRace1(){
        Race myRace = new Race( );

        ArrayList<String> myargs = new ArrayList<String>();
        myargs.add("earlySprintStrategy:Avery:Brown");
        myargs.add("steadyRunStrategy:Keelin:White");
        myargs.add("slowStartStrategy:Lauren:Red");
        myargs.add("steadyRunStrategy:Sara:Brown");
        myargs.add("earlySprintStrategy:Elise:Brown");

        myRace.setup( myargs);
        myRace.runRace();
        myRace.giveResults();
    }
    static void testRace2(){
        Race myRace = new Race( );

        ArrayList<String> myargs = new ArrayList<String>();
        myargs.add("earlySprintStrategy:Patrick:Brown");
        myargs.add("steadyRunStrategy:DarthVader:Red");
        myargs.add("slowStartStrategy:Ethan:White");
        myargs.add("slowStartStrategy:Tommy:Red");
        myargs.add("steadyRunStrategy:Angie:White");

        myRace.setup( myargs);
        myRace.runRace();
        myRace.giveResults();
    }
    static void testRace3(){
        Race myRace = new Race( );

        ArrayList<String> myargs = new ArrayList<String>();
        myargs.add("steadyRunStrategy:Inspiration:Brown");
        myargs.add("steadyRunStrategy:Depression:White");
        myargs.add("slowStartStrategy:Regret:White");
        myargs.add("earlySprintStrategy:Seredipity:Red");
        myargs.add("steadyRunStrategy:Charity:Brown");

        myRace.setup( myargs);
        myRace.runRace();
        myRace.giveResults();
    }
    public static void main(String[] args){
        testRace1();
        System.out.printf("\nEND RACE 1"); System.out.println("***************************************");
        testRace2();
        System.out.printf("\nEND RACE 2"); System.out.println("***************************************");
        testRace3();
        System.out.printf("\nEND RACE 3\n"); 
    }
}