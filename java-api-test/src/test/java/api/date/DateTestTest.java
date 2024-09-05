package api.date;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Author : hyung-geun Kim
 * Date : 9/5/24
 * ===============================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------
 * 9/5/24        hyung-geun Kim      최초 생성
 */
class DateTestTest {


	@DisplayName("기존 date api들 보다 편의성이 많이 개선됐다.")
	@Test
	void dateApiCompareTest(){

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate1 = sdf.format(date);

		LocalDate today = LocalDate.now();
		String formattedDate2 = today.format(DateTimeFormatter.ISO_LOCAL_DATE);


		// 한 달 후 날짜 계산
		// 기존 방식
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		Date oneMonthLater1 = calendar.getTime();

		// java.time 사용
		LocalDate oneMonthLater2 = today.plusMonths(1);
	}
}