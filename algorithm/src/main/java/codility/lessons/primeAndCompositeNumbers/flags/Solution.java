package codility.lessons.primeAndCompositeNumbers.flags;

import java.util.ArrayList;

public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8

        if (A.length <= 2) return 0;

        ArrayList<Integer> dataList = new ArrayList<>();

        int i = 1;
        while (i < A.length - 1) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                dataList.add(i);
                i += 2;
            } else {
                i++;
            }
        }

        if (A.length < 5 && !dataList.isEmpty()) return 1;

        int peakCnt = dataList.size();
        int max = 0;
        int flag = 1;

        while (flag <= peakCnt) {

            int remainFlag = flag;

            int flagCnt = 0;
            int before = 0;
            int current = 0;

            for (int j = 0; j < dataList.size(); j++) {

                if (j == 0) {
                    flagCnt++;
                    before = dataList.get(j);
                } else {
                    current = dataList.get(j);
                    int dist = Math.abs(before - current);

                    if (dist >= flag) {
                        flagCnt++;
                        remainFlag--;
                        before = current;
                    }

                    if (remainFlag < 1) break;
                }
            }

            max = Math.max(max, flagCnt);
            flag++;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        int result = solution.solution(A);

        System.out.println("result = " + result);
    }
}
