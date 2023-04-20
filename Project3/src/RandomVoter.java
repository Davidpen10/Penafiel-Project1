public class RandomVoter implements Voter {

    @Override
    public void vote(VotingMachine machine) {
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

