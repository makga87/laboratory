package codility.lessons.iterations.binaryGap;

public class OtherSolution {

    public int solution(int N) {

        int result = 0;
        int count = 0;
        String str = Integer.toString(N , 2);
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                count++;
            }else {
                result = Math.max(result, count);
                count = 0;
            }
        }
        return result;
    }
}

