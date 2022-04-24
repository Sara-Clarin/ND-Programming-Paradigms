import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
class Main
{
    // Read a string from the standard input using `BufferedReader`
    public static void main(String[] args)
    {
        List<String> tokens = new ArrayList<>();
        BufferedReader br = null;
 
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            while (st != null && st.hasMoreElements()) {
                tokens.add(st.nextToken());
            }
 
            System.out.println(tokens);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
