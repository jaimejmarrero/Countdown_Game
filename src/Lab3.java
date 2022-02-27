import java.util.Scanner;

public class Lab3 {

    public static void main(String[] args) {
        double randomDecimal = Math.random();

        int min = 10;
        int max = 20;

        int randomInteger = min + (int) ((randomDecimal * (max - min) + 1));

        System.out.println("Welcome to Countdown!");
        System.out.println("The starting number for this game is " + randomInteger);
        int winner = play_game(randomInteger);
        System.out.println("Player " + winner + " wins!");

    }

    public static String get_guess_from_player(int player) {
        Scanner inScanner = new Scanner(System.in);
        return inScanner.nextLine();
    }

    public static int one_user_turn(int player) {
        boolean enteredValid = false;
        int guessNumber = 0;
        while(!enteredValid) {
            try {
                System.out.println("Player " + player + ", enter either 1 or 2: ");
                // Convert the next line from input to an integer.
                guessNumber = Integer.parseInt(get_guess_from_player(player));
                if(guessNumber != 1 && guessNumber != 2) {
                    System.out.println("Enter a number in range please!");
                    continue;
                }
                enteredValid = true;
            }
            catch(Exception ex) {
                System.out.println("Please enter a number!");
            }
        }

        return guessNumber;
    }

    public static int play_game(int startingNumber) {
        int player = 1;
        while(startingNumber > 0) {

            int guess = one_user_turn(player);
            startingNumber = startingNumber - guess;
            System.out.println("The number is now " + startingNumber);

            // If nobody has won the game, switch the player
            if(startingNumber > 0) {
                player = player + 1;
                if(player > 2) player = 1;
            }

        }

        return player;
    }
}