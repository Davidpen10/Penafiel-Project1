public class VotingMachine {

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

// Find the two candidates with the highest vote counts
        for (int i = 2; i < voteCounts.length; i++) {
            if (voteCounts[i] > voteCounts[topTwoCandidates[0]]) {
                topTwoCandidates[1] = topTwoCandidates[0];
                topTwoCandidates[0] = i;
            } else if (voteCounts[i] > voteCounts[topTwoCandidates[1]]) {
                topTwoCandidates[1] = i;
            }
        }
        return topTwoCandidates;
    }
    /**
     * Casts a ballot in the voting machine, incrementing the vote count for the preferred candidate
     * if the ballot is valid (i.e. it contains a mark for only one candidate).
     *
     * @param ballot the ballot to cast
     * @return true if the ballot was cast successfully, false otherwise
     */
    public void cast(Ballot ballot) {
        boolean[] selectedCandidates = ballot.getCandidates();
        int markedCandidate = -1;
        for (int i = 0; i < selectedCandidates.length; i++) {
            if (selectedCandidates[i]) {
                if (markedCandidate == -1) {
                    markedCandidate = i;
                } else {
                    return; // more than one candidate is marked on the ballot, so the ballot is invalid and not cast
                }
            }
        }

        if (markedCandidate != -1) {
            voteCounts[markedCandidate]++; // increment the vote count for the marked candidate
        }
    }

    /**
     * Returns the configured ballot for the voting machine.
     *
     * @return the configured ballot for the voting machine
     */
    public Ballot getBallot() {
        return configuredBallot.clone();
    }
