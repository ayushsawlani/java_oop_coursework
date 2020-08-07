package imt2018032;

import java.util.ArrayList;

import animation.BBox;
import animation.Point;
import animation.SceneObject;
import animation.Point;

public class DemoSceneObject extends SceneObject implements BBox{

	String object_name = "Object";
	Point object_position = new Point(0, 0);
	Point object_destination = new Point(0, 0);
	int width=10, height=10;
	//BBox box;
	//BBox box = new DemoSceneObject("box", object_position);
 
	public DemoSceneObject()
	{
		//Point object_position = new Point(0, 0);
		//Point object_destination = new Point(0, 0);
	}

	public DemoSceneObject(String name, Point position, Point destination)
	{
		super();
		object_name = name;
		object_position = new Point(position);
		object_destination = new Point(destination); 
	}

	public DemoSceneObject(String name, Point position)
	{
		super();
		object_name = name;
		object_position = new Point(position); 
	}

	@Override
	public String getObjName() {
		// TODO Auto-generated method stub
		return object_name;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return object_position;
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		// System.out.println(this);
		// System.out.println(this.object_position);
		this.object_position.setPos(x, y);
		// System.out.println(this.object_position);
		
	}

	public void setDestPosition(int x, int y) {
		object_destination.setPos(x, y);
	} 

	public Point getMinPt()
	{
		return object_position;
	}

	public Point getMaxPt()
	{
		Point max = new Point(object_position.getX()+width, object_position.getY()+height);
		return max;
	}

	public boolean intersects(BBox b)
	{
		if ((b.getMinPt().getX() > (this.getMinPt().getX()+width) || (this.getMinPt().getX()) > (b.getMinPt().getX()+width)))
            return false; 
            
        if ((b.getMinPt().getY()+ height) > (this.getMinPt().getY()) || (this.getMinPt().getY()+height) > (b.getMinPt().getY())) 
            return false; 
				
		return true;
	}
	@Override
	public BBox getBBox() {
		// TODO Auto-generated method stub
		return this;
	}

	// boolean intersects(BBox b);

	@Override
	protected ArrayList<Point> getOutline() {
		// TODO Auto-generated method stub
		ArrayList<Point> outline = new ArrayList<Point>();
		outline.add(object_position);
		Point p2 = new Point(0, 0);
		p2.setPos(object_position.getX(), object_position.getY()+height);
		outline.add(p2);
		Point p3 = new Point(0, 0);
		p3.setPos(object_position.getX()+width, object_position.getY()+height);
		outline.add(p3);
		Point p4 = new Point(0, 0);
		p4.setPos(object_position.getX()+width, object_position.getY());
		outline.add(p4);
		return outline;

	}

	@Override
	protected void updatePos(int deltaT) {
		// TODO Auto-generated method stub
		// object_position.x = object_destination.x - width;
		// System.out.println("JANVI");
		// System.out.println(getBBox());
		// System.out.println(getBBox().getMinPt());
		deltaT = deltaT/500;
		if((getBBox().getMinPt().getX() < (object_destination.getX() - width)) && (object_destination.getX()-(getBBox().getMinPt().getX()+width))>5*(deltaT))
		{
			getBBox().getMinPt().setPos(getBBox().getMinPt().getX()+5*(deltaT), getBBox().getMinPt().getY());
			// if(getBBox().getMinPt().getX()+5*(deltaT)>object_destination.getX())
			// {
			// 	getBBox().getMinPt().setPos(object_destination.getX(), getBBox().getMinPt().getY());
			// }
			// else
			// {
			// 	getBBox().getMinPt().setPos(getBBox().getMinPt().getX()+20*(deltaT), getBBox().getMinPt().getY());
			// }
		}
		if((getBBox().getMinPt().getX() < (object_destination.getX() - width)) && (object_destination.getX()-(getBBox().getMinPt().getX()+width))<5*deltaT)
		{
			//getBBox().getMinPt().setPos(object_destination.getX()-(getBBox().getMinPt().getX()+width), getBBox().getMinPt().getY());
			getBBox().getMinPt().setPos(object_destination.getX(), getBBox().getMinPt().getY());

		}
		if((getBBox().getMinPt().getX() > (object_destination.getX() + width)) && (getBBox().getMinPt().getX()-width)-object_destination.getX()>5*(deltaT))
		{
			getBBox().getMinPt().setPos(getBBox().getMinPt().getX()-5*(deltaT), getBBox().getMinPt().getY());
			// if(getBBox().getMinPt().getX()-20*(deltaT)>object_destination.getX())
			// {
			// 	getBBox().getMinPt().setPos(object_destination.getX(), getBBox().getMinPt().getY());
			// }
			// else
			// {
			// 	getBBox().getMinPt().setPos(getBBox().getMinPt().getX()-5*(deltaT), getBBox().getMinPt().getY());
			// }
		}
		if((getBBox().getMinPt().getX() > (object_destination.getX() + width)) && (getBBox().getMinPt().getX()-width)-object_destination.getX()<5*deltaT)
		{
			//getBBox().getMinPt().setPos(object_destination.getX()-(getBBox().getMinPt().getX()+width), getBBox().getMinPt().getY());
			getBBox().getMinPt().setPos(object_destination.getX(), getBBox().getMinPt().getY());

		}
		if(getBBox().getMinPt().getX()==object_destination.getX())
		{
			if((getBBox().getMinPt().getY() < (object_destination.getY()-height)) && (object_destination.getY()-(getBBox().getMinPt().getY()+height))>5*deltaT)
			{
				getBBox().getMinPt().setPos(getBBox().getMinPt().getX(),getBBox().getMinPt().getY()+5*deltaT);
				// if(getBBox().getMinPt().getY()+20*(deltaT)>object_destination.getY())
				// {
				// 	getBBox().getMinPt().setPos( getBBox().getMinPt().getX(),object_destination.getY());
				// }
				// else
				// {
				// 	getBBox().getMinPt().setPos(getBBox().getMinPt().getX(), getBBox().getMinPt().getY()+5*deltaT);
				// }
			}
			if((getBBox().getMinPt().getY() < (object_destination.getY() - height)) && (object_destination.getY()-(getBBox().getMinPt().getY()+height))<5*deltaT)
			{
				//getBBox().getMinPt().setPos(getBBox().getMinPt().getX(),object_destination.getY()-(getBBox().getMinPt().getY()+height));
				getBBox().getMinPt().setPos(getBBox().getMinPt().getX(),object_destination.getY());

			}
			if((getBBox().getMinPt().getY() > (object_destination.getY()+height)) && (getBBox().getMinPt().getY()+height)-object_destination.getY()>5*deltaT)
			{
				getBBox().getMinPt().setPos(getBBox().getMinPt().getX(),getBBox().getMinPt().getY()-5*deltaT);
				// if(getBBox().getMinPt().getY()+20*(deltaT)>object_destination.getY())
				// {
				// 	getBBox().getMinPt().setPos( getBBox().getMinPt().getX(),object_destination.getY());
				// }
				// else
				// {
				// 	getBBox().getMinPt().setPos(getBBox().getMinPt().getX(), getBBox().getMinPt().getY()+5*deltaT);
				// }
			}
			if((getBBox().getMinPt().getY() > (object_destination.getY() + height)) && (getBBox().getMinPt().getY()+height)-object_destination.getY()<5*deltaT)
			{
				//getBBox().getMinPt().setPos(getBBox().getMinPt().getX(),object_destination.getY()-(getBBox().getMinPt().getY()+height));
				getBBox().getMinPt().setPos(getBBox().getMinPt().getX(),object_destination.getY());

			}
		}
	}

}
