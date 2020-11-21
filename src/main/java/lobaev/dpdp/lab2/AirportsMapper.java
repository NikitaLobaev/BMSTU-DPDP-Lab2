package lobaev.dpdp.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportsMapper extends Mapper<LongWritable, Text, AirportsWritable, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //super.map(key, value, context);
        if (key.get() != 0) { //
            String[] airports = value.toString().split(",");
            context.write(new AirportsWritable(Integer.parseInt(airports[0]), 0), new Text(airports[1]));
        }
    }
}
