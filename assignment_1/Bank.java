import java.util.Scanner;
public class Bank
{
    /*public Bank(SavingsAccount b[],int x){
        BankAccounts=b;
        i=x; 
    }
    private SavingsAccount BankAccounts[];
    private int i;
*/
    private static SavingsAccount BankAccounts[]=new SavingsAccount[12];
    private static int i;
    static void addAccount(SavingsAccount A)
    {
        BankAccounts[i]=A;
        i++;
    }
    static void printAccounts()
    {
        int j=0;
        while(j<i)
        {
            System.out.println("Owner: "+BankAccounts[j].Name+" Balance: "+BankAccounts[j].Balance);
            j++;
        }
    }
    public static void main(String [] args)
    {
    //    SavingsAccount b[]=new SavingsAccount[12];
       // Bank yo=new Bank(b,0);
        Scanner input = new Scanner(System.in);
        char x=input.next().charAt(0);
       SavingsAccount current=new SavingsAccount("dcdvjc",23476,4388);
        int n=0;
        while(x!='X')
        {
            if(x=='N')
            {
                String n1=input.next();
                int r1=input.nextInt();
                int B1=input.nextInt();
                current= new SavingsAccount(n1,r1,B1);
                Bank.addAccount(current);
                n++;
            }
            else if(x=='D')
            {
                int amt=input.nextInt();
                current.deposit(amt); 
            }
            else if(x=='W')
            {
                int amt=input.nextInt();
                current.withdraw(amt);
            }
            x=input.next().charAt(0);
        }
        int j=0;
        while(j<n)
        {
            Bank.BankAccounts[j].addinterest();
            j=j+1;
        }
        Bank.printAccounts();
    }
}
