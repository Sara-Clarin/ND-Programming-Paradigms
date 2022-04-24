import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class toStarShorthand {

    public static void main(String[] args){

        System.out.print("Please enter input string: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String inputString = br.readLine();
            shortHandCalc mySHCalc = new shortHandCalc(inputString);
            String result = mySHCalc.toShortHand();
            System.out.println(result);
        } catch(IOException ioe){
            System.out.println( ioe);
        }
    }
}
