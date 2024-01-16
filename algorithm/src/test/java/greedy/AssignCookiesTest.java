package greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AssignCookiesTest {

    @Test
    void test(){

//        int[] g= {1,2,3};
//        int[] g= {1,2};
        int[] g= {10,9,8,7};
//        int[] s = {1,1};
//        int[] s = {1,2,3};
        int[] s = {5,6,7,8};

        int cnt = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        while(i < g.length && j < s.length){
            if(g[i] <= s[j]) {
                cnt++;
                i++; j++;
            }
            else j++;
        }


        System.out.println(cnt);
    }
}