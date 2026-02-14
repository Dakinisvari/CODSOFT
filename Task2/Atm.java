import java.util.*;
public class Atm
{
    private final BankAccount acc;
    public Atm(BankAccount acc)
    {
        this.acc=acc;
    }
    private void withdraw(double amount)
    {
        if(acc.withdrawAmt(amount))
        {
            System.out.println("Amount withdrawn successfully!");
            System.out.println("New balance: "+acc.getBalance());
        }
        else
        {
            System.out.println("Can't withdraw. Check your balance.");
        }
    }
    private void deposit(double amount)
    {
        if(acc.depositAmt(amount))
        {
            System.out.println("Amount deposited successfully!");
            System.out.println("New balance: "+acc.getBalance());
        }
        else
        {
            System.out.println("Amount can't be 0 or negative.");
        }
    }
    private void checkBalance()
    {
        System.out.println("Your balance is "+acc.getBalance());
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int c;
        System.out.println("Enter your initial bank balance: ");
        double bal=sc.nextDouble();
        while(bal<500)
        {
            System.out.println("Bank balance should be minimum 500");
            System.out.println("Enter your initial bank balance: ");
            bal=sc.nextDouble();
        }
        BankAccount b=new BankAccount(bal);
        Atm a=new Atm(b);
        do 
        { 
            System.out.println("-------Welcome to ATM-------");
            System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
            System.out.print("Enter your choice: ");
            c=sc.nextInt();
            switch(c)
            {
                case 1 -> 
                {
                    System.out.print("Enter the amount to withdraw: ");
                    double amount=sc.nextDouble();
                    a.withdraw(amount);
                }
                case 2 -> 
                {
                    System.out.print("Enter the amount to deposit: ");
                    double amt=sc.nextDouble();
                    a.deposit(amt);
                }
                case 3 -> a.checkBalance();
                case 4 -> System.out.println("Thank you for using the ATM!");
                default -> System.out.println("Invalid Choice");
            }     
        } while (c!=4);
    }
}