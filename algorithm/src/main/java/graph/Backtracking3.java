package graph;

import java.util.ArrayList;
import java.util.List;

public class Backtracking3 {

    private static ArrayList<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("부분집합 생성 과정:");
        generateSubsets(nums);

        System.out.println("결과 : " + resultList);
    }

    public static void generateSubsets(int[] nums) {
        backtrack(nums, new ArrayList<>(), 0, 0);
    }

    private static void backtrack(int[] nums, List<Integer> current, int start, int depth) {
        String indent = getIndent(depth);
        System.out.println(indent + "현재 상태: " + current);

        resultList.add(new ArrayList<>(current));


        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            System.out.println(indent + nums[i] + " 추가 -> " + current);

            backtrack(nums, current, i + 1, depth + 1);

            int removed = current.remove(current.size() - 1);
            System.out.println(indent + removed + " 제거 <- " + current);
        }

        System.out.println(indent + "백트래킹 완료: " + current);
    }
    private static String getIndent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}
