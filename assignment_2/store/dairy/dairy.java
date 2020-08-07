package store.dairy;
import java.util.*;
public class dairy
{
    private ArrayList <dairyorder> orderlist=new ArrayList<dairyorder>();
    private int id;
    public dairy(int iid)
    {
        id=iid;
    }
    public void addorder(dairyorder x)
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