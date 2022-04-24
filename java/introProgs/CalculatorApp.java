
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CalculatorApp{
   public static void main(String[] args){
        System.out.print("Please enter arguments in the form {arg1} {operator} {arg2}: ");
    
        List<String> tokens = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && st != null){
                tokens.add( st.nextToken());
            }
            Calculator calc = new Calculator( tokens.get(0), tokens.get(2), tokens.get(1));
            double result = calc.calculate();
            System.out.println(result);
        }catch(IOException ioe){
            System.out.println( ioe);
        }

    } 
}
