package map;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

public class ConcurrentMapApiTest {
	private static final int THREAD_COUNT = 10;
	private static final long OPERATION_COUNT = 1_000_000_000;
	private static final ConcurrentHashMap<String, AtomicInteger> computeMap = new ConcurrentHashMap<>();
	private static final ConcurrentHashMap<String, AtomicInteger> checkAndPutMap = new ConcurrentHashMap<>();

	@Test
	public void test() throws InterruptedException {
		// computeIfAbsent 테스트
		long computeStart = System.nanoTime();
		runTest(true);
		long computeEnd = System.nanoTime();

		// containsKey + put 테스트
		long checkStart = System.nanoTime();
		runTest(false);
		long checkEnd = System.nanoTime();

		// 결과 출력
		long computeDuration = (computeEnd - computeStart) / 1_000_000; // ms로 변환
		long checkDuration = (checkEnd - checkStart) / 1_000_000;

		System.out.println("Results for " + THREAD_COUNT + " threads doing " + OPERATION_COUNT + " operations each:");
		System.out.println("computeIfAbsent took: " + computeDuration + "ms");
		System.out.println("containsKey+put took: " + checkDuration + "ms");
		System.out.println("Difference: " + Math.abs(computeDuration - checkDuration) + "ms");

		// 결과 검증
		System.out.println("\nValidation:");
		System.out.println("computeIfAbsent map size: " + computeMap.size());
		System.out.println("containsKey+put map size: " + checkAndPutMap.size());
	}

	@Test
	public void singleTest(){
		singleThreadTest();
	}

	private static void runTest(boolean useCompute) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

		for (int i = 0; i < THREAD_COUNT; i++) {
			executor.submit(() -> {
				for (int j = 0; j < OPERATION_COUNT; j++) {
					String key = "key" + (j % 1000); // 1000개의 키를 재사용

					if (useCompute) {
						// computeIfAbsent 방식
						computeMap.computeIfAbsent(key, k -> new AtomicInteger(0)).incrementAndGet();
					} else {
						// containsKey + put 방식
						if (!checkAndPutMap.containsKey(key)) {
							checkAndPutMap.putIfAbsent(key, new AtomicInteger(0));
						}
						checkAndPutMap.get(key).incrementAndGet();
					}
				}
			});
		}

		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.MINUTES);
	}

	// 추가 테스트: 다양한 시나리오
	public static void singleThreadTest() {
		// 단일 스레드 성능 테스트
		String key = "testKey";
		long start, end;

		// computeIfAbsent 테스트
		start = System.nanoTime();
		for (int i = 0; i < 10000000; i++) {
			computeMap.computeIfAbsent(key, k -> new AtomicInteger(0)).incrementAndGet();
		}
		end = System.nanoTime();
		System.out.println("Single thread computeIfAbsent: " + (end - start) / 1_000_000 + "ms");

		// containsKey + put 테스트
		start = System.nanoTime();
		for (int i = 0; i < 10000000; i++) {
			if (!checkAndPutMap.containsKey(key)) {
				checkAndPutMap.putIfAbsent(key, new AtomicInteger(0));
			}
			checkAndPutMap.get(key).incrementAndGet();
		}
		end = System.nanoTime();
		System.out.println("Single thread containsKey+put: " + (end - start) / 1_000_000 + "ms");
	}
}
