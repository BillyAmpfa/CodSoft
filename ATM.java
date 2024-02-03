import java.util.*;
public class ATM
{
	public static void main(String[] args)
	{
		BankAccount account = new BankAccount();
		AtmMachine machine = new AtmMachine(account); 
		Scanner in = new Scanner(System.in);
		int session =1;
		System.out.println("\t\t\t\tOUR BANK ATM Machine");
		do
		{
			System.out.println("\t\t\t\tTransaction Options");
			System.out.print("\n1) Withdraw\n2) Deposit\n3) Balance\n0)Exit\nSelect Option: ");
			int option = in.nextInt();
			if(option==1)
			{
				System.out.print("\nAmount to withdraw: ");
				double withdrawAmount = in.nextDouble();
				machine.withdraw(withdrawAmount);
			}
			else if(option==2)
			{
				System.out.print("\nAmount to deposit: ");
				double depositAmount = in.nextDouble();
				machine.deposit(depositAmount);
			}
			else if(option==3)
			{
				machine.checkBalance();
			}
			else if(option==0)
			{
				break;
			}
			else
			{
				System.out.println("\nInvaild Option\n");
			}
			
			System.out.print("\nWould you like to perform another transaction\n1. Yes\n0. End Session\n");
			session = in.nextInt();
		}while( session ==1);
		
		System.out.print("\nThank You using our ATM\nEnd of sesion");
	}
}
