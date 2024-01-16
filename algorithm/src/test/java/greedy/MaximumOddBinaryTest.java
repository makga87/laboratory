package greedy;

import org.junit.jupiter.api.Test;

class MaximumOddBinaryTest {

    @Test
    void test() {
        String s = "0101";
        int oneCnt = 0;
        char[] ch = s.toCharArray();

        for (char c : s.toCharArray()) {
            if (c == '1') oneCnt++;
        }

        if (s.length() == oneCnt) return;

        ch[s.length() - 1] = '1' ;
        oneCnt--;
        for (int i = 0; i < s.length()-1; i++) {
            if (oneCnt >= 1) {
                ch[i] = '1' ;
                oneCnt--;
            } else {
                ch[i] = '0' ;
            }
        }


        String result = String.valueOf(ch);

        System.out.println(result);


    }

}