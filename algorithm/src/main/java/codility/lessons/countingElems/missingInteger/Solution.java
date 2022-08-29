package codility.lessons.countingElems.missingInteger;

import java.util.HashMap;

/**
 * 6min
 * O(N) or O(N * log(N))
 *
 * 첫 예시가 잘 주어졌기에 금새 풀었지만,
 * 문장에서 항시, 마이너한 값, 플러스한 값, 미들 값 기준을 테스트 해보기!
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = -1;

        HashMap<Integer, Boolean> dataMap = new HashMap();

        for(int a : A) {
            dataMap.put(a, true);
        }

        for(int i = 1; i <= A.length; i++){
            if(dataMap.get(i) == null) return i;
        }


        return A.length + 1;
    }
}
