import java.util.*;

class NumberGuessing{

    // Main Function
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        int attemptLimits=5;
        int score=0;
        int roundsPlayed=0;

        System.out.println("Welcome to the Number Guessing Game");

        System.out.println("Enter the Maximum Number");
        int max=sc.nextInt();

        System.out.println("Enter the Minimum Number");
        int min=sc.nextInt();

        boolean playAgain = true;
        while (playAgain){
            roundsPlayed++;
            System.out.println("Round "+ roundsPlayed +" begins.");

            int target =r.nextInt(max-min + 1) + min;
            System.out.println("Enter the number between "+max+ " and "+min);
            int attempts=0;
            boolean guessCorrect= false;

            while(attempts < attemptLimits)
            {
                System.out.println("Enter your Guess:");
                int guess = sc.nextInt();
                attempts++;

            if ( guess == target)
            {
                System.out.println("Congragulations! You've Guessed the Correct Number in "+attempts+ " attempts.");
                score += 100-(attempts-1) *20;
                guessCorrect =true;
                break;
            }
            else if(guess < target)
            {
                System.out.println("Your guess is too low! Try Again.");
            }
            else
            {
                System.out.println("Your guess is too high! Try Again.");
            }
        }
 
        if (!guessCorrect){
            System.out.println("Sorry, You've reached the limit of Attempts. The Correct Number was:"+ target);
        }

        System.out.println("Your Score is:"+ score);
        System.out.println("Round "+ roundsPlayed +" is over.");
        System.out.println("Do You Want to Play Again? (YES/NO):");
        String playAgainReply= sc.next();
        playAgain = playAgainReply.equals("YES") || playAgainReply.equals("Y");
    }

    System.out.println("Thank you for playing the Number Guessing Game!");
    sc.close();


    }

}