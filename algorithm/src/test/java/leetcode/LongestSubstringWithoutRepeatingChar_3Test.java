package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class LongestSubstringWithoutRepeatingChar_3Test {


    @ParameterizedTest
    @CsvSource({
            "abcabcbb, 3",
            "pwwkew, 3",
            "dvadf, 4",
            "aab, 2"
    })
    public void testAsHashSet(String s, int expected) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {

            if (!set.add(s.charAt(right))) {
                max = Math.max(max, set.size());
                set.remove(s.charAt(left));
                left++;
            } else {
                right++;
            }
        }

        Assertions.assertEquals(expected, Math.max(max, set.size()));
    }

    @ParameterizedTest
    @CsvSource({
            "abcabcbb, 3",
            "pwwkew, 3",
            "dvadf, 4",
            "aab, 2"
    })
    public void testAsArrayList(String s, int expected) {

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int i = 0;
        int max = 0;

        while (i < s.length()) {

            if (map.containsKey(s.charAt(i))) {
                left = map.get(s.charAt(i));
            }

            map.put(s.charAt(i), i);
            right = i;
            max = Math.max(max, right - left);
            i++;
        }

        Assertions.assertEquals(expected, max);
        System.out.println(max);
    }
}