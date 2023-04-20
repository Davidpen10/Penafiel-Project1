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

        //Assume -1 is the highest vote count
        int highest = -1;

        //Index of the leading a candidate
        int leadingCandidateIndex = -1;

        for (int i = 0; i < voteCounts.length; i++){
            if (voteCounts[i] > highest) {
                highest = voteCounts[i];
                leadingCandidateIndex = i;
            }
        }

        // Mark the ballot for the preferred candidate.
        ballot.mark(leadingCandidateIndex);


        // Cast the ballot on the voting machine.
        machine.cast(ballot);
    }
}
