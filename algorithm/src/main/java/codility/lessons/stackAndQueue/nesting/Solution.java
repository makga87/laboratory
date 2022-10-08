package codility.lessons.stackAndQueue.nesting;

import java.util.Stack;

public class Solution {

    public int solution(String S) {
        // write your code in Java SE 8
        Stack<Character> stack = new Stack();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) return 0;
                stack.pop();
            }
        }

        if (stack.isEmpty()) return 1;

        return 0;
    }
}
