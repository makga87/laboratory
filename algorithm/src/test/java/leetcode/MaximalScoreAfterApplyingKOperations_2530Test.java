package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;


class MaximalScoreAfterApplyingKOperations_2530Test {

	private int k = 5;
	private int[] nums = {10, 10, 10, 10, 10};
	private int score;

	@Test
	public void test() {
		exec1();
	}


	public void exec1() {
		PriorityQueue<Integer> maximalScore = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < nums.length; i++) {
			maximalScore.offer(nums[i]);
		}

		long sum = 0;

		for (int i = 1; i <= k; i++) {
			int max = maximalScore.poll();
			sum += (long) max;
			double num = Math.ceil(max / 3d);
			max = (int) num;
			maximalScore.offer(max);
		}

		System.out.println(sum);
	}
}