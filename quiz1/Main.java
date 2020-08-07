import java.util.*;
import pack.*;
public class Main
{
       public static void main(String [] args)
       {
              Scanner input = new Scanner(System.in);
              String[] temp=input.nextLine().split(" ");
              int base=Integer.valueOf(temp[0]);
              temp=input.nextLine().split(" ");
              int no_of_routes=Integer.valueOf(temp[0]);
              System.out.println(base);
              System.out.println(no_of_routes);
              Portal p= new Portal();
              for(int i=0;i<no_of_routes;i=i+1)
              {
                     temp=input.nextLine().split(" ");
                     int route_no=Integer.valueOf(temp[0]);
                     String start=temp[1];
                     String dest=temp[2];
                     int dist=Integer.valueOf(temp[3]);
                     float trip_factor=Float.parseFloat(temp[4]);
                     BusRoute r=new BusRoute(route_no, start, dest, dist, trip_factor);
                     p.addroute(r);

              }
              temp=input.nextLine().split(" ");
              while(!(temp[0].equals("X")))
              {
                     if(temp[0].equals("R"))
                     {
                            String istart=temp[1];
                            String idest=temp[2];
                            p.getroute(istart, idest);
                     }
                     else
                     {
                            int route_no=Integer.valueOf(temp[1]);
                            p.printfare(base, route_no);
                     }
                     temp=input.nextLine().split(" ");
              }
       }
}