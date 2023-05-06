public class EvenVoter implements Voter {
    @Override
    public void vote(VotingMachine machine) {
        // Get the ballot from the voting machine.
        Ballot ballot = machine.getBallot();

        // Determine the number of candidates available on the ballot.
        int numCandidates = ballot.getCandidates().length;
        // Randomly select an even index candidate to vote for.
        int preferredCandidate = 0;

        do {
            preferredCandidate = (int) (Math.random() * numCandidates);
        } while (preferredCandidate % 2 != 1);


        // Mark the ballot for the preferred candidate.
        ballot.mark(preferredCandidate);


        // Cast the ballot on the voting machine.
        machine.cast(ballot);
    }
}


