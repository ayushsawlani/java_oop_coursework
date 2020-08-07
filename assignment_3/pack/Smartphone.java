//package pack;
import java.util.*;
public class Smartphone extends Phone
{
    private String cpu_manufacturer;
    public Smartphone(String icpu,String inum,String imanu)
    {
        super(inum, imanu);
        cpu_manufacturer=icpu;
    }
}
