package imt2018044;

import java.util.*;
import java.io.*;
import animation.Point;
import animation.BBox;

public class TestBBox implements BBox{
    private Point minimum;
    private Point maximum;
    TestBBox(Point min,Point max)
    {
        this.minimum=min;
        this.maximum=max;
    }
    TestBBox(ArrayList<Point> Bound_point,Point shift)
    {
        int x_min = Bound_point.get(0).getX();
        int x_max = 0;
        int y_min = Bound_point.get(0).getY();
        int y_max = 0;
        for(int i=0; i< Bound_point.size();i++)
        {
            Point temp = Bound_point.get(i);
            if(temp.getX() < x_min)
                x_min=temp.getX();
            else if(temp.getX()> x_max)
                x_max=temp.getX();
            if(temp.getY() < y_min)
                y_min=temp.getY();
            else if(temp.getY() > y_max)
                y_max=temp.getY();
        }
        this.minimum = new Point(x_min+shift.getX(),y_min+shift.getY());
        this.maximum = new Point(x_max+shift.getX(),y_max+shift.getY());
    }
    public Point getMinPt(){
        return this.minimum;
    }
    public Point getMaxPt(){
        return this.maximum;
    }
    public boolean intersects(BBox box)
    {
        if(this.minimum.getX()>box.getMaxPt().getX())
            return false;
        if(this.maximum.getX()<box.getMinPt().getX())
            return false;
        if(this.minimum.getY()>box.getMaxPt().getY())
            return false;
        if(this.maximum.getY()<box.getMinPt().getY())
            return false;
        else
            return true;
    }
    public boolean contains(Point pt)
    {
        return pt.getX() >= this.minimum.getX() &&  pt.getX() <= this.maximum.getX() && pt.getY() >= this.minimum.getY() && pt.getY()<= this.maximum.getY();
    }
    @Override
    public String toString() {
        return "[( " + this.minimum.getX() + " ," + this.minimum.getY() + " ), ( " + this.maximum.getX() + " , " + this.maximum.getY() + " )]";
    }
}
