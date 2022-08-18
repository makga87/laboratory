package codility.lessons.countingElems.maxCounters;

/**
 * 시간초과
 * O(N + M)
 */
public class Solution2 {

    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] result = new int[N];

        int max = 0;
        int maxTemp = 0;

        for(int i = 0; i < A.length; i++){

            if(A[i] >= 1 && A[i] <= N) {
                int pos = A[i] - 1;
                if(result[pos] < maxTemp){
                    result[pos] = maxTemp + 1;
                } else {
                    result[pos]++;
                }

                max = result[pos] > max ? result[pos] : max;

            }

            if(A[i] == N+1) {
                maxTemp = max;
            }
        }

        for(int j = 0; j < result.length; j++){
            if(result[j] < maxTemp) result[j] = maxTemp;
        }

        return result;
    }
}
