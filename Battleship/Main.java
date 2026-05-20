import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        Gameboard player = new Gameboard(5);
        Gameboard AIPlayer = new Gameboard(5);
        System.out.print("place ur 3 ships");
        int num=0;
        while(num<3){
            System.out.print("Row: ");
            int i = input.nextInt();
            System.out.print("Col: ");
            int j = input.nextInt();
            if(player.placeShip(i,j)){
                num++;
                System.out.print("success");   
            }
            else{
                System.out.print("U didn't place it in the correct spot");
            }
        }
        



        
        int AINum=0;
        while(AINum<3){
            int f=(int)(Math.random()*5);
            int z=(int)(Math.random()*5);
            if(AIPlayer.placeShip(f,z)){
                AINum++;
            } 
            }
        boolean gameState=false;
        while(gameState==false){
            System.out.println("Enemy board:");
            AIPlayer.hide(true);
            System.out.print("Guess row: ");
            int r = input.nextInt();
            System.out.print("Guess column: ");
            int c = input.nextInt();
            if(AIPlayer.checkGuess(r, c))
            {
            System.out.println("U already guessed that ");
            }
            else if(AIPlayer.attacks(r, c))
            {
            System.out.println("U hit");
            }
            else
            {
            System.out.println("U missed");
            }
            if(!AIPlayer.checkShip()){
                gameState=true; 
                System.out.println("U are a winner");
            }
            else if(gameState==false){
                int rGuess= (int)(Math.random()*5);
                int cGuess =(int)(Math.random()*5);
                System.out.println("AI guesses: " + rGuess + ", " + cGuess);
                player.attacks(rGuess, cGuess);
                if(player.checkShip() == false)
                {
                    System.out.println("Opponenet wins");
                    gameState = true;
                    
                    }
                }


            }


        }
        
             }

