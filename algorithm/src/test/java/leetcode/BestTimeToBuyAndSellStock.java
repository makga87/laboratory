package leetcode;

import org.junit.jupiter.api.Test;

public class BestTimeToBuyAndSellStock {


	/**
	 * 오답
	 * 시간 초과 발생
	 */
	@Test
	void wrongAnswer() {

		int max = 0;
		int[] prices = {7, 6, 4, 3, 1};

		for (int i = 0; i < prices.length; i++) {

			for (int j = i + 1; j < prices.length; j++) {

				int value = prices[j] - prices[i];
				if (value > 0) {
					max = Math.max(max, value);
				}
			}
		}

		System.out.println(max);
	}

	/**
	 * 정답
	 */
	@Test
	void wronAnswer() {

		int buy = Integer.MAX_VALUE;
		int sell = 0;

		int[] prices = {7, 6, 4, 3, 1};

		for (int i = 0; i < prices.length; i++) {
			// 가장 싼걸 산다
			buy = Math.min(buy, prices[i]);
			// 가장 비쌀때 판다
			sell = Math.max(sell, prices[i] - buy);
		}

		System.out.println(sell);
	}
}
