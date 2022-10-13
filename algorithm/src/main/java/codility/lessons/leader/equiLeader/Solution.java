package codility.lessons.leader.equiLeader;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public int solution(int[] A) {

        HashMap<Integer, Integer> dataMap = new HashMap();

        for(int a : A) {
            if(dataMap.containsKey(a)) {
                int cnt = dataMap.get(a) + 1;
                dataMap.put(a, cnt);
            } else {
                dataMap.put(a, 1);
            }
        }

        int maxKey = -1;
        int maxVal = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : dataMap.entrySet()) {
            if(maxVal < entry.getValue()) {
                maxVal = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        int cnt = 0;
        int[] B = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            if(maxKey == A[i]) {
                cnt++;
            }
            B[i] = cnt;
        }

        int result = 0;

        for(int j = 0; j < B.length; j++) {

            int currCnt = j+1;

            int startSize = (currCnt / 2) + 1;
            int endSize = ((B.length - currCnt) / 2) + 1;

            if(B[j] >= startSize && B[B.length-1] - B[j] >= endSize) {
                result++;
            }

        }

        return result;
    }

}
