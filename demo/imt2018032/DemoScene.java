package imt2018032;

import java.util.ArrayList;

import animation.BBox;
import animation.Point;
import animation.Scene;
import animation.SceneObject;

public class DemoScene extends Scene {
    Scene scene;
    int count_act = 0;
    int count_obs = 0;
    int i=0;
    public DemoScene()
	{
		super();
    }
    protected void checkScene()
    {
        scene = getScene();
        //System.out.println(scene);
        for(SceneObject act: scene.getActors())
        {
            for(SceneObject obs: scene.getObstacles())
            {
                for(SceneObject curr: scene.getActors())
                {
                    act = new DemoSceneObject();
                    BBox b1 = act.getBBox();
                    obs = new DemoSceneObject();
                    BBox b2 = obs.getBBox();
                    curr = new DemoSceneObject();
                    BBox b3 = curr.getBBox();
                    int b1_width = b1.getMaxPt().getX() - b1.getMinPt().getX();
                    int b1_height = b1.getMaxPt().getY() - b1.getMinPt().getY();
                    int b2_width = b2.getMaxPt().getX() - b2.getMinPt().getX();
                    int b2_height = b2.getMaxPt().getY() - b2.getMinPt().getY();
                    int b3_width = b3.getMaxPt().getX() - b3.getMinPt().getX();
                    int b3_height = b3.getMaxPt().getY() - b3.getMinPt().getY();
                    int flag1=0;
                    int flag2=0;
                    int flag3=0;
                    int flag4=0;
                    if ((curr.getPosition().getX()) > (act.getPosition().getX()+b1_width)|| (act.getPosition().getX()) > (curr.getPosition().getX()+b3_width ))
                        flag1=1;
            
                    if ((curr.getPosition().getY()+ b3_height) > (act.getPosition().getY()) || (act.getPosition().getY()+b1_height) > (curr.getPosition().getY()))
                        flag2=1 ;
                    if((flag1==0)&&(flag2==0))
                    {
                        count_act+=1;
                    }
                    if ((curr.getPosition().getX()) > (obs.getPosition().getX()+b2_width) || (obs.getPosition().getX()) > (curr.getPosition().getX()+b3_width) )
                        flag3=0;
            
                    if ((curr.getPosition().getY()+ b3_height) > (obs.getPosition().getY()) || (obs.getPosition().getY()+b2_height) > (curr.getPosition().getY()))
                        flag4=0;
                    if((flag1==0)&&(flag2==0))
                    {
                        count_obs += 1;
                    }
                    System.out.println(count_act);
                    System.out.println(count_obs);
                    i += 1;
                    if(count_act>0)
                    {
                        scene.getActors().remove(i);
                        scene.getActors().remove(i);
                        //scene.getActors().remove(new SceneObject(act));
                        //scene.getActors().remove(new SceneObject(curr));
                    }
                    if(count_obs>0)
                    {
                        scene.getActors().remove(i);
                        //scene.getActors().remove(new SceneObject(curr));
                    }
            }
        }
    }
}}