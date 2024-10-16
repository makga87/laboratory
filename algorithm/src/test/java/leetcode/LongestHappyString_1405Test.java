package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;


class LongestHappyString_1405Test {

    @Test
    void test() {
        int a = 1;
        int b = 1;
        int c = 7;

//		int a = 1;
//		int b = 0;
//		int c = 7;

        String result = exec1(a, b, c);
        System.out.println(result);
    }


    private String exec1(int a, int b, int c) {

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((v1, v2) -> v2.getValue().compareTo(v1.getValue()));

        Map<String, Integer> map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            Map.Entry<String, Integer> first = pq.poll();
            Map.Entry<String, Integer> second = pq.poll();

            if (first.getValue() >= 2) {
                sb.append(first.getKey()).append(first.getKey());
                first.setValue(first.getValue() - 2);
                pq.offer(first);
            }

            if (second == null || second.getValue() == 0) {
                break;
            }

            if (second.getValue() >= 1) {
                sb.append(second.getKey());
                second.setValue(second.getValue() - 1);
                pq.offer(second);
            }
        }

        return sb.toString();

    }

    private String exec2(int a, int b, int c) {
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((v1, v2) -> v2.getValue().compareTo(v1.getValue()));

        Map<Character, Integer> map = new HashMap<>();
        if (a > 0) map.put('a', a);
        if (b > 0) map.put('b', b);
        if (c > 0) map.put('c', c);

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> first = pq.poll();

            if (sb.length() >= 2 &&
                    sb.charAt(sb.length() - 1) == first.getKey() &&
                    sb.charAt(sb.length() - 2) == first.getKey()) {

                if (pq.isEmpty()) break;

                Map.Entry<Character, Integer> second = pq.poll();
                sb.append(second.getKey());
                second.setValue(second.getValue() - 1);

                if (second.getValue() > 0) pq.offer(second);
                pq.offer(first);
            } else {
                sb.append(first.getKey());
                first.setValue(first.getValue() - 1);

                if (first.getValue() > 0) pq.offer(first);
            }
        }

        return sb.toString();

    }

}