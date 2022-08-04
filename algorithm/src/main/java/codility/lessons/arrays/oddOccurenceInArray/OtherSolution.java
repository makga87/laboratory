package codility.lessons.arrays.oddOccurenceInArray;

public class OtherSolution {
    /**
     * XOR 을 이용한 방법이라고 하는데,
     * 예외는 발생안하나 보다...
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int result = 0;
        for(int a : A) {
            result ^= a;
        }
        return  result;
    }
}
