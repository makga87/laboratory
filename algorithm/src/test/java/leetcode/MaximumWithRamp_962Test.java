package leetcode;

import java.util.Stack;

import org.junit.jupiter.api.Test;


class MaximumWithRamp_962Test {


	@Test
	public void test() {
//		int[] nums = {6, 0, 8, 2, 1, 5};
//		int expected = 4;
				int[] nums = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
				int expected = 7;
//				int[] nums = {4, 3, 2, 0, 1, 0, 2, 1};
//				int expected = 4;


		int result = exec2(nums);

		System.out.println(result);
	}

	// 완전 탐색적 사고로
	public int exec1(int[] nums) {

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int leftNum = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				int rightNum = nums[j];
				if (leftNum > rightNum) {
					continue;
				}
				max = Math.max(max, j - i);
			}
		}
		return max;
	}


	public int exec2(int[] nums) {

		Stack<Integer> stack = new Stack<>();

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (stack.isEmpty() || nums[stack.peek()] >= nums[i]) {
				stack.push(i);
			}
		}

		for (int i = nums.length - 1; i >= 0; i--) {

			while(!stack.empty() && nums[stack.peek()] <= nums[i]) {
				max = Math.max(i - stack.pop(), max);
			}
		}
		return max;
	}
}