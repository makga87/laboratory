package codility.lessons.stackAndQueue.stoneWall;

// you can also use imports, for example:

import java.util.Stack;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


class OtherSolution2 {

    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < H.length; i++) {
            while (!stack.isEmpty() && stack.peek() > H[i]) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < H[i]) {
                stack.push(H[i]);
                count++;
            }
        }
        return count;
    }

}