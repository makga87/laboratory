package pseudo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;

class PseudoCASTest {

    private int count;

    @RepeatedTest(5)
    void casTest1() throws InterruptedException {
        PseudoCAS cas = new PseudoCAS(0);
        List<Thread> forWaiting = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    cas.incrementWithCAS();
                }
            });
            forWaiting.add(t);
            t.start();
        }

        // 모든 스레드가 완료될 때까지 기다립니다.
        for (Thread t : forWaiting) {
            t.join();
        }


        System.out.println("Final cas value: " + cas.getValue());
    }


    @RepeatedTest(10)
    void casTest2() {
        PseudoCAS cas = new PseudoCAS(0);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    cas.incrementWithCAS();
                    count++;
                }
            }).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final cas value: " + cas.getValue());
        System.out.println("Final count value: " + count);

        Assertions.assertEquals(cas.getValue(), count);
    }
}