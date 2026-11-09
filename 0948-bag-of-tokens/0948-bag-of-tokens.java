import java.util.*;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;

        int score = 0;
        int maxScore = 0;

        while (left <= right) {

            // Gain score
            if (power >= tokens[left]) {

                power -= tokens[left];
                left++;

                score++;
                maxScore = Math.max(maxScore, score);
            }

            // Gain power
            else if (score > 0) {

                power += tokens[right];
                right--;

                score--;
            }

            // No move possible
            else {
                break;
            }
        }

        return maxScore;
    }
}