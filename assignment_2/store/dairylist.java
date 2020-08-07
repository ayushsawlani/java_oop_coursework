package store;
import java.util.*;
import store.dairy.*;
public class dairylist
{
    static private ArrayList <dairy> darlist=new ArrayList<dairy>();
    static private int id=1;
    public void adddairy()
    {
        dairy b=new dairy(id);
        darlist.add(b);
        id=id+1;
    }
    public dairy getdairy(int iid)
    {
        return darlist.get(iid-1);
    }
    public void printdairies()
    {
        int temp=1;
        while(temp<=darlist.size())
        {
            System.out.println("Dairy "+(temp));
            darlist.get(temp-1).printorders();
            System.out.println("");
            temp=temp+1;
        }
    }
}
