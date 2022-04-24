import java.util.concurrent.TimeUnit;

public class Pipeline {
    
    public void createPipeLine(String filename){

        myFilter filter1 = new Filter1(filename);
        Runnable runnable1 = filter1;
        Thread thread = new Thread(runnable1);
        thread.start();
        // *********************************************
        myFilter filter2 = new Filter2(filter1);
        Runnable runnable2 = filter2;
        Thread thread2 = new Thread(runnable2);
        thread2.start();
        // *********************************************
        myFilter filter3 = new Filter3(filter2);
        Runnable runnable3 = filter3;
        Thread thread3 = new Thread(runnable3);
        thread3.start();
         // *********************************************
         Filter4 filter4 = new Filter4(filter3);
         Runnable runnable4 = filter4;
         Thread thread4 = new Thread(runnable4);
         thread4.start();
    }
}

