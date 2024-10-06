package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class CombinationSumTest {
	private int[] candidates = {2, 3, 6, 7};
	private int target = 7;
	private List<List<Integer>> results = new ArrayList<>();

	@Test
	public void combinationSumTest() {

		recur(0, 0, new ArrayList<>());

		System.out.println(results);
	}

	/**
	 * 모든 조합을 보려면 다음과 같이
	 * @param idx
	 * @param sum
	 * @param nums
	 */
	public void recur(int idx, int sum, List<Integer> nums) {
		if(sum > target){
			return;
		} else if (sum == target) {
			results.add(new ArrayList<>(nums));
			return;
		}

		for(int i = 0; i < candidates.length; i++) {
			nums.add(candidates[i]);
			recur(i, sum + candidates[i], nums);
			nums.remove(nums.size() - 1);
		}

	}

	/**
	 * 같은 인덱스는 중복을 허용하지만, next idx에 대해서만 조합을 할 경우
	 * @param idx
	 * @param sum
	 * @param nums
	 */
	public void recur2(int idx, int sum, List<Integer> nums) {
		if(sum > target){
			return;
		} else if (sum == target) {
			results.add(new ArrayList<>(nums));
			return;
		}

		for(int i = idx; i < candidates.length; i++) {
			nums.add(candidates[i]);
			recur(i, sum + candidates[i], nums);
			nums.remove(nums.size() - 1);
		}

	}

}