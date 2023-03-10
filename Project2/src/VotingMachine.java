public class VotingMachine {
}
    /**
     * The VotingMachine class represents a voting machine that can be used to cast ballots for candidates.
     * It contains a configuredBallot that serves as a template for creating ballots given to voters,
     * a voteCounts array that keeps track of the number of votes for each candidate,
     * and methods to cast ballots, configure the machine, and determine a winner.
     */
    private Ballot configuredBallot;
    int[] voteCounts;


/**
 * Configures the voting machine to have the given number of candidates on the ballot.
 *
 * @param numCandidates the number of candidates on the ballot
 */
public void configure(int numCandidates) {
    configuredBallot = new Ballot(numCandidates);
    voteCounts = new int[numCandidates];
}
    public int[] getVoteCounts() {
        return voteCounts.clone();
    }
    public int[] getTopTwoCandidates() {
        int[] voteCounts = this.getVoteCounts();
        int[] topTwoCandidates = new int[2];


        // Initialize the top two candidates to the first two candidates
        for (int i = 0; i < 2; i++) {
            topTwoCandidates[i] = i;
        }
