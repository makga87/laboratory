package codility.lessons.timeComplexity.tapeEquilibrium;

/**
 * 15 min
 * O(N)
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        int total = 0;

        // 총 합을 구한다.
        for(int n : A) {
            total += n;
        }

        int accNum = 0;
        for(int i = 0; i < A.length -1; i++) {

            /**
             * 0번째 인덱스부터 순차적으로 누산값을 구한다
             */
            accNum += A[i];

            /**
             * 총 합 - 누산값을 하면
             * A배열의 P번째부터, 끝까지의 합을 구할 수 있다.
             */
            int pNum = total - accNum;

            /**
             * 실제 지문에서 원하는 값
             * 두 차이의 절대 값을 구한다.
             */
            int temp = accNum - pNum;
            temp = temp < 0 ? temp * (-1) : temp;

            /**
             * P는 인덱스 1부터 시작하므로, 첫 값은 일단 result에 저장
             * 그 이후 부터는, 나오는 절대값들 중에 가장 최소 값을 저장한다.
             */
            if(i < 1) result = temp;
            else {
                result = result > temp ? temp : result;
            }
        }

        return result;
    }
}
