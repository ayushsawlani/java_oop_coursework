//package test;
package IMT2018014;
import animation.SceneObject;


import java.util.ArrayList;
import java.util.Random;

import animation.BBox;
import animation.Point;
//package animation;
import animation.Scene;
import java.lang.Math;

public  class SawlaniObject extends SceneObject {

    private Point current=new Point(0,0);
    private Point dest=new Point(0,0);

	// a unique name for the object
    public String getObjName()
    {
        return "Mr. Sawlani";
    }

	// return the position of a representative point (local origin) of the object
	// in the window coordinates where it is being displayed
    public Point getPosition()
    {
        return current;
    }

    public void setPosition(int x, int y)
    {
        current.setPos(x, y);
    }
	
    public void setDestPosition(int x, int y)
    {
        dest.setPos(x, y);
    }

	// return the tightest fitting BBox for the shape
    public BBox getBBox()
    {
        Point iminp=new Point(current.getX()-5,current.getY()-5);
        Point imaxp=new Point(current.getX()+5,current.getY()+5);
        SawlaniBbox ans=new SawlaniBbox(iminp, imaxp);
        return ans;
    }


	// return the pathname of a .png or .jpg file that contains an icon for this
	// object. If non-null, this image will be used by graphical displays to render
	// the object

	// return the list of points that represent the shape of this object. The points
	// should be ordered so that by joining consecutive points, and joining the last
	// point
	// to the first point in the list, we get a closed outline of the object
	// Note: these points should represent the current position of the object
    protected ArrayList<Point> getOutline()
    {
        Point otherone=new Point(current.getX()+5, current.getY()-5);
        Point othertwo=new Point(current.getX()-5, current.getY()+5);

        ArrayList<Point> ans=new ArrayList<Point>();
        ans.add(otherone);
        ans.add(othertwo);
        ans.add(this.getBBox().getMinPt());
        ans.add(this.getBBox().getMaxPt());
        return ans;
    }

	// compute the new position of the object after it moves for deltaT
    protected void updatePos(int deltaT)
    {
        Random rand = new Random();
        int dx=0,dy=0;
        int speed=1;
        if((this.current.getX()==this.dest.getX())&&(this.current.getX()==this.dest.getX()));
        else if((this.current.getX()==this.dest.getX()))
        {
            dx=0;
            dy=2;
        }
        else if((this.current.getY()==this.dest.getY()))
        {
            dy=0;
            dx=2;
        }
        else
        {
            double m=((double)(this.current.getY()-this.dest.getY()))/((double)(this.current.getX()-this.dest.getX()));
            dx=(int)((4*1)/(Math.sqrt(1+m*m)));
            dy=(int)((4*m)/(Math.sqrt(1+m*m)));
            if(dx==0)
                dx=4;
            if(dy==0)
            {
                if(m>0)
                    dy=4;
                else
                    dy=-4;
            }
            if((this.current.getX()>this.dest.getX())&&(dx>0))
            {
                if(dx==0)
                    dx=5;
                dx=(-1)*dx;
            }
            if((this.current.getY()>this.dest.getY())&&(dy>0))
            {
                if(dy==0)
                    dy=5;
                dy=(-1)*dy;
            }
            if((this.current.getY()<this.dest.getY())&&(dy<0))
            {
                if(dy==0)
                    dy=-5;
                dy=(-1)*dy;
            }
        }
        current.setPos(current.getX()+dx, current.getY()+dy);
        Scene s=Scene.getScene();
        int check=0;
        for(int i=0;i<s.getActors().size();i++)
        {
            if((this.getBBox().intersects(s.getActors().get(i).getBBox()))&&(s.getActors().get(i)!=this))
            {
                check=1;
                break;
            }
        }
        for(int i=0;i<s.getObstacles().size();i++)
        {
            if((this.getBBox().intersects(s.getObstacles().get(i).getBBox())))
            {
                check=1;
                break;
            }
        }
        while(check==1)
        {
            int r1=rand.nextInt(50000);
            int r2=rand.nextInt(50000);
            int sign1=rand.nextInt(2);
            int sign2=rand.nextInt(2);
            if(sign1==0)
                sign1--;
            if(sign2==0)
                sign2--;
            double m=(double)(r1)/(double)(r2);
            current.setPos(current.getX()-dx,current.getY()-dy);
            speed=rand.nextInt(2);
            dx=(int)((1*4*speed)/(Math.sqrt(1+m*m)))*sign1;
            dy=(int)((m*speed*4)/(Math.sqrt(1+m*m)))*sign2;
            if(m!=0)
            {
                if(dx==0)
                    dx=2*sign1;
                if(dy==0)
                    dy=2*sign2;
            }
            current.setPos(current.getX()+dx,current.getY()+dy);
            check=0;
            for(int i=0;i<s.getActors().size();i++)
            {
                if((this.getBBox().intersects(s.getActors().get(i).getBBox()))&&(s.getActors().get(i)!=this))
                {
                    check=1;
                    break;
                }
            }
            for(int i=0;i<s.getObstacles().size();i++)
            {
                if((this.getBBox().intersects(s.getObstacles().get(i).getBBox())))
                {
                    check=1;
                    break;
                }
            }
        }
    }
}
