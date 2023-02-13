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
            if(i == 0) {
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




