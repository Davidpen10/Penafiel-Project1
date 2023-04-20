import java.util.Scanner;
/**


 A class that simulates a voting system with a two-round election and a runoff election if needed.
 */
public class VotingSimulation {

    private final int randomVoters;
    private final int oddVoters;
    private final int evenVoters;
    private final int doubleVoters;
    private final int loyalVoters;
    private final int leadVoters;
    private final int loyalVoterPrefferedCandidateIndex;
    private final int numCandidates;
    private final int numTimes;
    private final String[] candidateNames;

/**
 * Constructs a new VotingSimulation object, prompting the user for input and storing the values.
 */
public VotingSimulation() {
    Scanner in = new Scanner(System.in);

    System.out.println("Enter the amount random voters: ");
    this.randomVoters = in.nextInt();
    System.out.println("Enter the amount odd voters: ");
    this.oddVoters = in.nextInt();
    System.out.println("Enter the amount even voters: ");
    this.evenVoters = in.nextInt();
    System.out.println("Enter the amount double voters: ");
    this.doubleVoters = in.nextInt();
    System.out.println("Enter the amount loyal voters: ");
    this.loyalVoters = in.nextInt();
    System.out.println("Enter the amount lead voters: ");
    this.leadVoters = in.nextInt();
    System.out.println("Enter the amount of candidates: ");
    this.numCandidates = in.nextInt();
    System.out.println("Enter the index of the candidate for loyal voters: ");
    this.loyalVoterPrefferedCandidateIndex = in.nextInt();
    System.out.println("Enter the amount of times to run the simulation: ");
    this.numTimes = in.nextInt();
    in.nextLine(); // consume the newline character after reading an int
    this.candidateNames = new String[this.numCandidates];
    for (int i = 0; i < this.numCandidates; i++) {
        System.out.println("Enter the name of candidate " + (i + 1) + ": ");
        this.candidateNames[i] = in.nextLine();
    }
    in.close();
}
