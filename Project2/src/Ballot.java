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

    /**
     * Marks the candidate at the given index on the ballot.
     *
     * @param index the index of the candidate to mark
     */
    public void mark(int index) {
        if (index >= 0 && index < candidates.length) {
            candidates[index] = true;
        }
    }

    /**
     * Returns the number of candidates on the ballot.
     *
     * @return the number of candidates on the ballot
     */
    public int countCandidates() {
        return candidates.length;
    }

    /**
     * Returns a copy of the ballot with all candidates unmarked.
     *
     * @return a copy of the ballot with all candidates unmarked
     */
    public Ballot clone() {
        Ballot clone = new Ballot(candidates.length);
        for (int i = 0; i < candidates.length; i++) {
            clone.candidates[i] = false;
        }
        return clone;
    }

    public boolean[] getCandidates() {
        return candidates;
    }
}
