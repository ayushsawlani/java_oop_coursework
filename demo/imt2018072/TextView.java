package imt2018072;
import animation.SceneObject;
import animation.View;

public class TextView extends View {

	@Override
	public void clear() {
		System.out.println(" Clearing View \n");
	}

	@Override
	public void render(SceneObject s) {
		System.out.println("Object " + s.getObjName() + " at " + s.getPosition().getX() + "," + s.getPosition().getY());
	}

	@Override
	public void init() {

	
	}

	@Override
	public void updateView() {

	}

}