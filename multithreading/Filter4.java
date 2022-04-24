import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class Filter4 implements myFilter{
    HashMap<Character, Integer> charCounts = new HashMap<>();
    private myFilter f3;
    private String inputstr;
    private long startTime, endTime, totalTime;

    @Override 
    public void run(){
        try{
            putString(); 
        }catch(InterruptedException ioe){
            System.out.println("Filter4: put interrupted");
        }
    }

    public Filter4(myFilter f3){
        this.f3 = f3;
        this.startTime = System.currentTimeMillis();
    }

    private void exitProtocol() throws InterruptedException{ // if we get an EOF, then f3 blocking queue already empty
        System.out.println("f4 exit protocol starting");
        displayCounts();
    }
    @Override
    public boolean blockQueueIsEmpty(){
       return false;
    }

    @Override                    // take from f2BlockQueue and splits into words
    public void putString() throws InterruptedException{
        while (true){
            inputstr = this.f3.getString();
            if (inputstr.equals("%%%")){
                exitProtocol();
                break;
            }

            for (int i = 0; i < inputstr.length(); i++){
                char c = inputstr.charAt(i);
                if (charCounts.containsKey(c)){
                    charCounts.put(c, charCounts.get(c) + 1);
                }else{        // Count characters in hashmap
                    charCounts.put(c, 1);
                }
            }
        }
    }
    public void displayCounts(){
        charCounts.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
        this.endTime = System.currentTimeMillis();
        this.totalTime = endTime - startTime;
        System.out.printf("Total Execution time was: %d milliseconds\n", this.totalTime );
    }

    @Override
    public String getString() throws InterruptedException{
        return "Dummy String";
    }
}