package common;

import org.junit.jupiter.api.Test;

public class JavaApiForAlgorithmTest {

    @Test
    void 숫자_진법_변환(){

       String radix_2 = Integer.toString(14021, 2);
       System.out.println(radix_2);
    }

    @Test
    void 역순_정렬_api(){

        String radix_2 = Integer.toString(14021, 2);

        StringBuilder sb = new StringBuilder();
        sb.append(radix_2);
        sb.reverse();
        System.out.println("정렬 전 : " + radix_2);
        System.out.println("정렬 후 : " + sb);
    }

    @Test
    void 역순_정렬_코드(){

        String target = "hello";

        int length = target.length();
        int half = length / 2;
        int lastIndex = length - 1;
        char[] result = target.toCharArray();

        for(int i = 0; i <= lastIndex; i++){
            if(i >= half) break;

            char s = target.charAt(i);
            char e = target.charAt(lastIndex - i);

            result[lastIndex - i] = s;
            result[i] = e;
        }

        System.out.println("정렬 전 : " + target);
        System.out.println("정렬 후 : " + new String(result));
    }

}
