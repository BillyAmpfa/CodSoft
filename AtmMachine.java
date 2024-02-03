import java.text.DecimalFormat;
import java.util.*;
public class AtmMachine{
	
	DecimalFormat fmt = new DecimalFormat("R0.00");
	private BankAccount account;
	
	public AtmMachine(BankAccount account)
	{
		this.account = account;
	}
	
	public void withdraw(double amount)
	{
		if(amount>account.getBalance()){
			System.out.println("Unsuccessful Transaction: Insufficient Funds\n");
		}
		else if(amount<0){
			System.out.println("Unsuccessful Transaction: Invaild input amount must be greater then R0.00\n");
		}
		else{
			account.withdraw(amount);
			System.out.println("Successfully withdrew: " + fmt.format(amount));
			System.out.println("Your current balance is: " +  fmt.format(account.getBalance()));
		}
	}
	
	public void deposit(double amount){
		if(amount<0)
		{
			System.out.println("Unsuccessful Transaction: Invaild input amount must be greater then R0.00\n");
		}
		else{
			account.deposit(amount);
			System.out.println("Successfully deposited: " + fmt.format(amount));
			System.out.println("Your current balance is: " +  fmt.format(account.getBalance()));
		}
	}
	
	public void checkBalance(){
		System.out.println("\nYour current balance is: " +  fmt.format(account.getBalance()));
	}
	
	/*public static void main(String[] args)
	{
		BankAccount account = new BankAccount();
		AtmMachine machine = new AtmMachine(account); 
		Scanner in = new Scanner(System.in);
		int session =1;
		do
		{
			System.out.println("\t\t\t\tATM Machine");
			System.out.print("\n1) Withdraw\n2) Deposit\n3) Balance\nSelect Option: ");
			int option = in.nextInt();
			switch(option)
			{
				case 1: System.out.print("\nAmount to withdraw: ");
						double withdrawAmount = in.nextDouble();
						machine.withdraw(withdrawAmount);
						break;
				case 2: System.out.print("\nAmount to deposit: ");
						double depositAmount = in.nextDouble();
						machine.deposit(depositAmount);
						break;
				case 3: machine.checkBalance();
						break;
				default: System.out.println("\nInvaild Option\n");
			}
			
			System.out.print("\nWould you like to perform another transaction\n1. Yes\n0. End Session\n");
			session = in.nextInt();
		}while( session ==1);
		
		System.out.print("\nThank You using our ATM\nEnd of sesion");
	}*/
}