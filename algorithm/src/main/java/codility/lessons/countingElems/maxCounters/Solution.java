package codility.lessons.countingElems.maxCounters;

/**
 * 시간초과
 * 정답률 77%
 */
public class Solution {

    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] result = new int[N];

        int max = 0;

        for(int i = 0; i < A.length; i++){

            int pos = A[i] - 1;

            if(A[i] >= 1 && A[i] <= N) {
                result[pos] = result[pos] + 1;
                max = result[pos] > max ? result[pos] : max;
            }

            if(A[i] == N+1) {
                for(int j = 0; j < result.length; j++){
                    result[j] = max;
                }
            }
        }

        return result;
    }
}
