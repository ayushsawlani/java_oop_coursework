//package test;
package IMT2018014;
import java.util.*;
import animation.BBox;
import animation.Point;

public class SawlaniBbox implements BBox
{
    private Point minp,maxp;
        // return the bottom-left corner of the bounding box
    public SawlaniBbox(Point iminp, Point imaxp)
    {
        this.minp=iminp;
        this.maxp=imaxp;
    }
    public Point getMinPt()
    {
        return minp;
    }
	
	// return the top-right corner of the bounding box
    public Point getMaxPt()
    {
        return maxp;
    }
	
	// does this box intersect/overlap the input BBox
    public boolean intersects(BBox b)
    {
        if(((this.minp.getX()>b.getMaxPt().getX())||(this.maxp.getX()<b.getMinPt().getX()))||((this.minp.getY()>b.getMaxPt().getY())||(this.maxp.getY()<b.getMinPt().getY())))
            return false;
        return true;
    }
}