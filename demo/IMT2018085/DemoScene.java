package IMT2018085;
import java.util.ArrayList;
import animation.*;

public class DemoScene extends Scene{

	public DemoScene() {
		super();
	}

	@Override
	public void checkScene() {
		for(int i=0; i<super.getActors().size(); ++i) {
			for(int j=0; j<super.getObstacles().size(); ++j)
				if(super.getActors().get(i).getBBox().intersects(super.getObstacles().get(j).getBBox())) {
					super.getActors().remove(i);
					break;
				}
		}
	}
}
