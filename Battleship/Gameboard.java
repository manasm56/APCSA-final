public class Gameboard{
    private char[][] gBoard;

    public Gameboard(int gSize){
    Gameboard = new char[gSize][gSize];
    for(int i=0; i<gBoard.length; i++){
        for(int g=0; g<gBoard[0].length; g++){
            gBoard[i][g]="W"
        }
    }    
    public boolean placeShip(int r, int c){
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



}