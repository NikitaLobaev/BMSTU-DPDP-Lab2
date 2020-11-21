package lobaev.dpdp.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class AirportsReducer extends Reducer<AirportsWritable, Text, Text, Text> {

    @Override
    protected void reduce(AirportsWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //super.reduce(key, values, context);
        
    }

}
