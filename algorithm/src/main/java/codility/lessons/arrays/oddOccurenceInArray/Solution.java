package codility.lessons.arrays.oddOccurenceInArray;

import java.util.HashMap;

/**
 * 22 min
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        HashMap<Integer, Integer> cntMap = new HashMap();

        for(int i = 0; i < A.length; i++) {
            if(cntMap.containsKey(A[i])) {
                cntMap.remove(A[i]);
            } else {
                cntMap.put(A[i], 1);
            }

        }

        /**
         * for 문 이지만, 숫자는 1개만 존재
         */
        for(int key : cntMap.keySet()) {
            result = key;
        }

        return result;
    }
}
