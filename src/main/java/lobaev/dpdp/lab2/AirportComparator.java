package lobaev.dpdp.lab2;

import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {

    AirportComparator() {
        super(AirportsWritable.class, true)
    }

}
