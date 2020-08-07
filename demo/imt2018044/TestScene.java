package imt2018044;

import animation.Scene;

public class TestScene extends Scene
{
    protected void checkScene() {
        for(int i=0;i<getActors().size();i++)
        {
            for(int j=0;j<getActors().size();j++)
            {
                if(i!=j){
                if(getActors().get(i).getBBox().intersects(getActors().get(j).getBBox())==true)
                {
                    //if(getActors().get(j).getPosition().getX()!= ((TestObject)(getActors().get(j))).getDEST().getX()&& getActors().get(j).getPosition().getY()!=((TestObject)(getActors().get(j))).getDEST().getY())
                        getActors().remove(getActors().get(j));
                }
                }
            }
        }
        for(int i=0;i<getActors().size();i++)
        {
            for(int j=0;j<getObstacles().size();j++)
            {
                try{
                if(getActors().get(i).getBBox().intersects(getObstacles().get(j).getBBox())==true)
                {
                    getActors().remove(getActors().get(i));
                }
                }
                catch(Exception e){}
            }
        }
    }
}



