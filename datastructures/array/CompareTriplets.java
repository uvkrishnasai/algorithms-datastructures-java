package datastructures.array;

/**
 * Link: https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class CompareTriplets {

    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
        int aliceScore = 0;
        int bobScore = 0;

        int[] aliceScores = {a0, a1, a2};
        int[] bobScores = {b0, b1, b2};

        for (int i = 0; i <=2; i++) {
            if (compareScores(aliceScores[i], bobScores[i]) == 0)
                continue;
            else if(compareScores(aliceScores[i], bobScores[i]) == 1)
                aliceScore++;
            else
                bobScore++;
        }

        int[] result = {aliceScore, bobScore};
        return result;
    }

    static int compareScores(int aliceScore, int bobScore) {
        if (aliceScore == bobScore) {
            return 0;
        } else if (aliceScore > bobScore) {
            return 1;
        } else {
            return -1;
        }
    }

}
