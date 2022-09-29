package thread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadTest {

    /**
     * ExecutorService 사용 시, 메인 스레드가 기다려주지 않기에 CountDownLatch 로 제어
     */
    @DisplayName("멀티 스레드 테스트 방법")
    @Test
    public void completableFutureTest() throws InterruptedException {

        int count = 1000000;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < count; i++) {
            executorService.execute(new TestRunner(i, countDownLatch));
        }
        countDownLatch.await();
    }

    public class TestRunner implements Runnable {

        private int no;
        private CountDownLatch countDownLatch;

        public TestRunner(int no, CountDownLatch countDownLatch) {
            this.no = no;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println(no);
            countDownLatch.countDown();
        }
    }
}
