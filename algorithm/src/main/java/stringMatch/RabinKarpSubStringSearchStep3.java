package stringMatch;

/**
 * ASC II 값만으로 구해보는 라빈 카프 문자열 검색
 */
public class RabinKarpSubStringSearchStep3 {

    public static void main(String[] args) {

        RabinKarpSubStringSearchStep3 rabinKarp = new RabinKarpSubStringSearchStep3();
        String INPUT = "ctcaacabfswacacat";

        String keyword = "cat";

        rabinKarp.searchMatchingStringIndex(INPUT, keyword);
    }

    public int searchMatchingStringIndex(String INPUT, String TARGET) {
        return -1;
    }


}
