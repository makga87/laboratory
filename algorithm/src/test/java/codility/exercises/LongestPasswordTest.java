package codility.exercises;

import org.junit.jupiter.api.Test;


/**
 * 문자열이 1개 이상 필요하다는 말은 어디에도 없다. -> 숫자 1개만 있어도 옳은 값이다라는 문장가지고 문자열이 0개여도 된다는것을 추론시킴
 * isAlphabetic 메서드는 한글도 true로 반환한다는 함정이 있다.
 * 특수문자는 문제를 올바르지 않은 문자다
 * 이런 여러가지 것으로 유추 및 함정을 피해야한다.
 */

class LongestPasswordTest {

	private int maxLength = -1;

	@Test
	public void test() {
		String s = "test 5 a0A pass007 ?xy1";
		String[] splitted = s.split(" ");

		for (int i = 0; i < splitted.length; i++) {

			if (isValid(splitted[i])) {
				maxLength = Math.max(maxLength, splitted[i].length());
			}
		}

		System.out.println(maxLength);
	}


	public boolean isValid(String splitted) {

		int letterCnt = 0;
		int digitCnt = 0;

		for(char c : splitted.toCharArray()) {
			if (!Character.isLetterOrDigit(c)) {
				return false;
			}

			if(isEnglishLetter(c)) {
				letterCnt++;
			}

			if(Character.isDigit(c)){
				digitCnt++;
			}
		}

		return letterCnt % 2 == 0 && digitCnt % 2 != 0 && digitCnt > 0;

	}
	private boolean isEnglishLetter(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}


	/**
	 * isAlphabetic은 쓰지 말자
	 */
	@Test
	void isAlphabetic(){

		System.out.println(Character.isAlphabetic('가'));
	}
}