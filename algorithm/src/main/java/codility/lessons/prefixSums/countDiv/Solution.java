package codility.lessons.prefixSums.countDiv;

/**
 * 1 hour 20min
 *
 * O(1)
 *
 */
public class Solution {

    public int solution(int A, int B, int K) {
        int result = 0;
        int AmodPos = 0;
        int BmodPos = 0;

        if (A % K == 0) {
            AmodPos = A;
        } else {
            AmodPos = A + (K - (A % K));
        }

        if (B % K == 0) {
            BmodPos = B;
        } else {
            BmodPos = B - (B % K);
        }

        result = ((BmodPos - AmodPos) / K) + 1;

        return result;
    }
}
