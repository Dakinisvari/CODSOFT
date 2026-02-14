import java.util.*;
public class NumberGame
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------Number Game-------");
        Random r = new Random();
        int num = r.nextInt(100)+1;
        int attempts=10;
        int scores=100;
        do 
        { 
            boolean isOver=false;
            if(attempts!=0)
            {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                if(guess>num)
                {
                    System.out.println("Too high");
                    attempts--;
                    scores-=10;
                }
                else if (guess<num) 
                {
                    System.out.println("Too low"); 
                    attempts--;
                    scores-=10;
                }
                else
                {
                    System.out.println("You have guessed it right! You have won the game!");
                    System.out.println("Your score is: "+scores);
                    isOver=true;
                }       
            }
            if(attempts==0)
            {
                System.out.print("Attempts over. The number is "+num+"\nBetter luck next time\n");
                System.out.println("Your score is: "+scores);
                isOver=true;
            }
            if(isOver)
            {
                System.out.print("Do you want to play again (Y/N)? ");
                sc.nextLine();
                char yn = sc.nextLine().charAt(0);
                if(yn=='Y'||yn=='y')
                {
                    num = r.nextInt(100)+1;
                    attempts=10;
                    scores=100;
                    continue;
                }
                if(yn=='N'||yn=='n')
                {     
                    System.out.println("Thanks for playing!");
                    break;
                }
                else
                {
                    System.out.print("Invaild choice");
                    break;
                }
            }            
            
        }while(true);
    }
}