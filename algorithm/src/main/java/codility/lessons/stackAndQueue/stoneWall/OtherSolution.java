package codility.lessons.stackAndQueue.stoneWall;

// you can also use imports, for example:

import java.util.Stack;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


class OtherSolution {

    public int solution(int[] H) {
        int result = 0;
        Stack<Integer> s = new Stack<Integer>();
        s.push(H[0]);
        for (int i = 1; i < H.length; ++i) {
            while (!s.empty()) {
                if (s.peek() > H[i]) {
                    ++result;
                    s.pop();
                } else if (s.peek() < H[i]) {
                    s.push(H[i]);
                    break;
                } else break;
            }
            if (s.empty()) s.push(H[i]);
        }
        return result + s.size();
    }

}