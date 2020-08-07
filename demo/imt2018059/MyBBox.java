package imt2018059;
import animation.*;

public class MyBBox implements BBox{
  private int h;
  private int w;
  private Car sceneObj;
  public MyBBox(Car s){
    sceneObj=s;
    h=s.getHeight();
    w=s.getWidth();
  }

  public Point getMinPt(){
    int minx=sceneObj.getPosition().getX()-w/2;
    int miny=sceneObj.getPosition().getY()-h/2;
    return new Point(minx,miny);
  }

  public Point getMaxPt(){
    int maxx=sceneObj.getPosition().getX()+w/2;
    int maxy=sceneObj.getPosition().getY()+h/2;
    return new Point(maxx,maxy);
  }

  public boolean intersects(BBox b){
    Point b1=b.getMinPt();
    Point a1=getMinPt();
    Point b2=b.getMaxPt();
    Point a2=getMaxPt();
    if(b1.getX()>=a1.getX() && b1.getX()<=a2.getX() && b1.getY()>=a1.getY() && b1.getY()<=a2.getY()){
      return true;
    }
    else if(b2.getX()>=a1.getX() && b2.getX()<=a2.getX() && b2.getY()>=a1.getY() && b2.getY()<=a2.getY()){
      return true;
    }
    else if(b1.getX()>=a1.getX() && b1.getX()<=a2.getX() && b2.getY()>=a1.getY() && b2.getY()<=a2.getY()){
      return true;
    }
    else if(b2.getX()>=a1.getX() && b2.getX()<=a2.getX() && b1.getY()>=a1.getY() && b1.getY()<=a2.getY()){
      return true;
    }
    
    return false;
  }
}