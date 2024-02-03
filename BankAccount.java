
public class BankAccount
{
	
	private double balance;
	
	public BankAccount()
	{
		balance=10000;
	}
	
	public BankAccount(double initialBalance)
	{
		balance = initialBalance;
	}
	
	public void withdraw(double amount)
	{
			balance-=amount;
	}
	
	public void deposit(double amount)
	{
		balance+=amount;	
	}
			
	public double getBalance()
	{
		return balance;
	}
}