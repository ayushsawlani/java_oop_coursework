package imt2018059;
import animation.*;
import java.util.ArrayList;
import java.util.Random; 


public class Car extends SceneObject{
  private Point p1;
  private Point p2;
  private int h,w;//height and width
  private String name;
  private int speed;
  private boolean visited1[][];
  private int visitedCount[][];
  private Random rand = new Random(); 
  private boolean yObs=false;
  private BBox bbox;
  public Car(){
    //temp assignment
    p1=new Point(0,0);
    p2=new Point(0,0);
    name="Car";
    speed=20;
    // actual is h=5,w=11
    h=6; 
    w=12;
    // h=18;
    // w=36;
    visited1=new boolean[2000][2000];
    visitedCount=new int[2000][2000];
    bbox=new MyBBox(this);
    resetVisited();
  }

  protected int getHeight(){
    return h;
  }

  protected int getWidth(){
    return w;
  }

  //This function is for the purpose of testing
  public void setObjName(String a){
    name=a;
  }

  public String getObjName() {
    return name;
  }

  public Point getPosition(){
    return p1;
  }

  public void setPosition(int x,int y){
    p1.setPos(x, y);
    if(x>0 && y>=0){
      visited1[x][y]=true;
      visitedCount[x][y]+=1;
    }
  }

  public void setDestPosition(int x,int y){
    p2.setPos(x, y);
    resetVisited();
  }

  public BBox getBBox(){
    return bbox;
  }

  public String imageFileName() {
		return "car.png";
  }



  protected ArrayList<Point> getOutline(){
    ArrayList<Point> a=new ArrayList<Point>();
    a.add(new Point(p1.getX()-2,p1.getY()+2));
    a.add(new Point(p1.getX()-3,p1.getY()+1));
    a.add(new Point(p1.getX()-5,p1.getY()+1));
    a.add(new Point(p1.getX()-5,p1.getY()-1));
    a.add(new Point(p1.getX()-3,p1.getY()-1));
    a.add(new Point(p1.getX()-4,p1.getY()-2));
    a.add(new Point(p1.getX()-3,p1.getY()-3));
    a.add(new Point(p1.getX()-2,p1.getY()-2));
    a.add(new Point(p1.getX()-3,p1.getY()-1));
    a.add(new Point(p1.getX()+3,p1.getY()-1));
    a.add(new Point(p1.getX()+2,p1.getY()-2));
    a.add(new Point(p1.getX()+3,p1.getY()-3));
    a.add(new Point(p1.getX()+4,p1.getY()-2));
    a.add(new Point(p1.getX()+3,p1.getY()-1));
    a.add(new Point(p1.getX()+6,p1.getY()-1));
    a.add(new Point(p1.getX()+6,p1.getY()+1));
    a.add(new Point(p1.getX()+3,p1.getY()+1));
    a.add(new Point(p1.getX()+2,p1.getY()+2));
    a.add(new Point(p1.getX()-2,p1.getY()+2));
    return a;
  }

  private boolean obstruct(int x,int y){
    ArrayList<SceneObject> s=Scene.getScene().getObstacles();
    SceneObject temp=new Car();
    temp.setPosition(x, y);
    for(SceneObject i:s){
      if(temp.getBBox().intersects(i.getBBox())){
        return true;
      }
    }
    ArrayList<SceneObject> a=Scene.getScene().getActors();
    for(int i=0;i<a.size();i++){
      if(a.get(i)!=this && temp.getBBox().intersects(a.get(i).getBBox())){
        return true;
      }
    }
    // if(x-(w/2)<0 || y-(h/2)<0){
    //   return true;
    // }
    if(x-(w/2)<0 || y-(h/2)<0 || x+(w/2)>700 || y+(h/2)>700){
      return true;
    }
    return false;
  }

  private boolean obstructObs(int x,int y){
    ArrayList<SceneObject> s=Scene.getScene().getObstacles();
    SceneObject temp=new Car();
    temp.setPosition(x, y);
    for(SceneObject i:s){
      if(temp.getBBox().intersects(i.getBBox())){
        return true;
      }
    }
    if(x-(w/2)<0 || y-(h/2)<0){
      return true;
    }
    return false;
  }

  private boolean obstructAct(int x,int y){
    SceneObject temp=new Car();
    temp.setPosition(x, y);
    ArrayList<SceneObject> a=Scene.getScene().getActors();
    for(int i=0;i<a.size();i++){
      if(a.get(i)!=this && temp.getBBox().intersects(a.get(i).getBBox())){
        return true;
      }
    }
    return false;
  }

  private boolean obstructSpeed(char a,int speed){
    int x=p1.getX();
    int y=p1.getY();
    if(a=='x')
    {
      if(speed>0){
        for(int i=1;i<=speed;i++){
          if(obstruct(x+i,y)){
            return true;
          }
        }
      }
      else{
        for(int i=-1;i>=speed;i--){
          if(obstruct(x+i,y)){
            return true;
          }
        }
      }
    }
    else{
      if(speed>0){
        for(int i=1;i<=speed;i++){
          if(obstruct(x,y+i)){
            return true;
          }
        }
      }
      else{
        for(int i=-1;i>=speed;i--){
          if(obstruct(x,y+i)){
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean isVisited(int x,int y){
    if(visited1[x][y]){
      return true;
    }
    return false;
  }

  private void addVisited(char a,int speed){
    int x=p1.getX();
    int y=p1.getY();
    if(a=='x')
    {
      if(speed>0){
        for(int i=1;i<=speed;i++){
          visited1[x+i][y]=true;
          visitedCount[x+i][y]+=1;
        }
      }
      else{
        for(int i=-1;i>=speed;i--){
          visited1[x-i][y]=true;
          visitedCount[x-i][y]+=1;
        }
      }
    }
    else{
      if(speed>0){
        for(int i=1;i<=speed;i++){
          visited1[x][y+i]=true;
          visitedCount[x][y+i]+=1;
        }
      }
      else{
        for(int i=-1;i>=speed;i--){
          visited1[x][y-i]=true;
          visitedCount[x][y-i]+=1;
        }
      }
    }
  }

  private boolean actorInShortRange(){
    ArrayList<SceneObject> a=Scene.getScene().getActors();
    for(SceneObject i:a){
      if(i!=this){
        Point b1=i.getBBox().getMinPt();
        Point a1=new Point(bbox.getMinPt().getX()-(5), bbox.getMinPt().getY()-(5));
        Point b2=i.getBBox().getMaxPt();
        Point a2=new Point(bbox.getMaxPt().getX()+(5), bbox.getMaxPt().getY()+(5));
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
      }
    }
    return false;
  }

  private void resetVisited(){
    for(int i=0;i<2000;i++){
      for(int j=0;j<2000;j++){
        visited1[i][j]=false;
        visitedCount[i][j]=0;
      }
    }
  }

  protected void updatePos(int deltaT){
    int x=p1.getX();
    int y=p1.getY();
    boolean resetVis=false;
    if(Math.abs(p2.getX()-x)<speed || Math.abs(p2.getY()-y)<speed){
      speed=1;
    }
    if(!actorInShortRange()){
      speed=1;
    }
    int pref[]={1,3,2,4,0,0,0,0};
    if(p2.getX()>x){
      if(isVisited(x+speed, y)||(obstructObs(x+speed,y) && speed==1))
      {
        pref[0]=0;
        pref[2]=0;
        pref[4]=2;
        pref[6]=1;
        speed=1;
      }
      else if(speed!=1){
        pref[0]=1;
        pref[2]=0;
      }
      else{
        pref[0]=1;
        pref[2]=2;
      }
      if((obstructAct(x, y+5) || obstructAct(x, y-5)) && yObs){
        pref[0]=0;
        pref[2]=0;
      }
      if(obstructAct(x+5, y)){
        int temp[]={0,3,4};
        pref[0]=temp[rand.nextInt(3)];
        pref[2]=0;
        if(speed<10){
          speed=10;
        }else if(speed<=20){
          speed+=2;
        }
        resetVis=true;
      }
    }
    else if(p2.getX()<x){
      if(isVisited(x-speed, y)||(obstructObs(x-speed,y) && speed==1)){
        pref[0]=0;
        pref[2]=0;
        pref[4]=1;
        pref[6]=2;
        speed=1;
      }
      else if(speed!=1){
        pref[0]=2;
        pref[2]=0;
      }
      else{
        pref[0]=2;
        pref[2]=1;
      }
      if((obstructAct(x, y+5) || obstructAct(x, y-5)) && yObs){
        pref[0]=0;
        pref[2]=0;
      }
      if(obstructAct(x-5, y)){
        int temp[]={0,3,4};
        pref[0]=temp[rand.nextInt(3)];
        pref[2]=0;
        if(speed<10){
          speed=10;
        }else if(speed<=20){
          speed+=2;
        }
        resetVis=true;
      }
    }
    else if(p2.getX()==x){
      pref[0]=0;
      pref[2]=0;
      if(x<300)
      {
        pref[4]=1;
        pref[6]=2;
      }
      else{
        pref[4]=2;
        pref[6]=1;
      }
    }
    if(yObs){
      yObs=false;
    }
    if(p2.getY()>y){
      if(isVisited(x, y+speed)||(obstructObs(x,y+speed) && speed==1)){
        pref[1]=0;
        pref[3]=0;
        pref[5]=4;
        pref[7]=3;
        speed=1;
      }
      else if(speed!=1){
        pref[1]=3;
        pref[3]=0;
      }
      else{
        pref[1]=3;
        pref[3]=4;
      }
      if(obstructAct(x, y+5)){
        pref[1]=rand.nextInt(3);
        pref[3]=0;
        if(speed<10){
          speed=10;
        }else if(speed<=20){
          speed+=2;
        }
        resetVis=true;
        yObs=true;
      }
    }
    else if(p2.getY()<y){
      if(isVisited(x, y-speed)||(obstructObs(x,y-speed) && speed==1)){
        pref[1]=0;
        pref[3]=0;
        pref[5]=3;
        pref[7]=4;
        speed=1;
      }
      else if(speed!=1){
        pref[1]=4;
        pref[3]=0;
      }
      else{
        pref[1]=4;
        pref[3]=3;
      }
      if(obstructAct(x, y-5)){
        pref[1]=rand.nextInt(3);
        pref[3]=0;
        if(speed<10){
          speed=10;
        }else if(speed<=20){
          speed+=2;
        }
        resetVis=true;
        yObs=true;
      }
    }
    else if(p2.getY()==y){
      pref[1]=0;
      pref[3]=0;
      if(y<300)
      {
        pref[5]=3;
        pref[7]=4;
      }
      else{
        pref[5]=4;
        pref[7]=3;
      }
    }
    if(p2.getX()==x && p2.getY()==y){
      for(int i=0;i<8;i++){
        pref[i]=0;
      }
    }

    boolean moved=false;
    for(int i=0;i<8;i++){
      switch(pref[i]){
        case 1:
          if(!obstructSpeed('x',speed)){
            addVisited('x', speed);
            setPosition(x+speed, y);
            if(speed<=20){
              speed*=2;
            }
            moved=true;
          }
          break;
        case 2:
          if(!obstructSpeed('x',-speed)){
            addVisited('x', -speed);
            setPosition(x-speed, y);
            if(speed<=20){
              speed*=2;
            }
            moved=true;
          }
        break;
        case 3:
          if(!obstructSpeed('y',speed)){
            addVisited('y', speed);
            setPosition(x, y+speed);
            if(speed<=20){
              speed*=2;
            }
            moved=true;
          }
          break;
        case 4:
          if(!obstructSpeed('y',-speed)){
            addVisited('y', -speed);
            setPosition(x, y-speed);
            if(speed<=20){
              speed*=2;
            }
            moved=true;
          }
          break;
        default:
          break;
      }
      if(moved){
        break;
      }
    }
    if(!moved){
      if(speed!=1){
        speed=(speed)/2;
        updatePos(deltaT);
      }
    }
    if(visitedCount[x][y]==20 || resetVis || actorInShortRange()){
      resetVisited();
    }
 
  }

  @Override
	public void run() {
		// default implementation. You can override this if you want to change the
		// behavior
		// of this object

		for (int i = 0; i < View.maxUpdates; i++) {
			updatePos(View.delT);
			try {
				Thread.sleep(View.delT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}