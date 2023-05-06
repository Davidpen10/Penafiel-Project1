public class DoubleVoter implements Voter {


    @Override
    public void vote(VotingMachine machine) {
        // Get the ballot from the voting machine.
        Ballot ballot = machine.getBallot();

        // Determine the number of candidates available on the ballot.
        int numCandidates = ballot.getCandidates().length;
        // Randomly select the first preferred candidate to vote for.
        int firstPreferredCandidate = (int) (Math.random() * numCandidates);

        // Randomly select the second different preferred candidate to vote for
        int secondPreferredCandidate = 0;
        do {
            secondPreferredCandidate = (int) (Math.random() * numCandidates);
        } while (secondPreferredCandidate == firstPreferredCandidate);

        // Mark the ballot for the first preferred candidate.
        ballot.mark(firstPreferredCandidate);

        // Mark the ballot for the second preferred candidate.
        ballot.mark(secondPreferredCandidate);


        // Cast the ballot on the voting machine.
        machine.cast(ballot);
    }
}