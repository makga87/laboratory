package codility.lessons.countingElems.permCheck;

import java.util.HashMap;

/**
 *
 * 7 min
 * O(N) or O(N * log(N))
 *
 */
public class Solution {

    // write your code in Java SE 8
    public int solution(int[] A) {
        HashMap<Integer, Boolean> dataMap = new HashMap();

        for(int i = 1; i <= A.length; i++){
            dataMap.put(i, true);
        }

        for(int a : A) {
            dataMap.remove(a);
        }

        if(dataMap.isEmpty()) return 1;
        else return 0;
    }
}
