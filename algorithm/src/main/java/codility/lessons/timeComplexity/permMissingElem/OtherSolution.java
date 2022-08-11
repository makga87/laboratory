package codility.lessons.timeComplexity.permMissingElem;

import java.util.HashMap;

/**
 * 10min
 * O(N) or O(N * log(N))
 */
class OtherSolution {
    public int solution(int[] A) {
        int answer = 0;

        boolean[] contains = new boolean[A.length + 2];
        for(int a : A){
            contains[a] = true;
        }

        for(int i = 1; i < contains.length; i++){
            if(!contains[i]){
                answer = i;
                break;
            }
        }

        return answer;
    }
}
