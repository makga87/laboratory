package codility.lessons.timeComplexity.frogJump;

/**
 * 5 min
 * O(1)
 */
public class Solution {

    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8

        int pos = Y - X;
        if(pos < 1) return 0;
        else {
            if(pos % D > 0) return (pos / D) + 1;
            else return pos / D;
        }

    }
}
