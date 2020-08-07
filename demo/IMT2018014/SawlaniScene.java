//package test;
package IMT2018014;
import java.util.ArrayList;

import animation.Scene;

public class SawlaniScene extends Scene
{
    public SawlaniScene()
    {
        super();
    }
    public void checkScene()
    {
        for(int i=0;i<this.getActors().size();i=i+1)
        {
            int flag=0;
            for(int j=i+1;j<this.getActors().size();j=j+1)
            {
                if(this.getActors().get(i).getBBox().intersects(this.getActors().get(j).getBBox()))
                    flag=1;
            }
            for(int j=0;j<this.getObstacles().size();j=j+1)
            {
                if(this.getActors().get(i).getBBox().intersects(this.getObstacles().get(j).getBBox()))
                    flag=1;
            }
            if(flag==1)
            {
                this.getActors().remove(i);
                i--;
            }
        }
    }
}
