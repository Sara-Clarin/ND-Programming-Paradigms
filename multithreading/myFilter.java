
public interface myFilter extends Runnable{
    
    public void putString() throws InterruptedException;
    public String getString() throws InterruptedException;
    public boolean blockQueueIsEmpty();

}
