package greedy;

import org.junit.jupiter.api.Test;

class DIStringMatchTest {

    @Test
    void diStringMatchTest() {

        String s = "IDID";

        int len = s.length();
        char[] ch = s.toCharArray();
        int[] ans = new int[len+1];

        int x = 0;
        int y = len;

        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == 'I'){
                ans[i] = x++;
            } else {
                ans[i] = y--;
            }
        }

        // 마지막 글자에 따라, 넣을 마지막 값을 정한다
        if(ch[ch.length-1] == 'I') {
            ans[len] = x;
        } else {
            ans[len] = y;
        }
    }


}