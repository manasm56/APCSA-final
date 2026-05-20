public class Gameboard{
    private char[][] gBoard;
    public Gameboard(int gSize){
    gBoard = new char[gSize][gSize];
    for(int i=0; i<gBoard.length; i++){
        for(int g=0; g<gBoard[0].length; g++){
            gBoard[i][g]='W';
        }
    }
    }    
    public boolean placeShip(int r, int c){
        if(r<0 || c<0 || c>=gBoard.length || r>=gBoard.length){
            return false;
        }
        else if(gBoard[r][c]=='S'){
            return false;
        }
        else{
            gBoard[r][c]='S';
            return true;
        }
    
    }
    public boolean attacks(int r, int c){
        if(r<0 || c<0 || c>=gBoard.length || r>=gBoard.length){
            return false;
        }
        else if(gBoard[r][c]=='S'){
            gBoard[r][c]='X';
            return true;
        }
        else{
            gBoard[r][c]='O';
            return false;
        }
    }
    public boolean checkGuess(int r, int c){
        if(r<0 || c<0 || c>=gBoard.length || r>=gBoard.length || gBoard[r][c]=='X' || gBoard[r][c]=='O'){
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
    public void hide(boolean shipHide){
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