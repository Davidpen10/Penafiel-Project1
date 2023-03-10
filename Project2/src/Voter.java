public class Voter {

/**
 * The Voter class represents a voter who can cast a ballot in the voting machine.
 * It contains a vote method that simulates the voting process.
 */
    /**
     * Simulates the voting process by choosing a preferred candidate and marking a ballot for them,
     * then casting the ballot in the voting machine.
     *
     * @param machine the voting machine to cast the ballot in
     */public void vote(VotingMachine machine) {
        // Get the ballot from the voting machine.
        Ballot ballot = machine.getBallot();

        // Determine the number of candidates available on the ballot.
        int numCandidates = ballot.getCandidates().length;


        // Randomly select a preferred candidate to vote for.
        int preferredCandidate = (int) (Math.random() * numCandidates);


        // Mark the ballot for the preferred candidate.
        ballot.mark(preferredCandidate);


        // Cast the ballot on the voting machine.
        machine.cast(ballot);
    }
}
