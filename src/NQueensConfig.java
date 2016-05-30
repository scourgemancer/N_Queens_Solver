import java.util.ArrayList;

/**
 * The class represents a single configuration of an n Queens problem
 * and is used in the backtracking algorithm to solve the problems.
 * @author Timothy Geary
 */
public class NQueensConfig implements Configuration{
    /**
     * Constructs a new NQueensConfig, with an empty board
     * @param n - The number of queens to fit on the board
     */
    NQueensConfig(int n){

    }

    /**
     * Constructs an NQueensConfig that's a copy of an existing NQueensConfig
     * @param otherConfig - The other NQueensConfig to be copied
     */
    NQueensConfig(NQueensConfig otherConfig){

    }

    @Override
    public boolean isGoal() {
        return false;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public ArrayList<Configuration> getSuccessors() {
        return null;
    }

    @Override
    public String toString() {
        return  "8 ║♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜\n" +
                "7 ║♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟\n" +
                "6 ║… … … … … … … …\n" +
                "5 ║… … … … … … … …\n" +
                "4 ║… … … … … … … …\n" +
                "3 ║… … ♘ … … … … …\n" +
                "2 ║♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙\n" +
                "1 ║♖ … ♗ ♕ ♔ ♗ ♘ ♖\n" +
                "  ╚════════════\n" +
                "    a  b   c   d    e   f    g    h";
    }
}
