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
