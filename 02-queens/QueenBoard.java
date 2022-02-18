public class QueenBoard{
    private int[][] board;
    private boolean animated;
    private int delay;
    public QueenBoard(){
        board = new int[8][8];
        animated = false;
        delay = 1000;
    }
    public QueenBoard(int size){
        board = new int[size][size];
        delay = 1000;
        animated = false;
    }

    public void setAnimate(boolean newValue){
        animated = newValue;
    }
    public void setDelay(int newValue){
        delay = newValue;
    }

    public boolean solve(){
        return solve(0);
    }
    public boolean solve(int row){
        if(row==0 && board[0][0] != 0) throw new IllegalStateException("Board already solved");
        if(row==board.length){
            return true;
        } else{
            for(int i = 0;i<board.length;i++){
                if(addQueen(row, i)){
                    if(solve(row+1)) return true;
                    removeQueen(row, i);
                }
            }
            return false;
        }

    }
    private static int count;
    public int countSolutions(){
        return countSolutions(0,0);
    }
    public int countSolutions(int row, int col){
        if(row==0 && board[0][0] != 0) throw new IllegalStateException("Board already solved");
        if (row==0 && col==0 && board[0][0] == 0) count=0;
        if(row==board.length){
            count++;
        }else{
            while (col<board.length){
                if(addQueen(row, col)){
                    countSolutions(row+1,0);
                    removeQueen(row, col);
                }
                col++;
            }
        }
        return count;
    }

    public String toString(){
        String ans = "";
        for(int i = 0; i < board.length;i++){
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
    public String toStringDebug(){ // used for anim part
        String ans = "";
        for(int i = 0; i < board.length-1;i++){
            for(int j = 0; j < board[0].length;j++){
                if(board[i][j] < 0){
                    ans+= "♛ ";
                } else if (board[i][j] > 0){
                    ans+= "\u001b[90m×\u001b[0m ";
                } else {
                    ans += "_ ";
                }     
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
        if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(toStringDebug());//can modify here
            Text.wait(delay);
        }
        return true;
    }
    private void removeQueen(int r, int c){
        if (board[r][c] < 0 ){
            board[r][c] = 0;
            modBoard(r, c, -1);
        }
        if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(toStringDebug());//can modify here
            Text.wait(delay);
        }
    }
}