package pack;
import java.util.*;
import pack.BusRoute;
public class Portal
{
    private ArrayList <BusRoute> routelist=new ArrayList<BusRoute>();
    public void addroute(BusRoute r)
    {
        routelist.add(r);
    }
    public void getroute(String istart,String idest)
    {
        for(int i=0;i<routelist.size();i=i+1)
        {
            BusRoute r=routelist.get(i);
            if((r.getstart().equals(istart))&&(r.getdest().equals(idest)))
            {
                System.out.println(r.getroute_no());
            }
        }
    }
    public void printfare(int ibase,int iroute_no)
    {
        for(int i=0;i<routelist.size();i=i+1)
        {
            BusRoute r= routelist.get(i);
            if(r.getroute_no()==iroute_no)
            {
                int fare=(int)(ibase+r.getcost());
                System.out.println(fare);
            }
        }
    }

}