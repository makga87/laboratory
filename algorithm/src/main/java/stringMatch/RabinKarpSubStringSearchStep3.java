package stringMatch;

/**
 * ASC II 값만으로 구해보는 라빈 카프 문자열 검색
 */
public class RabinKarpSubStringSearchStep3 {

    public static void main(String[] args) {

        RabinKarpSubStringSearchStep3 rabinKarp = new RabinKarpSubStringSearchStep3();
        String input = "ctcaacabfswacacat";
        String keyword = "cat";

        int result = rabinKarp.searchMatchingStringIndex(input, keyword);
        System.out.println(result);
    }

    public int searchMatchingStringIndex(String input, String keyword) {

        int keywordHashCode = getHashCode(keyword);
        int inputSubStrHashCode = getHashCode(input.substring(0, keyword.length()));
        int searchIndex = -1;

        if (keywordHashCode == inputSubStrHashCode) return 0;

        for (int i = keyword.length(); i < input.length(); i++) {

            inputSubStrHashCode -= getCharHash(input.charAt(i - keyword.length()), keyword.length() - 1);
            inputSubStrHashCode = inputSubStrHashCode * 2;
            inputSubStrHashCode += getCharHash(input.charAt(i), 0);

            if(keywordHashCode == inputSubStrHashCode) {
                searchIndex = i - keyword.length();
            }
        }

        return searchIndex;
    }

    private int getHashCode(String target) {

        int hashCode = 0;

        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            hashCode += getCharHash(ch, target.length() - 1);
        }

        return hashCode;
    }

    private int getCharHash(char ch, int index) {
        return (int) (ch * Math.pow(2, index));
    }
}
