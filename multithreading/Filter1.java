
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Filter1 implements myFilter{

    public BlockingQueue<String> outputBlockQueue = new LinkedBlockingQueue<String>(10);
    public String linefromFile;
    private String Fname;

    public Filter1(String filename){
        this.Fname = filename;
    }

    @Override 
    public void run(){   // setoff by thread.start()
        try{
            putString(); 
        }catch(InterruptedException ioe){
            System.out.println("Filter1 was interrupted");
        }
        
    }

    @Override
    public void putString() throws InterruptedException{   // read file line by line
        System.out.println("Please enter name of txt file:");
        String filename = "";String line = "";
        BufferedReader filereader = null;
    
        try{
            filereader = new BufferedReader(new FileReader(this.Fname));
        }catch(FileNotFoundException fnfe2){
            System.out.println("File is not in current directory or does not exist");
        }
        boolean exitloop = false;
        while( !exitloop){  // check string.contains(EOF)

            try{
                line = filereader.readLine();
            }catch (IOException ioe){
                System.out.println("First break: EOF reached");
                outputBlockQueue.put("EOF");
                exitloop = true;
                break;
            }

            while(line != null){
                    outputBlockQueue.put(line);
                    System.out.printf("\nReading line: ");System.out.println(line);
                    try{
                        line = filereader.readLine();
                    }catch (IOException ioe){
                        System.out.println("End of file was reached!");
                        outputBlockQueue.put("EOF");
                        exitloop = true;
                        break;
                    }
                    //Thread.sleep(1000);
             }
            try{
                filereader.close();
             }catch(IOException ioe){
                System.out.println("Error closing file");
            }  
        }
    }

    @Override
    public String getString() throws InterruptedException{
            return outputBlockQueue.take();
    }
    
    @Override
    public boolean blockQueueIsEmpty(){
        return this.outputBlockQueue.isEmpty();
    }
}
