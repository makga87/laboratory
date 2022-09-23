package codility.lessons.sort.numberOfDiscIntersections;

import java.util.Arrays;


/**
 * https://darkstart.tistory.com/195
 */
public class OtherSolution {

    public int solution(int[] A) {

        long[] lower = new long[A.length];
        long[] upper = new long[A.length];

        for (int i = 0; i < A.length; i++) {
            lower[i] = i - (long) A[i];
            upper[i] = i + (long) A[i];
        }

        Arrays.sort(upper);
        Arrays.sort(lower);

        int intersection = 0;
        int j = 0;

        for (int i = 0; i < A.length; i++) {

            while (j < A.length && upper[i] >= lower[j]) {
                intersection = intersection + j;
                intersection = intersection - i;
                j++;
            }
        }

        if (intersection > 10_000_000)
            return -1;

        return intersection;
    }
}
