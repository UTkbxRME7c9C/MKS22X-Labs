public class QueenBoard{
    private int[][] board;
    public QueenBoard(){
        board = new int[8][8];
    }
    public QueenBoard(int size){
        board = new int[size][size];
    }


    /**Find the first solution configuration possible for this size board. Start by placing
    *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
    *  move the previous queen to the next valid space. This means everyone will generate the same
    *  first solution.
    *@postcondition: the board remains in a solved state.
    *@return false when the board is not solveable and leaves the board filled with zeros;
    *        returns true when the board is solveable, and leaves the board in a solved state
    *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
    */
    public boolean solve(){
        return solve(0);
    }
    public boolean solve(int row){
        if(row==board.length){
            return true;
        } else{
            return false;
        }

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

    private void modBoard(int r, int c, int remove){
        int len = board.length;
        for (int i = 1;i<len;i++){
            if (r+i<len){
                board[r+i][c]+=remove;
                if (c-i>-1) board[r+i][c-i]+=remove;
                if (c+i<len) board[r+i][c+i]+=remove;
            }
            if (r-i>-1){
                board[r-i][c]+=remove;
                if (c-i>-1) board[r-i][c-i]+=remove;
                if (c+i<len)board[r-i][c+i]+=remove;
            }
            if (c+i<len) board[r][c+i]+=remove;
            if (c-i>-1) board[r][c-i]+=remove;
        }
    }
    private boolean addQueen(int r, int c){
        if (board[r][c]!=0) return false;
        board[r][c] = -1;
        modBoard(r, c, 1);
        return true;
    }
    private void removeQueen(int r, int c){
        if (board[r][c] < 0 ){
            board[r][c] = 0;
            modBoard(r, c, -1);
        }
    }
}