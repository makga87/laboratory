package stringMatch;

/**
 * ASC II 값만으로 구해보는 라빈 카프 문자열 검색
 */
public class RabinKarpSubStringSearchStep4 {

    public static void main(String[] args) {

        RabinKarpSubStringSearchStep4 rabinKarp = new RabinKarpSubStringSearchStep4();
        String input = "cctaacabfswacacat";
        System.out.println(input.length());
        String keyword = "cat";

        int result = rabinKarp.searchMatchingStringIndex(input, keyword);
    }

    public int searchMatchingStringIndex(String input, String keyword) {

        int keywordHashCode = getHashCode(keyword);
        int inputSubStrHashCode = getHashCode(input.substring(0, keyword.length()));
        int searchIndex = -1;

        if (keywordHashCode == inputSubStrHashCode) {
            return 0;
        }

        for (int i = keyword.length(); i < input.length(); i++) {
            /**
             * 주의 : 빠진 문자의 인덱스를 반환하지 않도록 해야한다. 반드시 빠진 문자 + 1번째 인덱스가 동일한 문자열 시작 인덱스다!
             */
            inputSubStrHashCode -= getCharHash(input.charAt(i - keyword.length()), keyword.length() - 1);
            inputSubStrHashCode *= 2;
            inputSubStrHashCode += getCharHash(input.charAt(i), 0);

            if (keywordHashCode == inputSubStrHashCode) {
                System.out.printf("%d번째, %s문자열시작", i - keyword.length() + 1, input.charAt(i - keyword.length() + 1));
                searchIndex = i - keyword.length();
                break;
            }

        }

        return searchIndex;
    }

    private int getHashCode(String target) {

        int hashCode = 0;

        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            hashCode += getCharHash(ch, target.length() - 1 - i);
        }

        return hashCode;
    }

    private int getCharHash(char ch, int index) {
        return (int) (ch * Math.pow(2, index));
    }
}
