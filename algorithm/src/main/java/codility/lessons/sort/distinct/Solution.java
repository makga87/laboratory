package codility.lessons.sort.distinct;

import java.util.HashSet;

/**
 * O(N*log(N)) or O(N)
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> dataSet = new HashSet();

        for(int a : A) {
            dataSet.add(a);
        }

        return dataSet.size();
    }
}
