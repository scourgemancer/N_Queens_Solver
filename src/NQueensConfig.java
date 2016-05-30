import java.util.ArrayList;

/**
 * The class represents a single configuration of an n Queens problem
 * and is used in the backtracking algorithm to solve the problems.
 * @author Timothy Geary
 */
public class NQueensConfig implements Configuration{
    //the board is true if a queen is there and false if empty
    private boolean[][] board;

    //the number of queens to be placed on the board
    private int n;

    //the position to place the next queen at
    private int[] pos;

    //whether or not the previous successor placed a queen
    private boolean placed;

    /**
     * Constructs a new NQueensConfig, with an empty board
     * @param n - The number of queens to fit on the board
     */
    NQueensConfig(int n){
        this.n = n;
        this.board = new boolean[8][8];
        this.pos = new int[2];
        pos[0] = 0;
        pos[1] = -1;
    }

    /**
     * Constructs an NQueensConfig that's a copy of an existing NQueensConfig
     * @param otherConfig - The other NQueensConfig to be copied
     */
    private NQueensConfig(NQueensConfig otherConfig){
        this.n = otherConfig.n;
        this.board = new boolean[8][8];
        for(int r=0; r < 8; r++){
            System.arraycopy(otherConfig.board[r], 0, this.board[r], 0, 8);
        }
        this.pos = new int[2];
        System.arraycopy(otherConfig.pos, 0, this.pos, 0, 2);
    }

    @Override
    public boolean isGoal(){
        int num = n;
        for(int r=0; r < 8; r++){
            for(int c=0; c < 8; c++){
                if(board[r][c]) num--;
                if(num == 0) return true;
            }
        }
        return false;
    }

    @Override
    public boolean isValid(){
        for(int r=0; r < 8; r++){
            for(int c=0; c < 8; c++){
                if(board[r][c]){//check for collisions
                    //children are never placed on the same row

                    for(int i=0; i < 8; i++){//check the column
                        if(board[i][c] && i!=r) return false;
                    }

                    //check the diagonals
                    int originalR = r;
                    int originalC = c;
                    while(r > 0 && c > 0){//upper left diagonal
                        r--;
                        c--;
                        if(board[r][c]) return false;
                    }
                    r = originalR;
                    c = originalC;
                    while(r > 0 && c < 7){//upper right diagonal
                        r--;
                        c++;
                        if(board[r][c]) return false;
                    }
                    r = originalR;
                    c = originalC;
                    while(r < 7 && c > 0){//lower left diagonal
                        r++;
                        c--;
                        if(board[r][c]) return false;
                    }
                    r = originalR;
                    c = originalC;
                    while(r < 7 && c < 7){//lower right diagonal
                        r++;
                        c++;
                        if(board[r][c]) return false;
                    }
                    r = originalR;
                    c = originalC;
                }
            }
        }
        return true;
    }

    @Override
    public ArrayList<Configuration> getSuccessors(){
        ArrayList<Configuration> successors = new ArrayList<>();

        if(placed){//start on next row because there's already a queen on this row
            pos[0]++;
            pos[1] = 1;//since a queen is always placed on the top left corner
        }else{//you're free to place on this row
            pos[1]++;
            if(pos[1] == 8){
                pos[0]++;
                pos[1] = 1;//since a queen is always placed on the top left corner
            }
        }
        if(pos[0] == 8) return successors;

        NQueensConfig newQueen = new NQueensConfig(this);
        newQueen.board[pos[0]][pos[1]] = true;
        newQueen.placed = true;
        successors.add(newQueen);
        NQueensConfig skipped = new NQueensConfig(this);
        successors.add(skipped);

        return successors;
    }

    @Override
    public String toString(){
        String result = "";
        for(int r=0; r < 8; r++){
            result += (8-r) + " ║";
            for(int c=0; c < 8; c++){
                if(board[r][c]) result += "♛ ";
                else result += "… ";
            }
            result += "\n";
        }
        result += "  ╚════════════\n";
        result += "    a  b   c   d    e   f    g    h";

        return result;
    }
}
