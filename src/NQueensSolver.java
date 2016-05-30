import java.util.Optional;

/**
 * Solves either an n Queen problem, using a given n that's an
 * integer between one and eight, inclusive, and times how long
 * it takes or solves n=1 through n=8 and times how long each
 * one takes, if no specific level is specified by the user.
 * @author Timothy Geary
 */
public class NQueensSolver{
    public static void main(String[] args){
        if(args.length == 0){//solve all eight n problems
            for(int n=1; n < 9; n++){
                if(n==1) System.out.println("Solving the 1 Queen problem:");
                else System.out.println("Solving the "+n+" Queens problem:");

                double start = System.currentTimeMillis();

                Configuration init = new NQueensConfig(n);
                Backtracker bt = new Backtracker();

                Optional<Configuration> sol = bt.solve(init);

                System.out.println("Solved in: " + (System.currentTimeMillis() - start)/1000.0 + " seconds.");

                if(sol.isPresent()){
                    System.out.println("Solution:\n" + sol.get() + "\n");
                }else{
                    System.out.println("No solution found.\n");
                }
            }
        }else if(args.length == 1){//only solve one n problem
            if(args[0].matches("[1-8]")){//make sure the user provided a valid n to use
                int n = Integer.parseInt(args[0]);

                if(n==1) System.out.println("Solving the 1 Queen problem:");
                else System.out.println("Solving the "+n+" Queens problem:");

                double start = System.currentTimeMillis();

                Configuration init = new NQueensConfig(n);
                Backtracker bt = new Backtracker();

                Optional<Configuration> sol = bt.solve(init);

                System.out.println("Solved in: " + (System.currentTimeMillis() - start)/1000.0 + " seconds.");

                if(sol.isPresent()){
                    System.out.println("Solution:\n" + sol.get());
                }else{
                    System.out.println("No solution found.");
                }
            }else{//invalid n given by the user
                System.out.println("Usage: n must be an integer between one and eight, inclusive");
            }
        }else{//user provided too many arguments
            System.out.println("Usage: java NQueensSolver n");
        }
    }
}
