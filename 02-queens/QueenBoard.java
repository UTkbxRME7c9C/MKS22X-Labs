public class QueenBoard{
    private int[][] board;
    public QueenBoard(){
        board = new int[8][8];
    }
    public QueenBoard(int row, int col){
        board = new int[row][col];
    }

    public String toString(){
        String ans = "";
        for(int i = 0; i < board.length-1;i++){
            for(int j = 0; j < board[0].length;j++){
                if(board[i][j] < 0){ // queen check -1
                    ans+= "Q ";
                } else{
                    ans+= "_ ";
                }
            }
            ans+="\n";
        }
        return ans;
    }
    public String toStringDebug(){
        String ans = "";
        for(int i = 0; i < board.length-1;i++){
            for(int j = 0; j < board[0].length;j++){
                ans+= board[i][j] + " ";
            }
            ans+="\n";
        }
        return ans;
    }

    private void modBoard(int r, int c, boolean remove){

    }
    private boolean addQueen(int r, int c){
        return true;
    }
    private void removeQueen(int r, int c){
        if (board[r][c] < 0 ){
        }
    }
}