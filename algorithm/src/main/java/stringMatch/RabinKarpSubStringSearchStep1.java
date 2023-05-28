package stringMatch;


/**
 * 비효율적인 버전 STEP1
 */
public class RabinKarpSubStringSearchStep1 {

    private static String INPUT = "cacacat";

    public static void main(String[] args) {

        RabinKarpSubStringSearchStep1 rabinKarp = new RabinKarpSubStringSearchStep1();

        String keyWord = "cat";

        char[] keywordSearchArr = new char[keyWord.length()];

        // 키워드의 해시 함수를 구한다
        int keyWordHashCode = rabinKarp.getHashCode(keyWord.toCharArray());

        int currIdx = 0;

        while (currIdx <= (INPUT.length() - keyWord.length())) {
            // 입력값의 인덱스 중 3개만, 배열에 할당
            for (int j = 0; j < keyWord.length(); j++) {
                keywordSearchArr[j] = INPUT.charAt(j + currIdx);
            }
            System.out.println(String.valueOf(keywordSearchArr));

            // 입력값의 substring 배열의 해시값을 구한다
            int inputHashCode = rabinKarp.getHashCode(keywordSearchArr);
            // 입력값의 해시값과, 키워드의 해시값을 비교한다
            if (inputHashCode == keyWordHashCode) {
                // 해시 값이 같은 경우만, 인덱스를 반환
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
