package codility.lessons.maximumSliceProblem.maxDoubleSliceSum;

public class OtherSolution {
    public int solution(int[] A) {

        int n = A.length;

        int[] maxLeftSum = new int[n];
        for (int i = 1; i < n - 1; i++) {
            maxLeftSum[i] = Math.max(maxLeftSum[i - 1] + A[i], 0);
        }

        for(int l : maxLeftSum) {
            System.out.println(l);
        }

        int[] maxRightSum = new int[n];
        for (int i = n - 2; i > 0; i--) {
            maxRightSum[i] = Math.max(maxRightSum[i + 1] + A[i], 0);
        }
        System.out.println();
        for(int r : maxRightSum) {
            System.out.println(r);
        }

        int max_slice = 0;
        for (int i = 1; i < n - 1; i++) {
            System.out.println("maxLeftSum[i - 1] : " +maxLeftSum[i - 1]);
            System.out.println("maxRightSum[i + 1] : " +maxRightSum[i + 1]);
            System.out.println("maxSlice : " + max_slice);
            max_slice = Math.max(max_slice, maxLeftSum[i - 1] + maxRightSum[i + 1]);
        }
        return max_slice;

    }

    public static void main(String[] args) {

        OtherSolution s = new OtherSolution();
//        int A[] = {-1, -2, 1, 1, 2, -1, -1, -1};
        int A[] = {3, 2, 6, -1, 4, 5, -1, 2};
        System.out.println(s.solution(A));

    }
}
