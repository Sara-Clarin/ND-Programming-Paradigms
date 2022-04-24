import java.sql.Timestamp;

public class steadyRunStrategy implements RunStrategy {
    
    private long newtimestamp;
    private long lasttimestamp;
    private double progress;
    private boolean init = false;

    @Override
    public double Advance( double metersRan){

        if (!init){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            lasttimestamp = timestamp.getTime();
            init = true;
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        newtimestamp = timestamp.getTime();

        progress += (newtimestamp -lasttimestamp) * .75 * 0.00025;

        lasttimestamp = newtimestamp;
        return progress;
    }
}
