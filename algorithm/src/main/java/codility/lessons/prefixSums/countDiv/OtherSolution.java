package codility.lessons.prefixSums.countDiv;

/**
 * 1 hour 20min
 * O(1)
 */
public class OtherSolution {

    public int solution(int A, int B, int K) {

        int result = B / K - A / K;
        return A % K == 0 ? result + 1 : result;
    }
}
