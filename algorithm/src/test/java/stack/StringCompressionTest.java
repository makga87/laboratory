package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

class StringCompressionTest {

    @ParameterizedTest
    @CsvSource({
            "aabbccc, a2b2c3",
            "QQQLLLLEEWQ, Q3L4E2W1Q1"
    })
    void stringCompressionTestStep1(String input, String expect) {

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int cnt = 1;

        for(char ch : input.toCharArray()) {

            // 1. 스택이 빈 최초의 문자 탐색에는 첫 문자를 일단 스택에 쌓는다.
            if(stack.isEmpty()) {
                result.append(ch);
                stack.push(ch);
                continue;
            }

            // 2. 스택의 피크값과 같은 문자라면, 갯수를 증가시킨다.
            if(stack.peek() == ch) {
                cnt++;
            }

            // 3. 스택의 피크 값이 다른 문자라면, 현재까지 증가된 숫자를 붙이고, 추가로, 변경된 문자를 append한다.
            // 그리고, 다른 문자를 스택에 넣는다.
            else {
                result.append(cnt);
                result.append(ch);
                stack.push(ch);
                cnt = 1;
            }
        }

        // 4. 맨 마지막 문자의 카운팅 값은, 문자가 변경된 상태가 아니어서 3번 로직을 타지 않는다. 그러므로, 맨 마지막에
        // 증가된 카운트를 넣음으로 완성시킨다.
        result.append(cnt);

        Assertions.assertEquals(expect, result.toString());

        // 5. 문자열만 뽑기
        System.out.println(result.toString().replaceAll("[^a-zA-Z]", ""));
        // 6. 숫자만 뽑기
        System.out.println(result.toString().replaceAll("[^0-9]", ""));

    }

}