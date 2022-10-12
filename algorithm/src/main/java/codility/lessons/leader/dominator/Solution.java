package codility.lessons.leader.dominator;

import java.util.HashMap;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int length = A.length;
        if(length == 0) return -1;
        if(length == 1 || length == 2) return 0;

        int moreThan = (length/2) + 1;

        HashMap<Integer, Integer> dataMap = new HashMap();
        for(int i = 0; i < length; i++) {
            if(dataMap.containsKey(A[i])) {
                int cnt = dataMap.get(A[i]) + 1;
                if(cnt >= moreThan) return i;
                dataMap.put(A[i], cnt);
            } else {
                dataMap.put(A[i], 1);

            }
        }

        return -1;
    }
}