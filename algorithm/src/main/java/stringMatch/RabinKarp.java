package stringMatch;

public class RabinKarp {

    private static String INPUT = "cacacat";

    public static void main(String[] args) {

        RabinKarp rabinKarp = new RabinKarp();

        String keyWord = "cat";

        char[] keywordSearchArr = new char[keyWord.length()];

        int keyWordHashCode = rabinKarp.getHashCode(keyWord.toCharArray());

        int currIdx = 0;

        while (currIdx <= (INPUT.length() - keyWord.length())) {

            for (int j = 0; j < keyWord.length(); j++) {
                keywordSearchArr[j] = INPUT.charAt(j + currIdx);
            }
            System.out.println(String.valueOf(keywordSearchArr));

            int inputHashCode = rabinKarp.getHashCode(keywordSearchArr);
            if (inputHashCode == keyWordHashCode) {
                if (rabinKarp.check(keyWord.toCharArray(), keywordSearchArr)) {
                    System.out.println("Found keyword in INPUT. The position start is " + currIdx);
                }
            }

            currIdx++;

        }

    }

    private int getHashCode(char[] chars) {

        int sum = 0;

        for (Character ch : chars) {
            sum += ch;
        }
        System.out.printf("Hashcode : %d, chars : %s \n", sum, String.valueOf(chars));
        return sum;
    }

    private boolean check(char[] keyword, char[] temp) {
        boolean result = true;
        for (int i = 0; i < keyword.length; i++) {
            result &= keyword[i] == temp[i];
        }

        return result;
    }
}
