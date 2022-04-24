import java.util.stream.*;
import java.util.*;

public class ProgrammerTool {
    
    List<String> programmers;

    public ProgrammerTool( List<String> programmers){
            this.programmers = programmers;
    }
    public double getDifference(){
        List <Double> progsAsDoubles = this.programmers.stream()
                                                    .map( s-> Double.parseDouble(s) )
                                                    .collect(Collectors.toList());
        List<Double> sortedDoubs = progsAsDoubles.stream()
                                                    .sorted()
                                                    .collect( Collectors.toList());
        return sortedDoubs.get(2) - sortedDoubs.get(0);
    }
}
