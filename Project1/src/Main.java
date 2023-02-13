import java.util.Scanner;
import java.util.Random;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        int[] amounts = getAmount();
        String[] candidates = getCandidates(amounts[1]); //numCandidates
        // After candidates and parameters are established, the simulation begins


        for (int i = 1; i <= amounts[2]; i++) { //Number of times to run the simulation
            calculateVote(amounts, candidates);
        }
    }

    public static int[] getAmount() {
        System.out.println(" Enter the amount of voters: "); //amounts[0]
        int numVoters = in.nextInt();


        System.out.println(" Enter the amount of candidates: "); //amounts[1]
        int numCandidates = in.nextInt();


        System.out.println(" Enter the amount of times to run the simulation: "); //amounts[2]
        int numTimes = in.nextInt();


        return new int[]{numVoters, numCandidates, numTimes};
    }

    public static String[] getCandidates(int numCandidates) {
        String[] candidates;
        candidates = new String[numCandidates];


        for (int i = 0; i < numCandidates; i++) {
            System.out.println(" Enter the name of candidate " + (i + 1) + " : ");
            if (i == 0) {
                in.nextLine(); //Debug for skipping over first input
            }
            candidates[i] = in.nextLine();
        }
        return candidates;
    }

    public static void calculateVote(int[] amounts, String[] candidates) {
/**
 * simulates a 2 round election based on an array which proceeds with the following:
 * amounts[0] is numVoters
 * amount[1] is numCandidates
 * amount[2] is number of times to run the simulation
 * as well as a second array of the candidates where:
 * candidates[n] refers to the nth candidate
 */


        System.out.println();
        System.out.println(" Two-Round Election with " + amounts[1] + " candidates. ");

        int currentVoters = amounts[0];


        String[] highest;
        highest = new String[2]; // highest [0] is the highest, highest [1] is the second highest num of voters for a candidate


        int highestNum = 0;
        int secondHighestNum = 0;


        int[] voteForCandidates;
        voteForCandidates = new int[amounts[1]];


        for (int i = 0; i < amounts[1]; i++) //assign num votes for each candidate{
        {
            voteForCandidates[i] = rand.nextInt(currentVoters);
            currentVoters -= voteForCandidates[i];
        }


        for (int j = 0; j < amounts[1]; j++) //For every candidate compare their vote to the current highest vote
        {
            if (voteForCandidates[j] > highestNum) {
                highest[1] = highest[0]; //set second highest to previous highest candidate
                highest[0] = candidates[j]; // set highest to new candidate
                secondHighestNum = highestNum; // set 2nd highest vote count to previous highest
                highestNum = voteForCandidates[j]; //set new bar to be met for the if statement


            } else if (voteForCandidates[j] > secondHighestNum) {
                secondHighestNum = voteForCandidates[j];
                highest[1] = candidates[j];
            }
            System.out.println(candidates[j] + " received " + (100 * ((double) voteForCandidates[j] / amounts[0])) + " % of the vote");
        }
        System.out.println((100 * ((double) currentVoters / amounts[0])) + " % of the voters abstained");


        for (int k = 0; k < amounts[1]; k++) //see if any candidate won in the first round
        {
            if (voteForCandidates[k] > (double) amounts[0] / 2) {
                System.out.println(candidates[k] + " has won the election with " + (100 * ((double) voteForCandidates[k] / amounts[0])) + " % of the vote ");
                return;
            }
        }
        //second round, which only needs one iteration because there's only two candidates
        System.out.println(" The highest two that will compete in the second round will be " + highest[0] + " and " + highest[1]);
        int finalVote = rand.nextInt(amounts[0]);
        if (finalVote >= amounts[0] / 2) {
            System.out.println(highest[0] + " has won the election with " + (100 * ((double) finalVote / amounts[0])) + " % of the vote ");
        } else {
            System.out.println(highest[1] + " has won the election with " + (100 * ((double) finalVote / amounts[0])) + " % of the vote ");
        }
        System.out.println((100 * ((double) (amounts[0] - finalVote) / amounts[0])) + " % of the voters abstained ");
    }
}




