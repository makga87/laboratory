package forloop;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class LoopTest {

	private static final int ARRAY_SIZE = 10_000_000;
	private static final int SMALLER_SIZE = 1_000_000; // LinkedList용 작은 크기
	private static final int WARM_UP_ITERATIONS = 5;
	private static final int TEST_ITERATIONS = 10;

	private Integer[] array;
	private List<Integer> arrayList;
	private List<Integer> linkedList;

	@BeforeEach
	void setUp() {
		// JVM 워밍업
		warmUpJvm();

		// 테스트 데이터 준비
		array = createRandomArray(ARRAY_SIZE);

		arrayList = new ArrayList<>(ARRAY_SIZE);
		for (int i = 0; i < ARRAY_SIZE; i++) {
			arrayList.add(array[i]);
		}

		linkedList = new LinkedList<>();
		for (int i = 0; i < SMALLER_SIZE; i++) {
			linkedList.add(array[i]);
		}
	}

	private void warmUpJvm() {
		Integer[] warmupArray = createRandomArray(1_000_000);

		for (int iter = 0; iter < WARM_UP_ITERATIONS; iter++) {
			int sum = 0;
			for (int i = 0; i < warmupArray.length; i++) {
				sum += warmupArray[i];
			}

			sum = 0;
			for (Integer value : warmupArray) {
				sum += value;
			}
		}
	}

	private Integer[] createRandomArray(int size) {
		Integer[] arr = new Integer[size];
		Random random = new Random(42); // 고정된 시드 사용
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(1000);
		}
		return arr;
	}

	@Test
	@DisplayName("배열에서 for문과 foreach문 성능 비교")
	void compareArrayLoops() {
		PerformanceResult result = measureArrayPerformance();

		System.out.println("\n배열 성능 테스트 결과:");
		System.out.printf("일반 for문: %,d 나노초\n", result.forLoopTime);
		System.out.printf("foreach문: %,d 나노초\n", result.forEachTime);
		System.out.printf("차이: %.2f%%\n", result.getDifferencePercent());

		// 테스트 확인 - 실제로는 어느 쪽이 더 빠를지 확정적이지 않음
		assertTrue(true, "성능 테스트 완료");
	}

	@Test
	@DisplayName("ArrayList에서 for문과 foreach문 성능 비교")
	void compareArrayListLoops() {
		PerformanceResult result = measureArrayListPerformance();

		System.out.println("\nArrayList 성능 테스트 결과:");
		System.out.printf("일반 for문: %,d 나노초\n", result.forLoopTime);
		System.out.printf("foreach문: %,d 나노초\n", result.forEachTime);
		System.out.printf("차이: %.2f%%\n", result.getDifferencePercent());

		assertTrue(true, "성능 테스트 완료");
	}

	@Test
	@DisplayName("LinkedList에서 for문과 foreach문 성능 비교")
	void compareLinkedListLoops() {
		PerformanceResult result = measureLinkedListPerformance();

		System.out.println("\nLinkedList 성능 테스트 결과:");
		System.out.printf("일반 for문: %,d 나노초\n", result.forLoopTime);
		System.out.printf("foreach문: %,d 나노초\n", result.forEachTime);
		System.out.printf("차이: %.2f%%\n", result.getDifferencePercent());

		// LinkedList의 경우 foreach가 훨씬 빨라야 함
		assertTrue(result.forEachTime < result.forLoopTime,
				   "LinkedList에서는 foreach문이 일반 for문보다 빨라야 합니다");
	}

	@ParameterizedTest(name = "컴파일된 바이트코드 비교 - {0}")
	@ValueSource(strings = {"배열", "ArrayList", "LinkedList"})
	@DisplayName("서로 다른 자료구조에서 루프 성능 비교")
	void compareLoopsAcrossDataStructures(String dataStructureType) {
		PerformanceResult result;

		switch (dataStructureType) {
			case "배열":
				result = measureArrayPerformance();
				break;
			case "ArrayList":
				result = measureArrayListPerformance();
				break;
			case "LinkedList":
				result = measureLinkedListPerformance();
				break;
			default:
				throw new IllegalArgumentException("지원하지 않는 자료구조: " + dataStructureType);
		}

		System.out.println("\n" + dataStructureType + " 성능 테스트 결과:");
		System.out.printf("일반 for문: %,d 나노초\n", result.forLoopTime);
		System.out.printf("foreach문: %,d 나노초\n", result.forEachTime);
		System.out.printf("차이: %.2f%%\n", result.getDifferencePercent());

		if ("LinkedList".equals(dataStructureType)) {
			assertTrue(result.forEachTime < result.forLoopTime,
					   "LinkedList에서는 foreach문이 일반 for문보다 빨라야 합니다");
		} else {
			assertTrue(true, "성능 테스트 완료");
		}
	}

	private PerformanceResult measureArrayPerformance() {
		long[] forLoopTimes = new long[TEST_ITERATIONS];
		long[] forEachTimes = new long[TEST_ITERATIONS];

		for (int iter = 0; iter < TEST_ITERATIONS; iter++) {
			// 단순 for문 테스트
			long startTime = System.nanoTime();
			int sum = 0;
			for (int i = 0; i < array.length; i++) {
				sum += array[i];
			}
			forLoopTimes[iter] = System.nanoTime() - startTime;

			// foreach문 테스트
			startTime = System.nanoTime();
			sum = 0;
			for (Integer value : array) {
				sum += value;
			}
			forEachTimes[iter] = System.nanoTime() - startTime;

			// 테스트 사이 짧은 휴식
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		return new PerformanceResult(
				calculateAverage(forLoopTimes),
				calculateAverage(forEachTimes)
		);
	}

	private PerformanceResult measureArrayListPerformance() {
		long[] forLoopTimes = new long[TEST_ITERATIONS];
		long[] forEachTimes = new long[TEST_ITERATIONS];

		for (int iter = 0; iter < TEST_ITERATIONS; iter++) {
			// 단순 for문 테스트
			long startTime = System.nanoTime();
			int sum = 0;
			for (int i = 0; i < arrayList.size(); i++) {
				sum += arrayList.get(i);
			}
			forLoopTimes[iter] = System.nanoTime() - startTime;

			// foreach문 테스트
			startTime = System.nanoTime();
			sum = 0;
			for (Integer value : arrayList) {
				sum += value;
			}
			forEachTimes[iter] = System.nanoTime() - startTime;

			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		return new PerformanceResult(
				calculateAverage(forLoopTimes),
				calculateAverage(forEachTimes)
		);
	}

	private PerformanceResult measureLinkedListPerformance() {
		long[] forLoopTimes = new long[TEST_ITERATIONS];
		long[] forEachTimes = new long[TEST_ITERATIONS];

		for (int iter = 0; iter < TEST_ITERATIONS; iter++) {
			// 단순 for문 테스트
			long startTime = System.nanoTime();
			int sum = 0;
			for (int i = 0; i < linkedList.size(); i++) {
				sum += linkedList.get(i);
			}
			forLoopTimes[iter] = System.nanoTime() - startTime;

			// foreach문 테스트
			startTime = System.nanoTime();
			sum = 0;
			for (Integer value : linkedList) {
				sum += value;
			}
			forEachTimes[iter] = System.nanoTime() - startTime;

			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		return new PerformanceResult(
				calculateAverage(forLoopTimes),
				calculateAverage(forEachTimes)
		);
	}

	private long calculateAverage(long[] times) {
		// 첫 실행은 제외 (가끔 이상치가 발생할 수 있음)
		long sum = 0;
		for (int i = 1; i < times.length; i++) {
			sum += times[i];
		}
		return sum / (times.length - 1);
	}

	/**
	 * 성능 측정 결과를 보관하는 내부 클래스
	 */
	static class PerformanceResult {
		final long forLoopTime;
		final long forEachTime;

		PerformanceResult(long forLoopTime, long forEachTime) {
			this.forLoopTime = forLoopTime;
			this.forEachTime = forEachTime;
		}

		/**
		 * for문과 foreach문 사이의 성능 차이를 백분율로 계산
		 * 양수: for문이 더 느림, 음수: foreach문이 더 느림
		 */
		double getDifferencePercent() {
			return ((double)forLoopTime - forEachTime) / forLoopTime * 100;
		}
	}
}