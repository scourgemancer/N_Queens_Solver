import java.util.ArrayList;

/**
 * A generic interface for configurations: to be implemented for use
 * in the backtracking algorithm that'll be used to solve the problems.
 * @author Timothy Geary
 */
interface Configuration{
    /**
     * Get an arrayList of successors from the current configuration.
     * @return All successors, they can even be invalid
     */
    ArrayList<Configuration> getSuccessors();

    /**
     * Check if the current configuration is valid by the puzzle's rules
     * @return true if valid and false otherwise
     */
    boolean isValid();

    /**
     * Check if the current configuration is the goal being searched for
     * @return true if goal and false otherwise
     */
    boolean isGoal();
}
