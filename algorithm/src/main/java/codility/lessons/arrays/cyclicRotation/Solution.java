package codility.lessons.arrays.cyclicRotation;

/**
 * 5 min
 */
public class Solution {

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int arrSize = A.length;
        int[] result = new int[arrSize];

        for(int i = 0; i < arrSize; i++) {

            int pos = (i + K) % arrSize;
            result[pos] = A[i];

        }

        return result;
    }
}
