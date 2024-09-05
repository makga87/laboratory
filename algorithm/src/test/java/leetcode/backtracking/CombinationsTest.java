package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CombinationsTest {

	private Map<Integer, Integer> dataTemp = new HashMap<>();

	@Test
	public void solution() {
		int n = 4;
		int k = 2;

		List<List<Integer>> result = combine(4, 2);

		System.out.println(result);
	}

	private List<List<Integer>> combine(int n, int k, List<Integer> unit) {

		List<List<Integer>> result = new ArrayList<>();

		for (int i = 1; i <= k; i++) {
			List<Integer> unit = new ArrayList<>();
			combine()
		}

		System.out.println(result);

		return result;
	}



	public boolean notExsit(int n, int k) {
		if (dataTemp.isEmpty()) {
			return true;
		}

		return dataTemp.containsKey(n) && dataTemp.containsValue(k);
	}
}
