package store.dairy;
import java.util.Collections.*;
public class dairyorder implements Comparable<dairyorder>
{
    private String commodity;
    private int quantity;
    private int id;
    public dairyorder(String is, int iquantity, int iid)
    {
        commodity=is;
        quantity=iquantity;
        id=iid;
    }
    public int getquantity()
    {
        return quantity;
    }
    @Override
    public int compareTo(dairyorder d)
    {
        return this.quantity-d.quantity;
    }
    @Override
    public String toString()
    {
        return ("Order "+id+" "+commodity+" "+quantity);
    }
}
