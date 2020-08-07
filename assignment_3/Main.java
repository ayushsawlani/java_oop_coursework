import java.util.*;


//import pack.Network;
//import pack.Phone;
//import pack.Smartphone;
public class Main
{
    public static void main(String [] args)
    {
        Phone p1=new Phone("12345","TI");
        Smartphone p2=new Smartphone("Samsung","23456","Mediatek");
        Smartphone p3=new Smartphone("Apple","13452","Apple");
        Network n=new Network();
        p1.attach(n);
        p2.attach(n);
        p3.attach(n);
        //cd n.add(p3); gives error as add method  has package private access
        if(p1.call(p2))
        {
            System.out.println("successful");
        }
        else
        {
            System.out.println("not successful");
        }
        if(p3.call(p1))
        {
            System.out.println("successful");
        }
        else
        {
            System.out.println("not successful");
        }
        p2.hangup_request();
        if(p3.call(p1))
        {
            System.out.println("successful");
        }
        else
        {
            System.out.println("not successful");
        }
    }
}
