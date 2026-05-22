import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static final int boardSize = 3;
    private static final int numShips = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Board or Grid size: "+ boardSize + " * "+ boardSize);
        System.out.println("No of ships to place: "+ numShips);
        System.out.println("Row range: 0 - "+ (boardSize-1) + "\t Column range: 0 - "+ (boardSize-1));
        System.out.println("Example row, column positions: 1,2 or 2,0");

        Gameboard player = new Gameboard(boardSize);
        Gameboard AIPlayer = new Gameboard(boardSize);
        System.out.println("\nPlace your "+ numShips + " ship(s):");

        int num = 0;
        while (num < numShips) {
            int i = 0, j = 0;
            boolean validInput = false;
            while (!validInput) {
                System.out.println("Enter ship position (example 1,2) as row,column: ");
                String raw = input.next();
                String[] parts = raw.split(",");
                if (parts.length != 2) {
                    System.out.println("Invalid format. Use row,column eg: 1,2");
                    continue;
                }
                try {
                    i = Integer.parseInt(parts[0]);
                    j = Integer.parseInt(parts[1]);
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid format. Use row,column eg: 1,2");
                }
            }

            if (player.placeShip(i, j)) {
                num++;
                System.out.println("Successfully placed the ship");
            } else {
                System.out.println("Invalid spot. You didn't place it in the correct spot.");
            }
        }

        int AINum = 0;
        while (AINum < numShips) {
            int f = (int) (Math.random() * boardSize);
            int z = (int) (Math.random() * boardSize);
            if (AIPlayer.placeShip(f, z)) {

                System.out.println("AI placed ship at: " + f + ", " + z);
                AINum++;
            }
        }

        List<String> aiGuesses = new ArrayList<>();
        boolean gameState = false;
        while (gameState == false) {
            System.out.println(" Enemy board:");
            AIPlayer.hide(true);

            int r = 0, c = 0;
            boolean validInput = false;
            while (!validInput) {
                System.out.println("Guess ship position enter as row,column: ");
                String raw = input.next();
                String[] parts = raw.split(",");
                if (parts.length != 2) {
                    System.out.println("Guessed ship position is invalid. Use row,column eg: 1,2");
                    continue;
                }
                try {
                    r = Integer.parseInt(parts[0]);
                    c = Integer.parseInt(parts[1]);
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Guessed ship position is invalid. Use row,column eg: 1,2");
                }
            }

            if (AIPlayer.checkGuess(r, c)) {
                System.out.println("You already guessed that");
            } else if (AIPlayer.attacks(r, c)) {
                System.out.println("You hit");
            } else {
                System.out.println("You missed");
            }

            if (!AIPlayer.checkShip()) {
                gameState = true;
                System.out.println("\n*** Congratulations! You won the game ***");
            } else if (gameState == false) {
                int rGuess, cGuess;
                String aiGuess;
                do {
                    rGuess = (int) (Math.random() * boardSize);
                    cGuess = (int) (Math.random() * boardSize);
                    aiGuess = rGuess + "," + cGuess;
                } while (aiGuesses.contains(aiGuess));
                aiGuesses.add(aiGuess);
                System.out.println("AI guesses: " + rGuess + ", " + cGuess);

                player.attacks(rGuess, cGuess);

                if (player.checkShip() == false) {
                    System.out.println("\n*** You lost the game. Better luck next time ***");
                    gameState = true;
                }
            }
        }
    }

}



