import java.sql.Timestamp;
import java.time.Instant;

public class earlySprintStrategy implements  RunStrategy{

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

        if ( metersRan < 4){
            progress += (newtimestamp -lasttimestamp) * 1 * 0.00025;
        }else{
            progress += (newtimestamp -lasttimestamp) * 0.7 * 0.00025;
        }

        lasttimestamp = newtimestamp;
        return progress;
    }
}