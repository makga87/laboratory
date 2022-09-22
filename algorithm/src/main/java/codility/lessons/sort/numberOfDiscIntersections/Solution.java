package codility.lessons.sort.numberOfDiscIntersections;

public class Solution {

    public int solution(int[] A) {

        int result = 0;

        for(int i = 0; i < A.length; i++) {

            for(int j = i + 1; j < A.length; j++) {
                result += getValue(i, j, A[i], A[j]);
                if(result > 10000000) return -1;
            }
        }

        return result;
    }

    public int getValue(int x1, int x2, int r1, int r2) {
        if((x2 - x1) <= r1 + r2) return 1;
        return 0;
    }
}
