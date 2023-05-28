package stringMatch;

/**
 * ASC II 값만으로 구해보는 라빈 카프 문자열 검색
 */
public class RabinKarpSubStringSearchStep2 {

    public static void main(String[] args) {

        RabinKarpSubStringSearchStep2 rabinKarp = new RabinKarpSubStringSearchStep2();
        String INPUT = "ctcaacabfswacacat";

        String keyword = "cat";

        rabinKarp.searchMatchingStringIndex(INPUT, keyword);
    }

    public int searchMatchingStringIndex(String INPUT, String TARGET) {

        // 기본 해시 값들을 먼저 구한다.
        int keywordHash = getDefaultHash(TARGET, TARGET.length());
        int currentHash = getDefaultHash(INPUT, TARGET.length());

        for (int i = 0; i <= INPUT.length() - TARGET.length(); i++) {

            // 해시 값이 같디면, 문자열이 정말 같은지 비교한다.
            if (keywordHash == currentHash) {
                boolean isMatched = checkIsMatchedString(TARGET, INPUT, i);

                if (isMatched) {
                    System.out.println("Found keyword in INPUT. The position start is " + i);
                    return i;
                }
            }

            // 해시 값이 같지 않다면, 문자열이 다를 수 있으므로, 가장오래된 해시 값을 제거, 가장 최신 값을 더한다.
            // 이것이 롤링 해시 매직~
            currentHash -= generateHash(INPUT.charAt(i));
            currentHash += generateHash(INPUT.charAt(i + TARGET.length()));
        }
        return -1;
    }

    private boolean checkIsMatchedString(String target, String input, int currIdx) {
        boolean isMatched = true;

        for (int j = 0; j < target.length(); j++) {
            isMatched &= target.charAt(j) == input.charAt(currIdx + j);
        }

        return isMatched;
    }


    private int generateHash(char ch) {
        return ch;
    }

    private int getDefaultHash(String str, int length) {
        int defaultHash = 0;
        for (int i = 0; i < length; i++) {
            defaultHash += generateHash(str.charAt(i));
        }
        return defaultHash;
    }

}
