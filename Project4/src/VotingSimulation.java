import java.util.Scanner;

public class VotingSimulation {
    private final int partyACandidates;
    private final int partyBCandidates;
    private final int otherCandidates;
    private final int partyALoyalVoters;
    private final int partyBLoyalVoters;
    private final int independentVoters;
    private final Leanings independentLean;
    private final String partyAName;
    private final String partyBName;
    private final int numCandidates;
    private final String[] candidateNames;


    public enum Leanings {
        PARTY_A, PARTY_B, THIRD_PARTY
    }
    