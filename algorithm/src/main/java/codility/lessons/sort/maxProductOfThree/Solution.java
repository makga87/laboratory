package codility.lessons.sort.maxProductOfThree;

import java.util.Arrays;

/**
 * O(N * log(N))
  */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8

        Arrays.sort(A);

        int first = A[0];
        int second = A[1];
        int third = A[A.length - 1];

        int max = third * A[A.length - 2] * A[A.length - 3];

        if(first < 0 && second < 0) {
            int temp = first * second * third;
            return temp > max ? temp : max;
        }

        return max;
    }
}
