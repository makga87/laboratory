package bruteforce;

public class Candy {
    public static void main(String[] args) {

        int result = 0;

        for (int a = 0; a <= 6; a++) {
            for (int b = 0; b <= 6; b++) {
                for (int c = 0; c <= 6; c++) {
                    if(a+b+c == 6) {
                        if(a >= b+2) {
                            if(a != 0 && b != 0 && c != 0){
                                if(c % 2 == 0) {
                                    result++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);

    }
}
