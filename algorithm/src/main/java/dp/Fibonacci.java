package dp;

public class Fibonacci {

    private long[] numArr = new long[100];

    /**
     * F(n+2) = F(n+1) + F(n)
     * F(n) = F(n-1) + F(n-2)
     */
    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();

        long start = System.currentTimeMillis();
        long result = fibonacci.fun2(50);
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println(end - start);

    }

    /**
     * before memoization
     *
     */
    public long fun(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fun(num - 1) + fun(num - 2);
    }

    /**
     * memoization
     *
     */
    public long fun2(int num) {

        if (numArr[num] != 0) return numArr[num];

        if (num < 1) {
            return 0;
        }
        if (num <= 2) {
            return 1;
        }
        return numArr[num] = fun2(num - 1) + fun2(num - 2);
    }

}
