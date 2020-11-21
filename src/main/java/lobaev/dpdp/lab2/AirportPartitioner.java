package lobaev.dpdp.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<AirportsWritable, Text> {

    @Override
    public int getPartition(AirportsWritable airportsWritable, Text text, int i) {
        return 0;
    }
}
