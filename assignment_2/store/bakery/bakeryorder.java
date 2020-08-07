package store.bakery;
import java.util.Collections.*;
public class bakeryorder implements Comparable<bakeryorder>
{
    private String commodity;
    private int quantity;
    private int id;
    public bakeryorder(String icom, int iqua,int iid)
    {
        commodity=icom;
        quantity=iqua;
        id=iid;
    }
    public int getquantity()
    {
        return quantity;
    }
    @Override
    public int compareTo(bakeryorder comparestu) {
        int q=((bakeryorder)comparestu).getquantity();
        return this.quantity-q;
    }
    public String toString()
    {
        return ("Order "+id+" "+commodity+" "+quantity);
    }
}