package inflearn.step6;

import java.util.Arrays;

public class Consultant {

	private static long result;
	private static int N = 7;
	private static int[][] table = {
			{1, 0},
			{4, 10},
			{1, 20},
			{3, 30},
			{1, 40},
			{2, 35},
			{3, 150},
			{2, 10}
			};
	private static long[] dp;

	public static void main(String[] args) {
		Consultant consultant = new Consultant();

		dp = new long[N + 1];
		Arrays.fill(dp, -1);

		consultant.recur(0);

		for (long l : dp) {
			System.out.println(l);
		}
	}

	public long recur(int idx) {
		System.out.println(idx);
		if(idx > N + 1) {
			return Integer.MIN_VALUE;
		}

		if(idx == N + 1){
			return 0;
		}

		if(dp[idx] != -1) {
			return dp[idx];
		}

		long yes = recur(idx + table[idx][0]);

		long no = recur(idx + 1);

		dp[idx] = Math.max(yes + table[idx][1], no);

		return dp[idx];
	}
}
