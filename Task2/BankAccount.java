public class BankAccount
{
    private double balance;
    private static final double MIN_BALANCE = 500;
    public BankAccount(double balance)
    {
        this.balance=balance;
    }
    public boolean withdrawAmt(double amount)
    {
        if(amount<=0)
        {
            return false;
        }
        if(balance-amount<MIN_BALANCE)
        {
            return false;
        }
        this.balance-=amount;
        return true;
    }
    public boolean depositAmt(double amount)
    {
        if(amount<=0)
        {
            return false;
        }
        this.balance+=amount;
        return true;
    }
    public double getBalance()
    {
        return this.balance;
    }
}