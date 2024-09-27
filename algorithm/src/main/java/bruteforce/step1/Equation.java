package bruteforce.step1;

public class Equation {

    public static void main(String[] args) {

        int a = 1;
        int b = 3;
        int c = -1;
        int d = 4;
        int e = 1;
        int f = 7;

        for (int x = -10000; x <= 10000; x++) {
            for (int y = -10000; y <= 10000; y++) {
                if ((a * x) + (b * y) == c) {
                    if ((d * x) + (e * y) == f) {
                        System.out.println(x);
                        System.out.println(y);
                    }
                }
            }
        }

    }
}
