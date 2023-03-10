import java.util.Scanner;
/**


 A class that simulates a voting system with a two-round election and a runoff election if needed.
 */
public class VotingSimulation {
    private final int numVoters;
    private final int numCandidates;
    private final int numTimes;
    private final String[] candidateNames;
    /**
     * Constructs a new VotingSimulation object, prompting the user for input and storing the values.
     */
public class VotingSimulation {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the amount of voters: ");
    this.numVoters = in.nextInt();
    System.out.println("Enter the amount of candidates: ");
    this.numCandidates = in.nextInt();
    System.out.println("Enter the amount of times to run the simulation: ");
    this.numTimes = in.nextInt();
    in.nextLine(); // consume the newline character after reading an int this.candidateNames = new String[this.numCandidates];
        // for (int i = 0; i < this.numCandidates; i++) {
            System.out.println("Enter the name of candidate " + (i + 1) + ": ");
            this.candidateNames[i] = in.nextLine();
        }
       in.close();
    }
    public static void main(String[] args) {
        VotingSimulation simulation = new VotingSimulation();
        simulation.runSimulation();
    }
/**


 Runs the simulation for a specified number of times, outputting the results of each round of voting.


 For each simulation round, creates a new VotingMachine object and a specified number of Voter objects.


 Calculates the voting results and prints them to the console.


 If a candidate receives more than 50% of the vote in the first round, declares them as the winner.


 Otherwise, conducts a runoff election and declares the winner of the runoff.


 Prints the winner of each simulation round to the console.
 */
