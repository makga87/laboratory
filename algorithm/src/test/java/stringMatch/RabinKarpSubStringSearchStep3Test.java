package stringMatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RabinKarpSubStringSearchStep3Test {

    @Test
    void powerTest(){
        String input = "cat";
        int hashcode = 0;
        int _hashcode = 0;


        for (int i = 0 ; i < input.length(); i++) {
            hashcode += getCharHash(input.charAt(i), input.length() -1 - i);
        }

        for (int i = 0 ; i < input.length(); i++) {
            _hashcode += getCharHash(input.charAt(i), input.length() - i);
        }

        hashcode *= 2;
        System.out.println(hashcode);

        assertEquals(hashcode, _hashcode);

    }


    private int getCharHash(char ch, int index) {
        return (int) (ch * Math.pow(2, index));
    }

    private int getHashCode(String target){
        int hashCode = 0;

        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            hashCode += getCharHash(ch, target.length() - 1 - i);
        }

        return hashCode;}
}