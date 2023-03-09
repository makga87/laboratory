package string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringConstantTest {


	private static String EMOJI_BLUSH = "\uD83D\uDE0A";

//	private static String testStr = "관람일이 바로 내일이에요!\n 빠르고 간편하게 입장할 수 있도록 지금 얼굴 입장을 설정해 주세요 \uD83D\uDE0A";
	@Test
	void 상수와_문자열_조합_성능_비교(){

		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000000; i++) {
			String s = "관람일이 바로 내일이에요!\n"
			+ "빠르고 간편하게 입장할 수 있도록 지금 얼굴 입장을 설정해 주세요"+EMOJI_BLUSH;

//			String s = testStr;
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}