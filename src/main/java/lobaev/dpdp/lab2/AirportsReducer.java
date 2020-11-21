package lobaev.dpdp.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportsReducer extends Reducer<AirportsWritable, Text, Text, Text> {

    @Override
    protected void reduce(AirportsWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //super.reduce(key, values, context);
        int c = 0;
        double delaysSum = 0, delayAverage, delayMin = Double.MAX_VALUE, delayMax = Double.MIN_VALUE;
        Iterator<Text> iterator = values.iterator();
        String name = iterator.next().toString(); //название аэропорта
        while (iterator.hasNext()) {
            double d = Double.parseDouble(iterator.next().toString());
            delaysSum += d;
            if (delayMin > d) {
                delayMin = d;
            }
            if (delayMax < d) {
                delayMax = d;
            }
            c++;
        }
        if (c > 0) {
            delayAverage = delaysSum / c;
            
        }
    }

}
