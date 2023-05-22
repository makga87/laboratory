package stringMatch;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RabinKarp {

    private static String INPUT = "cacacacacacat";

    public static void main(String[] args) {

        RabinKarp rabinKarp = new RabinKarp();

        String keyWord = "cat";
        keyWord.toCharArray();

        int keyWordHashCode = rabinKarp.getHashCode(keyWord);

        for (Character ch : RabinKarp.INPUT.toCharArray()) {

        }
    }

    private int getHashCode(String str) {
        int sum = 0;

        for (Character ch : str.toCharArray()) {
            sum += ch;
        }
        return sum;
    }
}
