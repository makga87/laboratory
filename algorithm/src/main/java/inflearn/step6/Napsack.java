package inflearn.step6;

import java.util.Arrays;

public class Napsack {

	private static int N = 4;
	private static int B = 7;

	private static int[][] dp;

	private static int[][] wv = {
			{0, 0},
			{6, 13},
			{4, 8},
			{3, 6},
			{5, 12}
	};

	public static void main(String[] args) {
		dp = new int[N + 1][100];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		Napsack napsack = new Napsack();
		napsack.recur(0, 0);


		int max = Arrays.stream(dp)
						.flatMapToInt(Arrays::stream)
						.max()
						.getAsInt();

//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++) {
//				System.out.printf("%d ", dp[i][j]);
//			}
//			System.out.println();
//		}

		System.out.println(max);
	}

	public int recur(int idx, int w) {
		if (w > B) {
			return Integer.MIN_VALUE;
		}
		if (idx == N) {
			return 0;
		}

		if (dp[idx][w] != -1) {
			return dp[idx][w];
		}


		int yes = recur(idx + 1, w + wv[idx][0]) + wv[idx][1];
		int no = recur(idx + 1, w);

		dp[idx][w] = Math.max(yes, no);

		return dp[idx][w];
	}
}

