package imt2018072;

import java.util.*;

import animation.BBox;
import animation.Point;
import animation.SceneObject;
import animation.Scene;

public class mySceneObject extends SceneObject implements BBox
{
    Point currentPosition;  
    Point nextPosition;
    Point destinationPosition;  // all given by bottom left corner
    String ObjName;
    static int count=0;
    // For BBox
    Point bottomLeft;
    Point topRight;
    Point nextBottomLeft;
    Point nextTopRight;
    Scene itsScene;


    public mySceneObject()
    {
        currentPosition = new Point(0, 0);
        nextPosition = new Point(0,0);
        destinationPosition = new Point(0, 0);
        
        bottomLeft = new Point(0, 0);
        topRight = new Point(0, 0);
        nextBottomLeft = new Point(0, 0);
        nextTopRight = new Point(0, 0);
        
        count++;
        ObjName = "Obj:" + count;
        
        bottomLeft.setPos(0, 0);
        topRight.setPos(40, 40);
        itsScene = Scene.getScene(); 
        // We are assuming that size of the bbox is 40*40
    }


	@Override
	public String getObjName() {
		//
		return ObjName;
	}

	@Override
    public Point getPosition() 
    {
		return currentPosition;
	}

	@Override
    public void setPosition(int x, int y) 
    {
        currentPosition.setPos(x, y);

        // Updating the BBox
        // x and y are the new coordinates of bottomLeft
        int deltax = getMaxPt().getX() - getMinPt().getX();
        int deltay = getMaxPt().getY() - getMinPt().getY();
        
        getMinPt().setPos(x, y);
        getMaxPt().setPos(x+deltax, y+deltay);

	}

    public void setDestPosition(int x, int y) 
    {
        destinationPosition.setPos(x, y);
	}
	
	@Override
    public BBox getBBox() 
    {
        // We construct a class called BBox_class which implements BBox
        // But it also has an additional attribute the max and min of the 
        // BBox i.e the bottom-left and the top-right corner.
        return this;
	}

	@Override
    protected ArrayList<Point> getOutline() 
    {
        ArrayList<Point> pointList = new ArrayList<Point>(); 
        // For time being our object is rectangle
        // So there will be 4 points
        pointList.add(currentPosition);
        pointList.add(topRight);
        
        Point leftTop = new Point(currentPosition.getX(), topRight.getY());
        pointList.add(leftTop);

        Point rightBottom = new Point(topRight.getX(), currentPosition.getY());
        pointList.add(rightBottom);

        return pointList;
	}

	@Override
    protected void updatePos(int deltaT) 
    {
        int xi = getPosition().getX();
        int yi = getPosition().getY();

        int xf = destinationPosition.getX();
        int yf = destinationPosition.getY();

        // 1 is up
        // 2 is right
        // 3 is down
        // 4 is left

        // int manh_dist;
        ArrayList<Integer> validMoves = new ArrayList<Integer>();
        // validMoves.add(0);

        if(yf>yi)   // Up
        {
            nextPosition.setPos(xi, yi+10);
            nextBottomLeft.setPos(xi, yi+10);
            nextTopRight.setPos(topRight.getX(), topRight.getY()+10);
            
            if(check_if_it_is_a_validMove())
            {
                validMoves.add(1);
            }
            else 
            {
                nextPosition.setPos(xi, yi-10);
                nextBottomLeft.setPos(xi, yi-10);
                nextTopRight.setPos(topRight.getX(), topRight.getY()-10);
                
                if(check_if_it_is_a_validMove())
                {
                    validMoves.add(3);
                } 
            }
        }
        if(xi<xf)   // Right
        {
            nextPosition.setPos(xi+10, yi);
            nextBottomLeft.setPos(xi+10, yi);
            nextTopRight.setPos(topRight.getX()+10, topRight.getY());
            
            if(check_if_it_is_a_validMove())
            {
                validMoves.add(2);
            }
            else
            {
                nextPosition.setPos(xi-10, yi);
                nextBottomLeft.setPos(xi-10, yi);
                nextTopRight.setPos(topRight.getX()-10, topRight.getY());
                
                if(check_if_it_is_a_validMove())
                {
                    validMoves.add(4);
                }
            }
        }
        if(yf<yi)   // Down
        {
            nextPosition.setPos(xi, yi-10);
            nextBottomLeft.setPos(xi, yi-10);
            nextTopRight.setPos(topRight.getX(), topRight.getY()-10);
            
            if(check_if_it_is_a_validMove())
            {
                validMoves.add(3);
            }
            else
            {
                nextPosition.setPos(xi, yi+10);
                nextBottomLeft.setPos(xi, yi+10);
                nextTopRight.setPos(topRight.getX(), topRight.getY()+10);
                
                if(check_if_it_is_a_validMove())
                {
                    validMoves.add(1);
                }              
            }
        }
        if(xi>xf)   // Left
        {
            nextPosition.setPos(xi-10, yi);
            nextBottomLeft.setPos(xi-10, yi);
            nextTopRight.setPos(topRight.getX()-10, topRight.getY());
            
            if(check_if_it_is_a_validMove())
            {
                validMoves.add(4);
            }
            else
            {
                nextPosition.setPos(xi+10, yi);
                nextBottomLeft.setPos(xi+10, yi);
                nextTopRight.setPos(topRight.getX()+10, topRight.getY());
                
                if(check_if_it_is_a_validMove())
                {
                    validMoves.add(2);
                }        
            }
        }

        ArrayList<Integer> man_dist = new ArrayList<Integer>();
        Integer min_d = 400000;     // Some large value
        // man_dist.add(40000);
        // someVmove is some valid move which can be 1, 2, 3, 4
        for(Integer someVmove : validMoves)
        {
            if(someVmove==1)    // Up
            {
                Integer temp = Math.abs(currentPosition.getX()-destinationPosition.getX()) + Math.abs(currentPosition.getY()+10 - destinationPosition.getY());
                man_dist.add(temp);
                min_d = Math.min(temp, min_d);
            }

            else if(someVmove==2)    // Right
            {
                Integer temp = Math.abs(currentPosition.getX()+10-destinationPosition.getX()) + Math.abs(currentPosition.getY() - destinationPosition.getY());
                man_dist.add(temp);
                min_d = Math.min(temp, min_d);
            }

            else if(someVmove==3)    // Down
            {
                Integer temp = Math.abs(currentPosition.getX()-destinationPosition.getX()) + Math.abs(currentPosition.getY()-10 - destinationPosition.getY());
                man_dist.add(temp);
                min_d = Math.min(temp, min_d);
            }

            else if(someVmove==4)    // Left
            {
                Integer temp = Math.abs(currentPosition.getX()-10-destinationPosition.getX()) + Math.abs(currentPosition.getY() - destinationPosition.getY());
                man_dist.add(temp);
                min_d = Math.min(temp, min_d);
            }
        }

        // Now perform that move
        Integer index = man_dist.indexOf(min_d);

        // Random rand = new Random();

        if(Math.abs(destinationPosition.getX()-currentPosition.getX()) + Math.abs(destinationPosition.getY()-currentPosition.getY()) <= 30)
        {
            setPosition(destinationPosition.getX(), destinationPosition.getY());
            return;
        }

        else if(validMoves.get(index) == 1)  // Up
        {
            setPosition(xi, yi+10);
        }
        else if(validMoves.get(index) == 2)  // Right
        {
            setPosition(xi+10, yi);
        }
        else if(validMoves.get(index) == 3)  // Down
        {
            setPosition(xi, yi-10);
        }
        else if(validMoves.get(index) == 4)  // Left
        {
            setPosition(xi-10, yi);
        }
        

}
    


    protected boolean check_if_it_is_a_validMove()
    {
        ArrayList<SceneObject> actorsList = itsScene.getActors();
        ArrayList<SceneObject> obstaclesList = itsScene.getObstacles();

        for(int j=0;j<actorsList.size();j++)
        {
            if(this!= actorsList.get(j) && intersects(actorsList.get(j).getBBox()))
            {
                return false;
            }
        }

        for(int k=0;k<obstaclesList.size();k++)
        {
            if(intersects(obstaclesList.get(k).getBBox()))
            {
                return false;
            }
        }
        return true;   
    }


    
    // return the bottom-left corner of the bounding box
    public Point getMinnPt()
    {
        return nextBottomLeft;
    }

    
    // return the top-left corner of the bounding box
    public Point getMaxnPt()
    {
        return nextTopRight;
    }

    @Override
    public Point getMinPt()
    {
        return bottomLeft;
    }
    @Override
    // return the top-left corner of the bounding box
    public Point getMaxPt()
    {
        return topRight;
    }


    public boolean doesPoint_lie_insideBox(Point p)
    {
        int x1 = this.getMinnPt().getX();
        int y1 = this.getMinnPt().getY();

        int x2 = this.getMaxnPt().getX();
        int y2 = this.getMaxnPt().getY();

        int x = p.getX();
        int y = p.getY();

        if(x>=x1 && x<=x2 && y>=y1 && y<=y2)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    // does this box intersect/overlap the input BBox
    @Override
    public boolean intersects(BBox b1) 
    {
        // the BBox b1 is like 

        //      x1y2    ------------  x2y2
        //              |          |
        //              |          |
        //      x1y1    ------------  x2y1

        int x1 = b1.getMinPt().getX();
        int y1 = b1.getMinPt().getY();

        int x2 = b1.getMaxPt().getX();
        int y2 = b1.getMaxPt().getY();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x1, y2);
        Point p3 = new Point(x2, y2);
        Point p4 = new Point(x2, y1);

        if(doesPoint_lie_insideBox(p1) || doesPoint_lie_insideBox(p2) || doesPoint_lie_insideBox(p3) || doesPoint_lie_insideBox(p4))
        {
            return true;
        }
        else
        {
            return false;
        }    
    }

}
