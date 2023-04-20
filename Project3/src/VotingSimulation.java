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
    public static void main(String[] args) {
        VotingSimulation simulation = new VotingSimulation();
        simulation.runSimulation();
    }
    /**
     * Runs the simulation for a specified number of times, outputting the results of each round of voting.
     * <p>
     * For each simulation round, creates a new VotingMachine object and a specified number of Voter objects.
     * <p>
     * Calculates the voting results and prints them to the console.
     * <p>
     * If a candidate receives more than 50% of the vote in the first round, declares them as the winner.
     * <p>
     * Otherwise, conducts a runoff election and declares the winner of the runoff.
     * <p>
     * Prints the winner of each simulation round to the console.
     */
    public void runSimulation() {
        for (int i = 0; i < this.numTimes; i++) {
            VotingMachine votingMachine = new VotingMachine();
            votingMachine.configure(this.numCandidates);

            for (int j = 0; j < this.randomVoters; j++) {
                Voter voter = new RandomVoter();
                voter.vote(votingMachine);
            }

            for (int j = 0; j < this.oddVoters; j++) {
                Voter voter = new OddVoter();
                voter.vote(votingMachine);
            }

            for (int j = 0; j < this.evenVoters; j++) {
                Voter voter = new EvenVoter();
                voter.vote(votingMachine);
            }

            for (int j = 0; j < this.doubleVoters; j++) {
                Voter voter = new DoubleVoter();
                voter.vote(votingMachine);
            }

            for (int j = 0; j < this.loyalVoters; j++) {
                Voter voter = new LoyalVoter(loyalVoterPrefferedCandidateIndex);
                voter.vote(votingMachine);
            }
            for (int j = 0; j < this.leadVoters; j++) {
                Voter voter = new LeadVoter();
                voter.vote(votingMachine);
            }

            int numVoters = this.randomVoters + this.oddVoters + this.evenVoters + this.doubleVoters + this.loyalVoters + this.leadVoters;
            int[] voteCounts = votingMachine.getVoteCounts();
            double abstainPercent = 100.0 * (double) votingMachine.getBallot().countCandidates() / numVoters;
            System.out.println();
            System.out.println("Two-Round Election with " + this.numCandidates + " candidates.");
            for (int k = 0; k < this.numCandidates; k++) {
                double votePercent = 100.0 * (double) voteCounts[k] / numVoters;
                System.out.println(this.candidateNames[k] + " received " + String.format("%.2f", votePercent) + " % of the vote");
            }
            System.out.println(String.format("%.2f", abstainPercent) + " % of the voters abstained");

            int firstRoundWinner = votingMachine.determineWinner();
            if (voteCounts[firstRoundWinner] > (double) numVoters / 2) {
                System.out.println(this.candidateNames[firstRoundWinner] + " has won the election with " + String.format("%.2f", (100.0 * (double) voteCounts[firstRoundWinner] / numVoters)) + " % of the vote");
            } else {
                // reset the voting machine before the second round
                votingMachine.reset();
                Ballot runoffBallot = new Ballot(2);
                runoffBallot.mark(firstRoundWinner);
                for (int k = 0; k < this.numCandidates; k++) {
                    if (k != firstRoundWinner && voteCounts[k] > voteCounts[runoffBallot.getCandidates()[0] ? firstRoundWinner : k]) {
                        runoffBallot.mark(k);
                    }
                }
                for (int j = 0; j < this.randomVoters; j++) {
                    Voter voter = new RandomVoter();
                    voter.vote(votingMachine);
                }
                for (int j = 0; j < this.oddVoters; j++) {
                    Voter voter = new OddVoter();
                    voter.vote(votingMachine);
                }
                for (int j = 0; j < this.evenVoters; j++) {
                    Voter voter = new EvenVoter();
                    voter.vote(votingMachine);
                }
                for (int j = 0; j < this.doubleVoters; j++) {
                    Voter voter = new DoubleVoter();
                    voter.vote(votingMachine);
                }
                for (int j = 0; j < this.loyalVoters; j++) {
                    Voter voter = new LoyalVoter(loyalVoterPrefferedCandidateIndex);
                    voter.vote(votingMachine);
                }
                for (int j = 0; j < this.leadVoters; j++) {
                    Voter voter = new LeadVoter();
                    voter.vote(votingMachine);
                }
                int[] runoffVoteCounts = votingMachine.getVoteCounts();
                double runoffAbstainPercent = 100.0 * (double) votingMachine.getBallot().countCandidates() / numVoters;
                System.out.println();
                System.out.println("Runoff Election with " + runoffBallot.countCandidates() + " candidates.");
                for (int k = 0; k < runoffBallot.countCandidates(); k++) {
                    int candidateIndex = runoffBallot.getCandidates()[k] ? 1 : 0;
                    double votePercent = 100.0 * (double) runoffVoteCounts[candidateIndex] / numVoters;
                    System.out.println(this.candidateNames[candidateIndex] + " received " + String.format("%.2f", votePercent) + " % of the vote");
                }
                System.out.println(String.format("%.2f", runoffAbstainPercent) + " % of the voters abstained in the runoff election");
                int runoffWinner = votingMachine.determineWinner();
                int winnerIndex = runoffBallot.getCandidates()[runoffWinner] ? 1 : 0;
                System.out.println(this.candidateNames[winnerIndex] + " has won the election with " + String.format("%.2f", (100.0 * (double) runoffVoteCounts[runoffWinner] / numVoters)) + " % of the vote");

                System.out.println("\nVote Counts");
                for (int k = 0; k < candidateNames.length; k++) {
                    System.out.printf("%s: %d\n", candidateNames[k], voteCounts[k]);
                }
                System.out.printf("\nVote discarded because of double voter: %d\n", this.doubleVoters);
            }
        }
    }
}




