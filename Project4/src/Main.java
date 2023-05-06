/**
 * The Ballot class represents a ballot that a voter can mark for a candidate.
 * It contains a list of candidates represented by boolean values, where true indicates
 * that the candidate has been marked.
 */
public class Ballot {
    boolean[] candidates;
    /**
     * Constructs a new ballot with the given number of candidates.
     *
     * @param numCandidates the number of candidates on the ballot
     */
    public Ballot(int numCandidates) {
        candidates = new boolean[numCandidates];
    }
