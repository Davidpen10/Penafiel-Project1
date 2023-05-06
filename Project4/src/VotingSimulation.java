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
    public VotingSimulation() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the name of Party A: ");
        this.partyAName = in.nextLine();
        System.out.println("Enter the name of Party B: ");
        this.partyBName = in.nextLine();

        this.partyACandidates = 1;
        this.partyBCandidates = 1;

        System.out.println("How many other candidates are there, not affiliated with either party?");
        this.otherCandidates = in.nextInt();
        in.nextLine();

        System.out.println("How many voters are loyal to Party A?");
        this.partyALoyalVoters = in.nextInt();
        System.out.println("How many voters are loyal to Party B?");
        this.partyBLoyalVoters = in.nextInt();
        System.out.println("How many independent voters are there?");
        this.independentVoters = in.nextInt();
        in.nextLine();

        System.out.println("Do independents lean toward A, toward B, or toward a third party?");
        System.out.println("Enter A for PARTY_A, B for PARTY_B, or T for THIRD_PARTY");

        while (true) {
            String leaningInput = in.nextLine().toUpperCase();
            if (leaningInput.equals("A")) {
                this.independentLean = Leanings.PARTY_A;
                break;
            } else if (leaningInput.equals("B")) {
                this.independentLean = Leanings.PARTY_B;
                break;
            } else if (leaningInput.equals("T")) {
                this.independentLean = Leanings.THIRD_PARTY;
                break;
            } else {
                // handle invalid input
                System.out.println("Invalid input. Enter A, B, or T.");
            }
        }


        this.numCandidates = this.partyACandidates + this.partyBCandidates + this.otherCandidates;
        this.candidateNames = new String[this.numCandidates];

        candidateNames[0] = "Party A Candidate";
        candidateNames[1] = "Party B Candidate";

        for (int i = 2; i < this.numCandidates; i++) {
            System.out.println("Enter the name of other candidate " + (i - 1) + ": ");
            this.candidateNames[i] = in.nextLine();
        }
        in.close();
    }

    public static void main(String[] args) {
        VotingSimulation simulation = new VotingSimulation();
        simulation.runSimulation();
    }

    public void runSimulation() {
        VotingMachine votingMachine = new VotingMachine();
        votingMachine.configure(this.numCandidates);

        for (int j = 0; j < this.partyALoyalVoters; j++) {
            Voter voter = new LoyalVoter(0);
            voter.vote(votingMachine);
        }

        for (int j = 0; j < this.partyBLoyalVoters; j++) {
            Voter voter = new LoyalVoter(1);
            voter.vote(votingMachine);
        }

        for (int j = 0; j < this.independentVoters; j++) {
            Voter voter = new IndependentVoter(this.independentLean, this.numCandidates);
            voter.vote(votingMachine);
        }
