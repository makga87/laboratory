package codility.lessons.maximumSliceProblem.maxmumProfit;

/**
 * O(N)
 */
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int B[] = new int[A.length - 1];

        for(int i = 0; i < A.length - 1; i++){
            B[i] = A[i+1] - A[i];
        }

        int accumulation = 0;
        int max = 0;

        for(int b : B) {
            accumulation = 0 > (accumulation + b) ? 0 : accumulation + b;
            max = max > accumulation ? max : accumulation;
        }

        return max;
    }
}