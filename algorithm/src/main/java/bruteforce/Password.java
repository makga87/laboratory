package bruteforce;

public class Password {

    public static void main(String[] args) {

        int std = 1000000;
        long input = 15000035500153l;

        boolean result = true;

        for (int i = 2; i <= std; i++) {
            if(input % i == 0) {
                result = false;
                break;
            }
        }

        System.out.println(result);

    }
}
