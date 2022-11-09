package codility.lessons.primeAndCompositeNumbers.minPerimeterRectangle;

public class Solution {

    public int solution(int N) {

        int n = (int) Math.sqrt(N);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {

            if (N % i == 0) {
                int quotient = N / i;

                int perimeter = 2 * (quotient + i);
                min = Math.min(perimeter, min);

            }
        }

        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(30);
        System.out.println(result);
    }
}
