import java.beans.Transient;

import org.junit.*;

public class TestFilter2 {
    

    @Test 
    public void UpperCaseConvertShouldReturnUppercase(){
        myFilter myF2 = new Filter2();
        Assert.assertEquals("alowerCaseword", "ALOWERCASEWORD");
    }

    @Test
    public void getStringWithBlockQueueShouldReturnWord(){
        myFilter f1 = new Filter1("example1.txt");
        Filter2 myF2 = new Filter2(f1);
        try{
            myF2.f2BlockQueue.put("someword");
        }catch(InterruptedException ioe){

        }try{
            Assert.assertEquals("someword", myF2.getString());
        }catch(InterruptedException ioe){
            
        }
    }
}
