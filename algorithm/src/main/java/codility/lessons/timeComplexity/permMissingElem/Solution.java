package codility.lessons.timeComplexity.permMissingElem;

import java.util.HashMap;

/**
 * 10min
 * O(N) or O(N * log(N))
 */
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;

        HashMap<Integer, Integer> tempMap = new HashMap();
        for(int i = 1; i <= A.length + 1; i++) {
            tempMap.put(i, 1);
        }

        for(int a : A) {
            tempMap.remove(a);
        }

        for(int key : tempMap.keySet()) {
            result = key;
        }

        return result;
    }
}
