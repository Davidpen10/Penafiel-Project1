//Gives the vote to the candidate with the highest current votes
//Gives the vote to the first candidate if all candidates have 0 votes
public class LeadVoter implements Voter {
    @Override
    public void vote(VotingMachine machine) {
        // Get the ballot from the voting machine.
        Ballot ballot = machine.getBallot();

        // Determine the number of candidates available on the ballot.
        int numCandidates = ballot.getCandidates().length;
        //Get vote count for each candidate
        int[] voteCounts = machine.getVoteCounts();

