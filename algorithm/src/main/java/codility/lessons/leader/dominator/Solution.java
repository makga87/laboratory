package codility.lessons.leader.dominator;

import java.util.HashMap;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length == 0) return -1;
        if(A.length == 1 || A.length == 2) return 0;

        int dominatorSize = A.length % 2 == 0 ? A.length / 2 : (A.length / 2) + 1;

        HashMap<Integer, Integer> dataMap = new HashMap();

        for(int i = 0; i < A.length; i++) {

            if(dataMap.containsKey(A[i])) {

                int value = dataMap.get(A[i]);
                value++;
                if(value >= dominatorSize) return i;
                else {
                    dataMap.put(A[i], value);
                }

            } else {
                dataMap.put(A[i], 1);
            }
        }
        return -1;
    }
}