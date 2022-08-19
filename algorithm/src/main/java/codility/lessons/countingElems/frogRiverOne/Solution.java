package codility.lessons.countingElems.frogRiverOne;

import java.util.HashMap;

/**
 * 12 min
 * O(N)
 */
public class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int result = -1;

        HashMap<Integer, Boolean> posMap = new HashMap();
        for(int i = 1; i <= X; i++){
            posMap.put(i, true);
        }

        for(int j = 0; j < A.length; j++) {

            posMap.remove(A[j]);

            if(posMap.isEmpty()) {
                result = j;
                break;
            }

        }

        return result;
    }
}
