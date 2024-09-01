package pseudo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class PseudoCASTest {

    private int count;

    @RepeatedTest(10)
    void casTest() {
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