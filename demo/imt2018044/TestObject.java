package imt2018044;

import java.util.*;
import java.util.*;
import animation.BBox;
import animation.Point;
import animation.SceneObject;

public class TestObject extends SceneObject{
    private Point POSITION;
    private double SPEED;
    private Point DEST;
    private ArrayList<Point> Bound_point;
    private int Id_no;
    private static int Next_Id =0;

    public TestObject(){
        this.SPEED = 10.0;
        this.Id_no = TestObject.Next_Id++;
        this.POSITION = new Point(0,0);
        this.DEST = new Point(0,0);
        this.Bound_point=new ArrayList<Point>();
        this.Bound_point.add(new Point(0,0));
        this.Bound_point.add(new Point(0,10));
        this.Bound_point.add(new Point(10,10));
        this.Bound_point.add(new Point(10,0));
    }

    public String getObjName(){
        return "TestObject " + this.Id_no;
    }

    public String toString() {
        return this.getObjName();
    }

    public Point getPosition(){
        System.out.println(this.POSITION.getX());
        System.out.println(this.POSITION.getY());
        return new Point(this.POSITION);
    }

    public void setPosition(final int x, final int y) {
        this.POSITION.setPos(x, y);
    }
    
    public void setDestPosition(final int x, final int y) {
        this.DEST.setPos(x, y);
    }

    public Point getDEST()
    {
        return DEST;
    }
    
    public BBox getBBox() {
        return (BBox)new TestBBox(this.Bound_point, this.POSITION);
    }
    
    protected ArrayList<Point> getOutline() {
        return new ArrayList<Point>(this.Bound_point);
    }
    
    protected void updatePos(int deltaT) {

        if(this.POSITION.getX()!= this.DEST.getX()|| this.POSITION.getY()!=this.DEST.getY())
        {
        if(this.POSITION.getX()-this.DEST.getX()>=20)
            this.POSITION.setPos(this.POSITION.getX()-20,this.POSITION.getY());
        if(this.POSITION.getX()-this.DEST.getX()>0 && this.POSITION.getX()-this.DEST.getX()<20)
            this.POSITION.setPos(this.POSITION.getX()-(this.POSITION.getX()-this.DEST.getX()),this.POSITION.getY());
        if(this.POSITION.getX()-this.DEST.getX()<=-20)
            this.POSITION.setPos(this.POSITION.getX()+20,this.POSITION.getY());
        if(this.POSITION.getX()-this.DEST.getX()<0 && this.POSITION.getX()-this.DEST.getX()>-20)
            this.POSITION.setPos(this.POSITION.getX()-(this.POSITION.getX()-this.DEST.getX()),this.POSITION.getY());

        if(this.POSITION.getY()-this.DEST.getY()>=20)
            this.POSITION.setPos(this.POSITION.getX(),this.POSITION.getY()-20);
        if(this.POSITION.getY()-this.DEST.getY()>0 && this.POSITION.getY()-this.DEST.getY()<20)
            this.POSITION.setPos(this.POSITION.getX(),this.POSITION.getY()-(this.POSITION.getY()-this.DEST.getY()));
        if(this.POSITION.getY()-this.DEST.getY()<=-20)
            this.POSITION.setPos(this.POSITION.getX(),this.POSITION.getY()+20);
        if(this.POSITION.getX()-this.DEST.getY()<0 && this.POSITION.getY()-this.DEST.getY()>-20)
            this.POSITION.setPos(this.POSITION.getX(),this.POSITION.getY()-(this.POSITION.getX()-this.DEST.getX()));
        }
        else
        {
            this.POSITION.setPos(this.DEST.getX(),this.DEST.getY());
        }
    }
}
