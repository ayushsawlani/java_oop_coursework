import java.util.Scanner;

public class SavingsAccount
{
    SavingsAccount(String iname,long iinterest_rate,long iBalance)
    {
        Name=iname;
        interest_rate=iinterest_rate;
        Balance=iBalance;
    }
    long getBalance()
    {
        return Balance;
    }
    void deposit(int x)
    {
        Balance=Balance+x;
    }
    long withdraw(int x)
    {
        if(x>Balance)
            return 0;
        else
        {
            Balance=Balance-x;
            return Balance;
        }
    }
    void addinterest()
    {
        Balance=Balance+((interest_rate)*Balance)/1200;
    }
    String getName()
    {
        return Name;
    }
    public String Name;
    public long interest_rate,Balance;
/*    public static void main(String [] args)
    {
        SavingsAccount A= new SavingsAccount("Newton",15,10000);
        A.deposit(2000);
        A.withdraw(5000);
        A.withdraw(10000);
        A.addinterest();
        System.out.println("Account owned by "+A.Name+" has a balance of "+A.Balance);        
    }
    */
}



