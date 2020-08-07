package pack;
import java.util.*;
public class BusRoute
{
    private int route_no;
    private String start;
    private String dest;
    private int dist;
    private float trip_factor;
    public BusRoute(int iroute_no,String istart ,String idest,int idist,float itrip_factor)
    {
        route_no=iroute_no;
        start=istart;
        dest=idest;
        dist=idist;
        trip_factor=itrip_factor;
    }
    public int getroute_no()
    {
        return route_no;
    } 
    public int getdist()
    {
        return dist;
    }
    public float gettrip_factor()
    {
        return trip_factor;
    }
    public String getstart()
    {
        return start;
    }
    public String getdest()
    {
        return dest;
    }
    public float getcost()
    {
        return dist*trip_factor;
    }
}