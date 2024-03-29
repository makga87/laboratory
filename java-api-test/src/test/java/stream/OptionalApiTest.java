package stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class OptionalApiTest {

	@Test
	void Optional_NULL_값_체크() {
		Employee employee = null;
		assertThrows(NullPointerException.class, () -> {
			Optional.of(employee);
		});

		Optional<Employee> employee1 = Optional.ofNullable(employee);
		assertFalse(employee1.isPresent());
	}

	@Test
	void Optional_값변환() {
		Employee employee = new Employee("개발팀", "김갑돌", 50);
		String name1 = Optional.ofNullable(employee)
							   .map(Employee::getName)
							   .orElse("없음");

		System.out.println(name1);

		String name2 = Optional.ofNullable(employee)
							   .map(Employee::getName)
							   .filter(name -> name.equals("김순돌"))
							   .orElse("없음");

		System.out.println(name2);

	}

	@Test
	void Optional_맵_응용() {
		Map<Integer, String> empName = new HashMap<>();
		empName.put(1, "김갑룡");
		empName.put(2, "김을룡");
		empName.put(3, "김병룡");

		int nameLength = Optional.ofNullable(empName.get(2))
								 .map(String::length)
								 .orElse(0);

		System.out.println(nameLength);
	}

	@Test
	void Optinal_리스트_NULL_SAFETY하게_적용해보기() {
		List<String> nameArr = Arrays.asList("A", "B", "C");

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			System.out.println("Optional.ofNullable을 사용해도, ArrayIndexOutOfBounds예외는 발생한다.");
			Optional.ofNullable(nameArr.get(3));
		});

		Optional<String> nameResult = getAsOptional(nameArr, 3);
		String result = nameResult.orElseGet(() -> "Not exist name");
		System.out.println(result);
	}

	public static <T> Optional<T> getAsOptional(List<T> list, int index) {
		try {
			return Optional.of(list.get(index));
		} catch (ArrayIndexOutOfBoundsException e) {
			return Optional.empty();
		}
	}

	@Test
	void orElse_orElseGet차이_Null() {

		Employee employee = null;
		Employee _employee = null;
		/**
		 * orElse 는 Optional.of 의 값이 Null 여부 관계 없이 일단 호출하고, null 인 경우 반환한다. (선 준비)
		 */
		Employee result = Optional.ofNullable(employee).orElse(_employee);

		/**
		 * orElseGet은 Optional.of 의 값이 Null인 경우에만 호출 한다. (후 준비)
		 */
		Employee _result = Optional.ofNullable(employee).orElseGet(() -> _employee);

	}

	@Test
	void Null인경우_map은_정상동작() {
		Employee employee = null;
		Optional.ofNullable(employee)
				.map(emp -> {
					System.out.println("emp=" + emp);
					return emp;
				});

	}

	@Test
	void Null인경우_orElseThrow은_정상동작() throws Exception {
		Employee employee = null;
		Optional.ofNullable(employee)
				.map(emp -> {
					System.out.println("emp=" + emp.getName());
					return emp;
				})
				.orElseThrow(() -> {
					return new Exception("employee is null");
				});

	}

	@Test
	void Null인경우_orElseThrow은_정상동작2() throws Exception {
		Employee employee = new Employee();
		Optional.ofNullable(employee)
				.map(emp -> {
					System.out.println("emp=" + emp.getName());
					return emp;
				})
				.orElseThrow(() -> {
					return new Exception("employee is null");
				});

	}

	/**
	 * findFirst, findAny의 경우, filter 후, 존재하지 않는 데이터를 get으로 바로 호출 시, 에러를 반환한다.
	 */
	@Test
	void findAny_findFirst의_값이null인경우_에러없이_받는방법_테스트() {
		List<String> nameArr = Arrays.asList("A", "B", "C");
		String result = nameArr.stream()
							   .filter(name -> name.equals("D"))
							   .findFirst()
									   .orElseGet(()-> null);
//							   .get();

		/**
		 * 아래는 정상동작
		 */
		//							   .orElseGet(()->"D");
		//							   .orElse("D");
		//							   .orElse(null);

		/**
		 * 아래는 에러
		 */
		//							   .orElseGet(null); --> orElseGet은 supplier.get으로 호출하므로, ()->null로 입력해야 정상동작


		System.out.println(result);
	}
}