package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

class LongestPelindromeTest {

    @ParameterizedTest
    @CsvSource({"abccccdd, 7", "a, 1"})
    void longestPelindromeTest(String input, int result) {
        int totalSize = 0;

        Map<Character, Integer> dataMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            if(dataMap.containsKey(ch)) {
                dataMap.put(ch, dataMap.get(ch) + 1);
            }else{
                dataMap.put(ch, 1);
            }
        }

        boolean addOne = false;
        for(Character ch : dataMap.keySet()) {
            int cnt = dataMap.get(ch);
            if(cnt % 2 == 0) {
                totalSize += cnt;
            } else {
                totalSize += cnt -1;
                addOne = true;
            }
        }

        totalSize = addOne ? totalSize+1 : totalSize;

        Assertions.assertEquals(result, totalSize);
    }
}