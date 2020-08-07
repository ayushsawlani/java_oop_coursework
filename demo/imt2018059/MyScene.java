package imt2018059;
import animation.*;
import java.util.ArrayList;

public class MyScene extends Scene{
	
	public MyScene() {
		obstacles = new ArrayList<>();
		actors = new ArrayList<>();
		theScene = this;
	}
	
	public void setView(View v) {
		view = v;
	}
	
	public static Scene getScene() {	
		return theScene;
	}
	
	public void addObstacle(SceneObject so) {
		obstacles.add(so);
	}
	
	public void addActor(SceneObject so) {
		actors.add(so);
	}

	public ArrayList<SceneObject> getObstacles() {
		return obstacles;
	}
	
	public ArrayList<SceneObject> getActors() {
		return actors;
	}
	
	public void render() {
		view.clear();
		for (SceneObject s : obstacles) {
			view.render(s);
		}
		for (SceneObject s : actors) {
			view.render(s);
		}
		
		view.updateView();
	}
	
	public void animate() {
		System.out.println("Starting animation");
		
		for (SceneObject s : actors) {
			s.start();
		}

		for (int i = 0; i < 2 * View.maxUpdates; i++) {
			
			checkScene(); // pre-process the scene before re-rendering
			
			render();
			
			try {
				Thread.sleep(View.delT/2);
			} catch (InterruptedException e) {	
				e.printStackTrace();
			}
		}
	}
	
	// override this if additional processing is needed before each render
	// should flag actors that intersect with other obstacles or objects
	public void checkScene(){
		ArrayList<SceneObject> a=getActors();
		ArrayList<SceneObject> o=getObstacles();
		for(SceneObject i:a){
			if(i.getBBox().getMinPt().getX()<0 || i.getBBox().getMinPt().getY()<0){
				System.out.println("Actor out of boundary");
			}
		}
		for(int i=0;i<a.size();i++){
			for(int j=0;j<a.size();j++){
				if(i!=j && a.get(i).getBBox().intersects(a.get(j).getBBox())){
					System.out.println("There is collision with another actor");
				}
			}
		}
		for(SceneObject i: a){
			for(SceneObject j: o){
				if(i.getBBox().intersects(j.getBBox())){
					System.out.println("There is collision with an obstacle");
				}
			}
		}
	}
	
	private ArrayList<SceneObject> obstacles;
	private ArrayList<SceneObject> actors;
	
	private View view;
	private static Scene theScene;
}
