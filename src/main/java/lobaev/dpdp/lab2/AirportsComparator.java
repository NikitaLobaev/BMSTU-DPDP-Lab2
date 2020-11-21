package lobaev.dpdp.lab2;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportsComparator extends WritableComparator {

    AirportsComparator() {
        super(AirportsWritable.class, true);
    }

    @Override
    public int compare(WritableComparable writableComparable1, WritableComparable writableComparable2) {
        AirportsWritable airportsWritable1 = (AirportsWritable) writableComparable1,
        airportsWritable2 = (AirportsWritable) writableComparable2;
        return airportsWritable1.getCode().compareTo(airportsWritable2.getCode());
    }

}
