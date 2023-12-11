package bigdecimal;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigDecimalTest {

	@Test
	void 일반테스트() {

		double value1 = 12.23;
		double value2 = 34.45;

		// 46.68
		System.out.println(value1 + value2);

		BigDecimal bigDecimal =  BigDecimal.valueOf(12.23);
		BigDecimal afterAdded = bigDecimal.add(BigDecimal.valueOf(34.45));
		System.out.println(afterAdded);
	}

	@Test
	void 문자열_값이_들어가는_경우_NumberFormatException을_발생시킨다() {
		System.out.println(new BigDecimal("abc"));
	}

	@Test
	void 빈문자열_값이_들어가는_경우_NumberFormatException을_발생시킨다() {
		System.out.println(new BigDecimal(""));
	}

	/**
	 * null은 입력값 불가
	 */
	@Test
	void Null_값이_들어가는_경우_NumberFormatException을_발생시킨다() {
//		System.out.println(new BigDecimal(null));
	}

	@Test
	void 비교(){
		BigDecimal a = new BigDecimal("1.011");
		BigDecimal b = new BigDecimal("1.0110");

		// 주소 비교니 당연히 false
		Assertions.assertFalse(a == b);

		// 소숫점 끝자리까지 전부 동일해야하므로 false
		Assertions.assertFalse(a.equals(b));

		// 값의 비교시엔, 끝자리 0은 무시됨
		Assertions.assertTrue(a.compareTo(b) == 0);
	}
}
