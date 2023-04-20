public class OddVoter implements Voter {
    @Override
    public void vote(VotingMachine machine) {
        // Get the ballot from the voting machine.
        Ballot ballot = machine.getBallot();

        // Determine the number of candidates available on the ballot.
        int numCandidates = ballot.getCandidates().length;


        // Randomly select an odd index candidate to vote for.
        int preferredCandidate = 0;
