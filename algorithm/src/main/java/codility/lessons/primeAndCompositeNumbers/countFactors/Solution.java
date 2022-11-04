package codility.lessons.primeAndCompositeNumbers.countFactors;

public class Solution {

    public int solution(int N) {
        // write your code in Java SE 8
        int i = 1;
        int cnt = 0;
        while(i * i <= N) {
            if(N % i == 0) {
                if(N / i == i) {
                    cnt++;
                } else {
                    cnt+=2;
                }
            }
            i++;
        }
        return cnt;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution(2147483647));

    }
}
