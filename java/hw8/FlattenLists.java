import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;


public class FlattenLists {
  
    public List<String> flatten( List<List> nested ){
        List<String> flattened = new ArrayList<String>();
            
       return flattened;
    }
    public static void printList(List<Integer[]> n){
        for (Integer[] i : n){
            System.out.print(i);
        }
    }

    public static void main(String[] args){

        // List< List<Integer>> nested = new ArrayList<>();
        //List <List<Integer[]>> nested = new ArrayList<>();
        List<Integer[]> n1 = new ArrayList<>();
        //nested.add(1);
        Integer[] inner = {2, 3, null};
        Integer[] inner0 = {1};
        n1.add( inner);
        n1.add(inner0);

        printList(n1);
        //System.out.println();
    }
}
