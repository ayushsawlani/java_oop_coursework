//package pack;
import java.util.*;

public class Network
{
    private ArrayList <Phone> list = new ArrayList<Phone>();
    void add(Phone p)
    {
        list.add(p);
    }
    boolean call(Phone p1,Phone p2)
    {
        boolean flag=false;
        for(int i=0;i<list.size();i=i+1)
        {
            if(list.get(i).getnumber().equals(p2.getnumber()))
                flag=true;
        }
        if(!(flag))
            return false;
        return p2.recieve(p1);
    }
    void hangup_request(Phone p)
    {
        p.hangup();
    }
}
