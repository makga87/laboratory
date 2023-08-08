package cocurrent;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class VolatileTest {

	private static volatile boolean stopRequested;
//	private static boolean stopRequested;

	public void noVolatileTest() throws InterruptedException {

		Thread backgroundThread = new Thread(() -> {
			int i = 0;
			while (!stopRequested) {
				i++;
//				System.out.println("Current i : " +i);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		});
		backgroundThread.start();

		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
		System.out.println("System finish");
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileTest volatileTest = new VolatileTest();

		volatileTest.noVolatileTest();
	}
}
