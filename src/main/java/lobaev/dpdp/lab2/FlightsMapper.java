package lobaev.dpdp.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsMapper extends Mapper<LongWritable, Text, AirportsWritable, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == 0) {
            return;
        }
        String[] mapped = value.toString().split(",");
        final String airport = mapped[14], delay = mapped[18]; //14 и 18 - позиции в строках, на которых находится d аэропорта и delay соответственно
        if (delay.length() > 0) {
            double flightDelay = Double.parseDouble(delay);
            if (flightDelay > 0) {
                context.write(new AirportsWritable(Integer.parseInt(airport), 1), new Text(delay));
            }
        }
    }

}
