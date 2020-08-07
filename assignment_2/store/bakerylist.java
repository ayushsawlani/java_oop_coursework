package store;
import java.util.*;
import store.bakery.*;
public class bakerylist
{
    static private ArrayList <bakery> baklist=new ArrayList<bakery>();
    static private int id=1;
    public void addbakery()
    {
        bakery b=new bakery(id);
        baklist.add(b);
        id=id+1;
    }
    public bakery getbakery(int iid)
    {
        return baklist.get(iid-1);
    }
    public void printbakeries()
    {
        int temp=1;
        while(temp<=baklist.size())
        {
            System.out.println("Bakery "+(temp));
            baklist.get(temp-1).printorders();
            System.out.println("");
            temp=temp+1;
        }
    }
}
