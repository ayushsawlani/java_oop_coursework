package IMT2018085;

import java.util.ArrayList;

import animation.BBox;
import animation.Point;
import animation.SceneObject;
import animation.Scene;

public class DemoSceneObject extends SceneObject implements BBox{

	private static int id = 0;	
	private String Name;
	private Point Pos, Dest, minpt, maxpt;
	private ArrayList<Point> Outline;
	private Scene scene;
//	private int flag;

	public DemoSceneObject(Scene s){
		this.Name = Integer.toString(++id);
		this.Pos = new Point(0, 0);
		this.Dest = new Point(0, 0);
		this.Outline = new ArrayList<Point>();
		for(int i=0; i<=20; ++i) {
			this.Outline.add(new Point(i,0));
			this.Outline.add(new Point(i,20));
		}
		for(int i=0, j; i<=20; ++i) {
			if(i==0 || i==20)
				j=1;
			else
				j=0;
			if(j!=1) {
				this.Outline.add(new Point(0,i));
				this.Outline.add(new Point(20,i));
			}
		}
		this.minpt = new Point(0, 0);
		this.maxpt = new Point(20, 20);
//		flag = 0;
		scene = s;
	}
	
	@Override
	public String getObjName() {
		// TODO Auto-generated method stub
		return Name;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return Pos;
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
/*		if(Pos==null) {
			Pos = new Point(x, y);
			minpt = new Point(x-10, y-10);
			maxpt = new Point(x+10, y+10);
			for(int i = minpt.getX(); i<=maxpt.getX(); ++i) {
				Outline.add(new Point(i, this.getBBox().getMinPt().getY()));
				Outline.add(new Point(i, this.getBBox().getMaxPt().getY()));
			}
			for(int j = minpt.getY(); j<=maxpt.getY(); ++j) {
				Outline.add(new Point(this.getBBox().getMinPt().getX(), j));
				Outline.add(new Point(this.getBBox().getMaxPt().getX(), j));
			}
			Outline.add(new Point(x-10, y-10));
			Outline.add(new Point(x-10, y+10));
			Outline.add(new Point(x+10, y-10));
			Outline.add(new Point(x+10, y+10));
		}*/
//		else 
			this.Pos.setPos(x, y);
			this.getBBox().getMinPt().setPos(x-10, y-10);
			this.getBBox().getMaxPt().setPos(x+10, y+10);
/*			for(int i = this.getBBox().get.getBBox().getMinPt()().getX(); i<=this.getBBox().getMaxPt().getX(); ++i, ++j) {
				Outline.get(j).setPos(i, this.getBBox().get.getBBox().getMinPt()().getY());
				Outline.get(j).setPos(i, this.getBBox().getMaxPt().getY());
			}
			for(int i = this.getBBox().get.getBBox().getMinPt()().getY(); i<=this.getBBox().getMaxPt().getY(); ++i, ++j) {
				Outline.get(j).setPos(this.getBBox().get.getBBox().getMinPt()().getX(), i);
				Outline.get(j).setPos(this.getBBox().getMaxPt().getX(), i);
			}*/
			int X = this.getBBox().getMinPt().getX();
			int Y = this.getBBox().getMinPt().getY();
			int n=0;
			for(int i=X; i<=X+20; ++i, ++n) {
				Outline.get(n).setPos(i, Y);
				Outline.get(++n).setPos(i, Y+20);
			}
			for(int i=Y, j; i<=Y+20; ++i, ++n) {
				if(i==Y || i==Y+20)
					j=1;
				else
					j=0;
				if(j==0) {
					Outline.get(n-1).setPos(X, i);
					Outline.get(++n-1).setPos(X+20, i);
				}
			}
//		}
	}

	@Override
	public void setDestPosition(int x, int y) {
		Dest = new Point(x, y);
	}
	
	@Override
	public BBox getBBox() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	protected ArrayList<Point> getOutline() {
		// TODO Auto-generated method stub
		return Outline;
	}

	@Override
	protected void updatePos(int deltaT) {
		// TODO Auto-generated method stub
		int x = Dest.getX()-Pos.getX();
		int y = Dest.getY()-Pos.getY();
		int dx=0, dy=0;
		if(x>10)
			dx=10;
		else if(x<-10)
			dx = -10;
		if(y>10)
			dy = 10;
		else if(y<-10)
			dy = -10;
		if(Math.abs(x)<=10 && Math.abs(y)<=10) {
			dx = 0;
			dy = 0;
		}

		int X = Pos.getX(), Y = Pos.getY();
		setPosition(Dest.getX(), Dest.getY());
		for(int j=0; j<scene.getObstacles().size(); ++j)
			if(this.getBBox().intersects(scene.getObstacles().get(j).getBBox()))
				for(int i=0; i<scene.getActors().size(); ++i)
					if(this.getName().equals(scene.getActors().get(i).getName())) {
						scene.getActors().remove(i);
						return ;
					}
		setPosition(X, Y);

		if(dx!=0)
		//setPosition(Pos.getX()+1*dx, Pos.getY()+(dy)*Math.abs(y/x));
		setPosition(Pos.getX()+1*dx, Pos.getY());
		 else if(dy!=0)
		//setPosition(Pos.getX()+(dx)*Math.abs(x/y), Pos.getY()+(dy*1));
		setPosition(Pos.getX(), Pos.getY()+dy);
		if(dx==0 && dy==0) {
			for(int i=0; i<scene.getActors().size(); ++i)
				if(this.getName().equals(scene.getActors().get(i).getName()))
					scene.getActors().remove(i);
			System.out.println("Destination reached by object" + Name);
		}
				
		for(int i=0; i<scene.getActors().size(); ++i) {
			if(dx!=0) {
				if(this.getBBox().intersects(scene.getActors().get(i).getBBox())) {
						//setPosition(Pos.getX(), Pos.getY()-(2*dy)*Math.abs(y/x));
						setPosition(Pos.getX()-dx, Pos.getY()+dx);
						for(int j=0; j<scene.getActors().size(); ++j) {
							if(this.getBBox().intersects(scene.getActors().get(j).getBBox())) {
								//setPosition(Pos.getX()-2*dx, Pos.getY());
								setPosition(Pos.getX(), Pos.getY()-2*dx);
								for(int k=0; k<scene.getActors().size(); ++k) {
									if(this.getBBox().intersects(scene.getActors().get(k).getBBox())) {
									//	setPosition(Pos.getX(), Pos.getY()+(2*dy)*Math.abs(y/x));
										setPosition(Pos.getX()-dx, Pos.getY()+dx);
										for(int l=0; l<scene.getActors().size(); ++l) {
											if(this.getBBox().intersects(scene.getActors().get(l).getBBox())) {
											//	setPosition(Pos.getX()+1*dx, Pos.getY()+(1*dy)*Math.abs(y/x));
												setPosition(Pos.getX()+1*dx, Pos.getY());
											}
										}
									}
								}
							}
						}
				}
			}
			else{
				if(this.getBBox().intersects(scene.getActors().get(i).getBBox())) {
					//	setPosition(Pos.getX(), Pos.getY()-(2*dy));
						setPosition(Pos.getX()+dy, Pos.getY()-(1*dy));
						for(int j=0; j<scene.getActors().size(); ++j) {
							if(this.getBBox().intersects(scene.getActors().get(j).getBBox())) {
							//	setPosition(Pos.getX()-(2*dx)*Math.abs(x/y), Pos.getY());
								setPosition(Pos.getX()-(2*dy), Pos.getY());
								for(int k=0; k<scene.getActors().size(); ++k) {
									if(this.getBBox().intersects(scene.getActors().get(k).getBBox())) {
					//					setPosition(Pos.getX(), Pos.getY()+2*dy);
										setPosition(Pos.getX()+dy, Pos.getY()-dy);
										for(int l=0; l<scene.getActors().size(); ++l) {
											if(this.getBBox().intersects(scene.getActors().get(l).getBBox())) {
					//							setPosition(Pos.getX()+(1*dy)*Math.abs(x/y), Pos.getY()+(1*dy));
												setPosition(Pos.getX(), Pos.getY()+dy);
											}
										}
									}
								}
							}
						}
				}

			}
		}

		for(int i=0; i<scene.getObstacles().size(); ++i) {
			if(dx!=0) {
				if(this.getBBox().intersects(scene.getObstacles().get(i).getBBox())) {
					setPosition(Pos.getX()-dx, Pos.getY()+dx);
						for(int j=0; j<scene.getObstacles().size(); ++j) {
							if(this.getBBox().intersects(scene.getObstacles().get(j).getBBox())) {
								setPosition(Pos.getX(), Pos.getY()-2*dx);
							//	for(int k=0; k<scene.getObstacles().size(); ++k) {
								//	if(this.getBBox().intersects(scene.getObstacles().get(k).getBBox())) {
									//	setPosition(Pos.getX()-dx, Pos.getY()+dx);
										for(int l=0; l<scene.getObstacles().size(); ++l) {
											if(this.getBBox().intersects(scene.getObstacles().get(l).getBBox())) {
												setPosition(Pos.getX()+1*dx, Pos.getY());
											}
										}
								//	}
							//	}
							}
						}
				}
			}
			else {
				if(this.getBBox().intersects(scene.getObstacles().get(i).getBBox())) {
					setPosition(Pos.getX()+dy, Pos.getY()-(1*dy));
						for(int j=0; j<scene.getObstacles().size(); ++j) {
							if(this.getBBox().intersects(scene.getObstacles().get(j).getBBox())) {
								setPosition(Pos.getX()-(2*dy), Pos.getY());
							//	for(int k=0; k<scene.getObstacles().size(); ++k) {
								//	if(this.getBBox().intersects(scene.getObstacles().get(k).getBBox())) {
									//	setPosition(Pos.getX()+dy, Pos.getY()-dy);
										for(int l=0; l<scene.getObstacles().size(); ++l) {
											if(this.getBBox().intersects(scene.getObstacles().get(l).getBBox())) {
												setPosition(Pos.getX(), Pos.getY()+dy);
											}
										}
								//	}
							//	}
							}
						}
				}

			}
		}
/*		for(int j=0; j<scene.getObstacles().size(); ++j) {
			int X = Pos.getX();
			int Y = Pos.getY();
			setPosition(Dest.getX(), Dest.getY());
			if(this.getBBox().intersects(scene.getObstacles().get(j).getBBox())) {
				flag = -4;
				for(int i=0; i<scene.getActors().size(); ++i)
					if(this.getName().equals(scene.getActors().get(i).getName()))
						scene.getActors().remove(i);
				break;
			}
			setPosition(X, Y);
			if(this.getBBox().intersects(scene.getObstacles().get(j).getBBox())) { //error part
				--flag; //error part
			int unox=0, dosx=0, tresx=0, unoy=0, dosy=0, tresy=0;
				for(int k=0; k<scene.getActors().size(); ++k) { //error part
					if(x!=0) { //error part
						if(flag==-1 && (unox++)==0) //error part
							setPosition(Pos.getX(), Pos.getY()-(2*dy)*Math.abs(y/x)); //error part
						else if(flag==-2 && (dosx++)==0) //error part
							setPosition(Pos.getX()-2*dx, Pos.getY()); //error part
						else if(flag==-3 && (tresx++)==0) //error part
							setPosition(Pos.getX(), Pos.getY()+(2*dy)*Math.abs(y/x));
						else //error part
							break; //error part
						if(this.getBBox().intersects(scene.getActors().get(k).getBBox())) //error part
							--flag; //error part
					}
					else if(y!=0) { //error part
						if(flag==-1 && (unoy++)==0) //error part
							setPosition(Pos.getX()+1, Pos.getY()-1*dy); //error part
						else if(flag==-2 && (dosy++)==0) //error part
							setPosition(Pos.getX()-1, Pos.getY()); //error part
						else if(flag==-3 && (tresy++)==0) //error part
							setPosition(Pos.getX()+1, Pos.getY()-1*dy); //error part
						else //error part
							break; //error part
						if(this.getBBox().intersects(scene.getActors().get(k).getBBox())) //error part
							--flag; //error part
					} //error part
					System.out.println(flag+" "+unox);
				} //error part
			}
			if(flag==-4) {
				for(int i=0; i<scene.getActors().size(); ++i)
					if(this.getName().equals(scene.getActors().get(i).getName()))
						scene.getActors().remove(i);
				break;
			}	
		}*/
		for(int i=0; i<scene.getActors().size(); ++i)
			if(this.getBBox().intersects(scene.getActors().get(i).getBBox()))
				for(int j=0; j<scene.getActors().size(); ++j)
					if(this.getName().equals(scene.getActors().get(j).getName()))
						scene.getActors().remove(j);

/*		for(int i=0; i<scene.getObstacles().size(); ++i)
			if(this.getBBox().intersects(scene.getObstacles().get(i).getBBox()))
				for(int j=0; j<scene.getActors().size(); ++j)
					if(this.getName().equals(scene.getActors().get(j).getName()))
						scene.getActors().remove(j);*/
	}

	@Override
	public Point getMinPt() {
		return minpt;
	}

	@Override
	public Point getMaxPt() {
		return maxpt;
	}

	@Override	
	public boolean intersects(BBox b) {
//		for(int i = Outline.get(0).getX(); i<=Outline.get(3).getX(); ++i)
//			for(int j = Outline.get(0).getY(); j<=Outline.get(3).getY(); ++j)
//				if(i>b.getMinPt().getX() && i<b.getMaxPt().getX() && j>b.getMinPt().getY() && j<b.getMaxPt().getY())
//					return true;
		for(int i=0; i<Outline.size(); ++i)
			if(Outline.get(i).getX()>b.getMinPt().getX() && Outline.get(i).getX()<b.getMaxPt().getX() && Outline.get(i).getY()>b.getMinPt().getY() && Outline.get(i).getY()<b.getMaxPt().getY())
				return true;
		return false;
	}
	
//	public int getFlag() {
//		return flag;
//	}
}
