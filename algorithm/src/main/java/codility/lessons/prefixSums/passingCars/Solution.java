package codility.lessons.prefixSums.passingCars;

/**
 * O(N)
 *
 * 45min
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;

        int cnt = 0;
        int total = 0;

        for (int a : A) {
            if (a == 1) total++;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                result += total - cnt;
                if (result > 1000000000) return -1;
            } else {
                cnt++;
            }
        }

        return result;
    }
}

