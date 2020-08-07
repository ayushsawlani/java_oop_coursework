import animation.Scene;
import animation.SceneObject;
import animation.View;
// import demo.DemoSceneObject;

import java.util.ArrayList;

import IMT2018085.*;
import imt2018072.*;
import imt2018059.*;
import IMT2018014.*;
import imt2018044.*;
import imt2018032.*;
// import imt2018032.DemoSceneObject;

// Driver class to set up and exercise the animation
public class Demo {

	public static void main(String[] args) {
		Scene scene = new SawlaniScene();
		
		// scene.setView(new DemoSwingView());
		View view = new DemoSwingView();

		scene.setView(view);

		view.init();
		
		// int o[][]={{19,-3},{6,13}};
		// int o[][]={{20,10},{39,3}};
		// int o[][]={{20,30},{39,23},{6,30}};
		// for(int i=0;i<o.length;i++) {
		// 	SceneObject s = new Car();
		// 	// s.setObjName("Obstacle");
		// 	s.setPosition(o[i][0],o[i][1]);  
		// 	scene.addObstacle(s); 
		// }
		
		// // int ai[][]={{6,3}};
		// // int ai[][]={{6,3}};
		// int ai[][]={{6,23},{20,30}};
		// // int ad[][]={{36,33}};
		// // int ad[][]={{40,33}};
		// int ad[][]={{70,53},{30,40}};
		// for(int i=0;i<ai.length;i++) {
		// 	SceneObject s = new Car();
		// 	s.setPosition(ai[i][0],ai[i][1]); 
		// 	s.setDestPosition(ad[i][0], ad[i][1]);
		// 	// s.setObjName("Car"+i);
		// 	scene.addActor(s);
		// }

		SceneObject s1=new IMT2018085.DemoSceneObject(Scene.getScene());
		s1.setPosition(100, 100);
		s1.setDestPosition(30, 30);		
		scene.addActor(s1);
		SceneObject s2=new Car();
		s2.setPosition(100, 100);
		s2.setDestPosition(30, 30);		
		scene.addActor(s2);
		SceneObject s3=new SawlaniObject();
		s3.setPosition(100, 100);
		s3.setDestPosition(30, 30);		
		scene.addActor(s3);
		SceneObject s4=new TestObject();
		s4.setPosition(100, 100);
		s4.setDestPosition(30, 30);		
		scene.addActor(s4);
		SceneObject s5=new imt2018032.DemoSceneObject();
		s5.setPosition(100, 100);
		s5.setDestPosition(30, 30);		
		scene.addActor(s5);
		SceneObject s6=new mySceneObject();
		s6.setPosition(100, 100);
		s6.setDestPosition(30, 30);		
		scene.addActor(s6);
		SceneObject s7=new IMT2018085.DemoSceneObject(Scene.getScene());
		s7.setPosition(100, 100);
		scene.addObstacle(s7);
		SceneObject s8=new Car();
		s8.setPosition(100, 100);
		scene.addObstacle(s8);
		SceneObject s9=new SawlaniObject();
		s9.setPosition(100, 100);
		scene.addObstacle(s9);
		SceneObject s10=new TestObject();
		s10.setPosition(100, 100);
		scene.addObstacle(s10);
		SceneObject s11=new imt2018032.DemoSceneObject();
		s11.setPosition(100, 100);
		scene.addObstacle(s11);
		SceneObject s12=new mySceneObject();
		s12.setPosition(100, 100);
		scene.addObstacle(s12);


	}
	
}
