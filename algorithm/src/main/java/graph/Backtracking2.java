package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Backtracking2 {

	private static List<List<Integer>> result = new ArrayList<>();

	public static void main(String[] args) {

		List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
		Backtracking2 backtracking1 = new Backtracking2();
		backtracking1.backtracking(input, new ArrayList<>());

		System.out.println(backtracking1.result);
	}

	public static void backtracking(List<Integer> input, List<Integer> temp){

		ArrayList<Integer> dataList = new ArrayList<>(temp);
		for(int i = 0; i < input.size(); i++) {
			int val = input.get(i);
			if(dataList.contains(val)) continue;
			dataList.add(val);
			backtracking(input, dataList);
			System.out.println("========= round start =========");

			System.out.println(dataList);
//			System.out.println(dataList.get(dataList.size()-1));
			dataList.remove(dataList.size()-1);
			System.out.println(dataList);
			System.out.println("========= round end =========");
		}

		result.add(dataList);
	}
}
