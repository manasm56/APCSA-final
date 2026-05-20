public class Gameboard{
    private char[][] gBoard;

    public Gameboard(int gSize){
    Gameboard = new char[gSize][gSize];
    for(int i=0; i<gBoard.length; i++){
        for(int g=0; g<gBoard[0].length; g++){
            gBoard[i][g]="W"
        }
    }    
    public boolean placement(int r, int c){
        if(r<0 || c<0 || c>=gBoard.length || r>=gBoard.length){
            return false;
        }
        else if(gBoard[r][c]=='S'){
            return false
        }
        else{
            gBoard[r][c]='s';
            return true;
        }
    }
    }
    public boolean attacks(int r, int c){
        if(gBoard[r][c]=='S'){
            gBoard='X'
            return true;
        }
        else if(gBoard[r][c]=='W'){
            gBoard='O'
            return false;
        }
        else{
            return false
            System.out.println("Your guess is out of bounds, try again next turn");
        }
    }
    public boolean checkGuess(){
        if(gBoard[r][c]=='X' || gBoard[r][c]=='O'){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkShip(){
        for(int i=0; i<gBoard.length; i++){
            for(int j=0; j<gBoard.length; j++){
                if(gBoard[i][j]=='S'){
                    return true;
                }

            }
        }
        return false;
    }
    public void print(boolean shipHide){
        for(int i=0; i<gBoard.length; i++){
            for(int j=0; j<gBoard.length; j++){
                if(shipHide && gBoard[i][j]=='S'){
                    System.out.print("W");
                }
                else{
                    System.out.print(gBoard[i][j]+"");
                }
            }
            System.out.println();
        }
        System.out.println();
    }



}