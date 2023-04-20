public class LoyalVoter implements Voter {
    //The index of the candidate the voter is loyal to
    private int candidateIndex;

    //Constructor
    public LoyalVoter(int candidateIndex) {
        this.candidateIndex = candidateIndex;
    }

    @Override
    public void vote(VotingMachine machine) {
        // Get the ballot from the voting machine.
        Ballot ballot = machine.getBallot();

        // Mark the ballot for the loyal candidate.
        ballot.mark(candidateIndex);

        // Cast the ballot on the voting machine.
        machine.cast(ballot);
    }
