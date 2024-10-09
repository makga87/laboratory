package leetcode.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;


public class SubsetsTest {

	private List<List<Integer>> results = new ArrayList<>();

	@Test
	public void subsetsTest() {

//		int[] nums = {0};
		int[] nums = {1, 2, 3};

		backtracking(new ArrayList<>(), nums, 0);


		for (List<Integer> result : results) {
			for (Integer i : result) {
				System.out.printf("%d ", i);
			}
			System.out.println();
		}

	}

	public void backtracking(List<Integer> list, int[] nums, int j) {

		results.add(new ArrayList<>(list));

		for(int i = j; i < nums.length; i++) {
			list.add(nums[i]);
			backtracking(list, nums, i+1);
			list.remove(list.size() - 1);
		}
	}

	public void backtracking2(List<Integer> list, int[] nums, int j) {

		if(j == nums.length) {
			return;
		}
		if(list.contains(nums[j])) {
			return;
		}
		results.add(list);

		list.add(nums[j]);
		backtracking2(new ArrayList<>(list), nums, j+1);
		list.remove(list.size() - 1);
	}
}
