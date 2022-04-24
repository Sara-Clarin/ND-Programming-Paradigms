import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Filter3 implements myFilter{
    private BlockingQueue<String> f3BlockQueue = new LinkedBlockingQueue<String>(20);
    private String[] splitstr;
    private myFilter f2;
    private String inputstr;
    boolean status = true;

    @Override 
    public void run(){
        try{
             putString(); 
        }catch(InterruptedException ioe){
            System.out.println("Filter3: put interrupted");
        }
        if (status == false){
            System.out.println("Exiting run(): F3");
        }
    }

    public Filter3(myFilter f2){
        this.f2 = f2;
    }
    public void exitProtocol()throws InterruptedException{
        System.out.println("Filter3 exit protocol starting");

        while( !f2.blockQueueIsEmpty() ){
            inputstr = this.f2.getString();
            System.out.print("F3: placing ");
            splitstr = inputstr.split(" ");
            for (int i = 1; i < splitstr.length; i++){
                System.out.printf("%s, ", splitstr[i]);
                this.f3BlockQueue.put(splitstr[i]);             // place into blocking queue
            }
        }
        this.f3BlockQueue.put("%%%");
        System.out.println("After break statement of F3 protocol");
    }

    @Override                    // take from f2BlockQueue and splits into words
    public void putString() throws InterruptedException{
        while (true){
            inputstr = this.f2.getString();
            if (inputstr.equals("EOF")){
                exitProtocol();
                //return false;
                break;
            }
            System.out.println("F3 didn't shut down");
            splitstr = inputstr.split(" ");

            System.out.print("F3: placing ");
            for (int i = 1; i < splitstr.length; i++){
                System.out.printf("%s, ", splitstr[i]);
                this.f3BlockQueue.put(splitstr[i]);             // place into blocking queue
            }
        }
    }

    @Override
    public boolean blockQueueIsEmpty(){
        return this.f3BlockQueue.isEmpty();
    }
    
    @Override
    public String getString() throws InterruptedException{
        return this.f3BlockQueue.take();
    }
}