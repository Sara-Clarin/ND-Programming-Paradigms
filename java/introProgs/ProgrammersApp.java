import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProgrammersApp{
   public static void main(String[] args){
        
        System.out.print("Please enter 3 whitespace delimited salaries (no comma): ");
        List<String> tokens = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && st != null){
                tokens.add( st.nextToken());
            }
            ProgrammerTool programmer = new ProgrammerTool( tokens);
            double result = programmer.getDifference();
            System.out.println(result);
        }catch(IOException ioe){
            System.out.println( ioe);
        }
    } 
}
