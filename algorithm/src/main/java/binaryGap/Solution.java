package binaryGap;

import java.util.Stack;

/**
 * 1 Hour
 */
public class Solution {

    public int solution(int N) {
        // write your code in Java SE 8
        return N > 0 ? getMaxBinaryGap(N) : 0;
    }

    private int getMaxBinaryGap(int N) {
        Stack<Integer> binaryStack = new Stack<>();

        binary(N, binaryStack);

        int max = 0;
        int pos = 0;
        int cnt = 0;

        while (!binaryStack.empty()) {
            int temp = binaryStack.pop();
            if (temp > 0) {
                int maxTemp = cnt - pos - 1;
                max = max < maxTemp ? maxTemp : max;
                pos = cnt;
            }
            cnt++;
        }
        return max;
    }


    private void binary(int N, Stack<Integer> binaryStack) {

        binaryStack.push(remain(N));

        int _div = divide(N);
        if (_div > 1) {
            binary(_div, binaryStack);
        } else {
            binaryStack.push(_div);
        }
    }

    private int divide(int N) {
        return N / 2;
    }

    private int remain(int N) {
        return N % 2;
    }

}
