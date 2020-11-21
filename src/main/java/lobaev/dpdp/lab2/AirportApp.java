package lobaev.dpdp.lab2;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AirportApp {

    public static void main(String[] args) throws Throwable {
        if (args.length != 3) {
            System.err.println("Usage: AirportApp <input path 1> <input path 2> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(AirportApp.class);
        job.setJobName("AirportApp");
        //FileInputFormat.addInputPath(job, new Path(args[0]));
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, null);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, null);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setGroupingComparatorClass(AirportsComparator.class);
        job.setPartitionerClass(AirportsPartitioner.class);
        job.setReducerClass(null);
        //job.setMapperClass(WordMapper.class);
        //job.setReducerClass(WordReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
