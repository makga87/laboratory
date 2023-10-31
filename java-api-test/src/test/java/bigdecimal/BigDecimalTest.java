package bigdecimal;

import java.math.BigDecimal;

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
	void NULL값이_들어가는_경우() {
//		System.out.println(BigDecimal.valueOf("abc"));
		System.out.println(new BigDecimal(""));
	}
}
