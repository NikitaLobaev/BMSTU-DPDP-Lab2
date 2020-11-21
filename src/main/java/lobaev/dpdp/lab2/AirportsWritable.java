package lobaev.dpdp.lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportsWritable implements WritableComparable<AirportsWritable> {

    private Integer index, code;

    AirportsWritable(Integer index, Integer code) {
        this.index = index;
        this.code = code;
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override
    public int compareTo(AirportsWritable airportsWritable) {
        int c = this.code.compareTo(airportsWritable.code);
        if (c != 0) {
            return c;
        }
        return this.index.compareTo(airportsWritable.index);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.code);
        dataOutput.writeInt(this.index);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.index = dataInput.readInt();
        this.code = dataInput.readInt();
    }

    public Integer getCode() {
        return this.code;
    }

}
