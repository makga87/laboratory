package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumII_40Test {

    private List<List<Integer>> result = new ArrayList<>();
    private int[] candidates = {10, 1, 2, 7, 6, 1, 5};

    @Test
    void test() {
        Arrays.sort(candidates);
        recur(0, 8, 0, new ArrayList<>());
        System.out.println(result);
    }

    public void recur(int idx, int target, int sum, ArrayList<Integer> dataList) {

        if (idx == candidates.length || sum > target) {
            return;
        }

        if (target == sum) {
            result.add(new ArrayList<>(dataList));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            dataList.add(candidates[i]);
            recur(i + 1, target, sum + candidates[i], dataList);
            dataList.remove(dataList.size() - 1);
        }
    }
}