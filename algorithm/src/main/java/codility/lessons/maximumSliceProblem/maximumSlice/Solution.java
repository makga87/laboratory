package codility.lessons.maximumSliceProblem.maximumSlice;

public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int accum = 0;
        int max = 0;

        for(int i = 0; i < A.length; i++) {
            if(i == 0) {
                accum = A[i];
                max = A[i];
            } else {
                accum = Math.max(A[i], accum + A[i]);
                max = Math.max(accum, max);
            }
        }
        return max;
    }
}
