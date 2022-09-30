package codility.lessons.stackAndQueue.brackets;

import java.util.Stack;

public class Solution {
    public int solution(String S) {
        char[] charArr = S.toCharArray();
        Stack<Character> stack = new Stack();

        for (char ch : charArr) {
            if (ch == '{' || ch == '[' || ch == '(') stack.add(ch);
            else if (ch == '}' || ch == ']' || ch == ')') {
                /**
                 * 오픈 브라킷이 없는데, 클로즈 부터 나오는 경우, 즉시 실패
                 */
                if (stack.isEmpty()) return 0;

                char _ch = stack.pop();
                if (_ch == '{' && ch != '}') return 0;
                if (_ch == '[' && ch != ']') return 0;
                if (_ch == '(' && ch != ')') return 0;
            }
        }

        /**
         * 스택에 남아있는 것이 있으면 실패
         */
        if (!stack.isEmpty()) return 0;

        return 1;
    }
}
