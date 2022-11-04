package codility.lessons.maximumSliceProblem.maxDoubleSliceSum;

/**
 * 38%
 */
public class Solution {

    public int solution(int[] A) {

        int max = 0;

        for (int y = 1; y < A.length - 1; y++) {

            int totAccum = 0;

            for (int x = 1; x < y; x++) {
//                System.out.println("x : " + A[x]);
                totAccum = Math.max(totAccum, totAccum + A[x]);
            }

            for (int z = y + 1; z < A.length - 1; z++) {
//                System.out.println("z : " + A[z]);
                totAccum = Math.max(totAccum, totAccum + A[z]);
            }

            max = Math.max(max, totAccum);
//            System.out.println("y : " + y + ", max : " + max);
        }

        return max;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int A[] = {-1, -2, 1, 1, 2, -1, -1, -1};
//        int A[] = {3, 2, 6, -1, 4, 5, -1, 2};
        System.out.println(s.solution(A));

    }
}
