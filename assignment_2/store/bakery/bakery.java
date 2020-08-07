package store.bakery;
import java.util.*;
public class bakery
{
    private ArrayList <bakeryorder> orderlist=new ArrayList<bakeryorder>();
    private int id;
    public bakery(int iid)
    {
        id=iid;
    }
    public void addorder(bakeryorder x)
    {
        orderlist.add(x);
    }
    public void printorders()
    {
        Collections.sort(orderlist);
        int temp=orderlist.size()-1;
        while(temp>=0)
        {
            System.out.println(orderlist.get(temp));
            temp=temp-1;
        }
    }
}
