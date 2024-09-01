package pseudo;

/**
 * Compare And Swap을 이해하기 위한 의사코드
 * Atomic한 +1 증가 로직을 구현한다.
 */
public class PseudoCAS {
    private int value;

    public PseudoCAS(int value) {
        this.value = value;
    }

    /**
     * 현재 실제 객체 값, 내가 예상한 현재 객체의 값을 비교하고, 교체하는 것이 핵심
     *
     * @param expectedValue 내가 예상한 현재 객체의 값
     * @param newValue      새로운 값
     * @return
     */
    public synchronized boolean compareAndSwap(int expectedValue, int newValue) {
        if (value == expectedValue) {
            value = newValue;
            return true;
        }
        return false;
    }

    /**
     * 현재 값을, oldValue(expectedValue)로 할당해서 예상값을 갱신한다.
     * oldValue(곧 예상값)에 +1 을 해서, newValue로 맞춘다.
     */
    public void incrementWithCAS() {
        int oldValue, newValue;
        do {
            oldValue = value;
            newValue = oldValue + 1;
        } while (!compareAndSwap(oldValue, newValue));
    }

    public int getValue() {
        return value;
    }

}

