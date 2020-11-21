package lobaev.dpdp.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class AirportsReducer extends Reducer<AirportsWritable, Text, Text, Text> {

    @Override
    protected void reduce(AirportsWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //super.reduce(key, values, context);
        int c = 0;
        String name; //название аэропорта
        double delaysSum = 0, delayAverage, delayMin = Double.MIN_VALUE, delayMax = Double.MAX_VALUE;
        
    }

}
