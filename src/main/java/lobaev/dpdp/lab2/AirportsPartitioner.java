package lobaev.dpdp.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportsPartitioner extends Partitioner<AirportsWritable, Text> {

    @Override
    public int getPartition(AirportsWritable airportsWritable, Text text, int i) {
        return airportsWritable.getCode() % i;
    }

}
