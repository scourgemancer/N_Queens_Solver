/**
 * Solves either an n Queen problem, using a given n that's an
 * integer between one and eight, inclusive, and times how long
 * it takes or solves n=1 through n=8 and times how long each
 * one takes, if no specific level is specified by the user.
 * @author Timothy Geary
 */
public class NQueensSolver{
    public static void main(String[] args){
        if(args.length == 0){
            //todo - solve 1-8, inclusive
        }else if(args.length == 1){
            if(args[0].matches("[1-8]")){
                int n = Integer.parseInt(args[0]);
                //todo - solve the n problem
            }else{
                System.out.println("Usage: n must be an integer between one and eight, inclusive");
            }
        }else{
            System.out.println("Usage: java NQueensSolver n");
        }
    }
}
