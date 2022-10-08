package codility.lessons.stackAndQueue.stoneWall;

// you can also use imports, for example:

import java.util.Stack;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/**
 * 42%
 */
class Solution {
    public int solution(int[] H) {
        // write your code in Java SE 8

        Stack<Integer> stack = new Stack();
        int cnt = 0;

        for (int i = 0; i < H.length; i++) {
            if (i == 0) {
                stack.push(H[i]);
            } else {
                if (stack.isEmpty()) {
                    stack.push(H[i]);
                    cnt++;
                } else {
                    while (!stack.isEmpty()) {
                        if (stack.peek() < H[i]) {
                            stack.push(H[i]);
                            break;
                        } else if (stack.peek() > H[i]) {
                            stack.pop();
                            cnt++;
                        } else if (stack.peek() == H[i]) {
                            break;
                        }
                    }
                }

            }
        }

        return stack.size() + cnt;
    }
}