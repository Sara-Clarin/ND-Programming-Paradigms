import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Filter2 implements myFilter{

        public String linefromFile;
        private myFilter f1;
        public BlockingQueue<String> f2BlockQueue = new LinkedBlockingQueue<String>(10);

        public Filter2(myFilter f1){
           this.f1 = f1;
        }

        @Override 
        public void run(){   // setoff by thread.start()
            
            try{
                putString(); 
            }catch(InterruptedException ioe){
                System.out.println("Filter2: put interrupted");
            }
        }
        private String processString( String str){
            str = str.toUpperCase();
            String[] stringArray = str.split(" ");
            String result = new String();
            for(int i = 0; i < stringArray.length;i++){
                result = result+ " " + stringArray[i].replaceAll("[^A-Z]", "");
            }
            return result;
        }

        public void exitProtocol() throws InterruptedException{
            System.out.println("f2 exit protocol starting");
            while(!f1.blockQueueIsEmpty()){
                linefromFile = this.f1.getString();
                System.out.printf("F2 taking: %s", linefromFile);   // should I sleep here to wait for thread?
                String uppercaseClean = processString(linefromFile);
              
                this.f2BlockQueue.put(uppercaseClean);             // place into blocking queue
                System.out.printf("\nFilter2: translated: %s", uppercaseClean);
            }
            this.f2BlockQueue.put("EOF");
            System.out.println("after f2 loop");
        }
        @Override                    // take from f1BlockQueue and translate to UpperCase
        public void putString() throws InterruptedException{

            while(true){
                linefromFile = this.f1.getString();
                if (linefromFile.equals("EOF")){
                    exitProtocol();
                    break;
                }

                System.out.printf("F2 taking: %s", linefromFile);   // should I sleep here to wait for thread?
                String uppercaseClean = processString(linefromFile);
              
                this.f2BlockQueue.put(uppercaseClean);             // place into blocking queue
                System.out.printf("\nFilter2: translated: %s", uppercaseClean);
            }
        }

        @Override
        public boolean blockQueueIsEmpty(){
            return this.f2BlockQueue.isEmpty();
        }

        @Override
        public String getString() throws InterruptedException{

                return this.f2BlockQueue.take();
        }
}
