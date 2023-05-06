import java.util.Random;

public class IndependentVoter implements Voter {

    private VotingSimulation.Leanings lean;
    private int numCandidates;
    private Random random;

    public IndependentVoter(VotingSimulation.Leanings lean, int numCandidates) {
        this.lean = lean;
        this.numCandidates = numCandidates;
        this.random = new Random();
    }

    @Override
    public void vote(VotingMachine machine) {
        // Get the ballot from the voting machine.
        Ballot ballot = machine.getBallot();

        // Determine the number of candidates available on the ballot.
        int numCandidates = ballot.getCandidates().length;

        // Determine if the voter abstains.
        if (random.nextFloat() < 0.05f) {
            // Voter abstains; do not mark the ballot.
            return;
        }
        int preferredCandidate;
        if (random.nextFloat() < 0.5f) {
            // 50% chance of voting for the candidate they lean toward.
            preferredCandidate = lean == VotingSimulation.Leanings.PARTY_A ? 0 : lean == VotingSimulation.Leanings.PARTY_B ? 1 : (int) (Math.random() * (numCandidates - 2)) + 2;
        } else {
            // Equal chance of voting for any other candidate.
            preferredCandidate = (int) (Math.random() * numCandidates);
            while (preferredCandidate == 0 && lean == VotingSimulation.Leanings.PARTY_A || preferredCandidate == 1 && lean == VotingSimulation.Leanings.PARTY_B) {
                preferredCandidate = (int) (Math.random() * numCandidates);
            }
        }

        // Mark the ballot for the preferred candidate.
        ballot.mark(preferredCandidate);

        // Cast the ballot on the voting machine.
        machine.cast(ballot);
    }
}
