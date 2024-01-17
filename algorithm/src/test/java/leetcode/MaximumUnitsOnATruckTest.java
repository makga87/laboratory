package leetcode;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

class MaximumUnitsOnATruckTest {

	@Test
	void test() {
//		int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
		int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
//		int truckSize = 4;
		int truckSize = 10;

		Arrays.sort(boxTypes, Comparator.comparingInt((int[] o) -> o[1]).reversed());

		int totalItemSize = 0;
		int totalBoxSize = 0;
		for (int i = 0; i < boxTypes.length; i++) {

			int size = boxTypes[i][0];
			int unit = boxTypes[i][1];

			if ((totalBoxSize + size) > truckSize) {
				totalItemSize += (truckSize - totalBoxSize) * unit;
				break;
			} else {
				totalItemSize += size * unit;
				totalBoxSize += size;
			}
		}

		System.out.println(totalItemSize);


	}
}