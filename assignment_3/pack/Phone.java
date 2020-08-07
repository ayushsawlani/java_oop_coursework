//package pack;
import java.util.*;

public class Phone
{
    private String number,moden_manufacturer;
    private Network n;
    Phone engaged_with;
    private boolean availability=true;
    public Phone(String inum,String imanuf)
    {
        number=inum;
        moden_manufacturer=imanuf;
    }
    public void attach(Network in)
    {
        n=in;
        in.add(this);
    }
    public String getnumber()
    {
        return number;
    }
    public boolean call(Phone p2)
    {
        boolean flag=n.call(this,p2);
        if(flag)
        {
            engaged_with=p2;
            availability=false;
            return true;
        }
        else
            return false;
    }
    public boolean recieve(Phone p3)
    {
        if(availability)
        {
            engaged_with=p3;
            availability=false;
            return true;
        }
        else
            return false;
    }
    public void hangup_request()
    {
        n.hangup_request(engaged_with);
        availability=true;
    }
    public void hangup()
    {
        availability=true;
    }
}
