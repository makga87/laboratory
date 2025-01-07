package string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringConstantTest {


	private static String EMOJI_BLUSH = "\uD83D\uDE0A";

//	private static String testStr = "상품이 출시되었습니다.!\n 구매하러 와주세요 \uD83D\uDE0A";

	@Test
	void 상수와_문자열_조합_성능_비교(){

		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000000; i++) {
			String s = "상품이 출시되었습니다.!\n "
			+ "구매하러 와주세요 "+EMOJI_BLUSH;

//			String s = testStr;
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}


	@Test
	void 런타임상수풀_동적할당으로_참조주소가_같음을_확인(){
		String str1 = new String("cat");  // 힙에 새로운 객체 생성
		String str2 = new String("cat");  // 힙에 또 다른 새로운 객체 생성
		System.out.println(str1 == str2);          // false: 다른 객체

		String intern1 = str1.intern();  // 문자열 풀에 "cat" 추가 또는 찾기
		String intern2 = str2.intern();  // 풀에서 동일한 "cat" 찾기
		System.out.println(intern1 == intern2);     // true: 같은 풀의 객체 참조
	}
}