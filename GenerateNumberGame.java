import java.util.*;
public class GenerateNumberGame 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int inputNum, randomNum;
        int rounds=0, wins=0, attempts=4;
        char Repeat;
		
		System.out.print("\t\t\t\tNumber Guesse Game");
        do
        {
            randomNum = (int) (1+Math.random()*99);
            rounds++;
			System.out.print("\n===========================" +
								"\nRound " + rounds +
								"\n===========================");
            do
            {
				
                System.out.print("\n\nGuess a number: ");
                inputNum = in.nextInt();

                if(randomNum==inputNum)
                {
                    System.out.println("You guessed correctly\n");
                    wins++;
                }
                else if(randomNum>inputNum)
                {
                    System.out.println("Your guess is too low\nYou have " + attempts +" attempts left\n");
                }
                else
                {
                    System.out.println("Your guess is too high\nYou have " + attempts +" attempts left\n");
                }
                attempts--;

                if(attempts<0 && randomNum!=inputNum)
                {
                    System.out.println("===========================\n" +
                                        "You lost round " + rounds +
                                        "\n===========================");
                    break;
                }
                else if(randomNum==inputNum)
                {
                    System.out.println("===========================\n" +
                                        "You won round " + rounds +
                                        "\n===========================");
                }

            }while(randomNum!=inputNum);

            System.out.print("Would you like to play another round <Y>yes or <N>no: ");
            Repeat = in.next().toUpperCase().charAt(0);
            attempts=4;
        }while(Repeat=='Y');

        System.out.println("\nYour score is " + wins + " out of " + rounds + " rounds");
    }
    
}
