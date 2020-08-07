import store.*;
import java.util.*;
import store.bakery.*;
import store.dairy.*;
import java.util.Collections;
public class main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] temp=input.nextLine().split(" ");
        int no_of_bakeries=Integer.valueOf(temp[0]);
        int no_of_dairies=Integer.valueOf(temp[1]);
        int i=0;
        bakerylist blist=new bakerylist();
        dairylist dlist=new dairylist();
        while(i<no_of_bakeries)
        {
            blist.addbakery();
            i=i+1;
        }
        i=0;
        while(i<no_of_dairies)
        {
            dlist.adddairy();
            i=i+1;
        }
        temp=input.nextLine().split(" ");
        String commodity=temp[0];
        i=0;
        int j=0;
        int c=1;
        while(!(commodity.equals("End")))
        {
            int quantity=Integer.valueOf(temp[1]);
            if((commodity.equals("Bread"))||(commodity.equals("Cake"))||(commodity.equals("Muffin")))
            {
                bakery b=blist.getbakery(i+1);
                bakeryorder order = new bakeryorder(commodity,quantity,c);
                b.addorder(order);
                i=((i+1)%no_of_bakeries);
            }
            else
            {
                dairy d=dlist.getdairy(j+1);
                dairyorder order = new dairyorder(commodity,quantity,c);
                d.addorder(order);
                j=((j+1)%no_of_dairies);
            }
            c=c+1;
            temp=input.nextLine().split(" ");
            commodity=temp[0];
        }
        blist.printbakeries();
        dlist.printdairies();
    }
}
