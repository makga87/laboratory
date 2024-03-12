package exception;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class ExceptionTest {

	/**
	 * Release의 모든것이라는 책에서 나온 케이스로
	 * 일반적인 DB Connection 획득과 Statement 실행 시, close 중, 예외가 발생하여, 닫히지 않은 statement들로 인해
	 * 서버가 다운된 이슈가 있었음.
	 * 해당 이슈에 대한 로직이 다음과 같은 구조로 되어 있었다.
	 */
	@Test
	void testTryCatch() {

		CloseMock closeMock = null;

		try {
			try {
				closeMock = new CloseMock();
			} finally {
				if (closeMock != null) {
					closeMock.close();
				}
			}
		} catch (Exception e) {
			System.out.println("Not catched Exception;");
		}

	}

	public class CloseMock {

		public void close() throws SQLException {

			throw new SQLException("Exception occur;");
			//			System.out.println("Close success");
		}
	}
}
