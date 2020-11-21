package lobaev.dpdp.lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportsWritable implements WritableComparable<AirportsWritable> {

    private int index, code;

    @Override
    public void write(DataOutput var1) throws IOException {
        var1.writeInt(code);
        var1.writeInt(index);
    }

    @Override
    public void readFields(DataInput var1) throws IOException {

    }

}
