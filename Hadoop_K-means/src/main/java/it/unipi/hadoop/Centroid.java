package it.unipi.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;

public class Centroid implements WritableComparable<Centroid> {

    private Point point;

    private final IntWritable centroid_id;


    public Centroid(int centroid_id, ArrayList<Double> coords){
        this.centroid_id = new IntWritable(centroid_id);
        this.point=new Point(coords);
    }
    public  Centroid(){
        this.centroid_id=new IntWritable();
        this.point=new Point();
    }

    /* Writable implementation */

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this.centroid_id.write(dataOutput);
        this.point.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.centroid_id.readFields(dataInput);
        this.point.readFields(dataInput);
    }

    /* Getters and setters */

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public IntWritable getCentroid_id() {
        return centroid_id;
    }

    @Override
    public int compareTo(Centroid other) {
        // Confronta gli ID dei centroidi
        return Double.compare(this.getCentroid_id().get(), other.getCentroid_id().get());
    }
}
