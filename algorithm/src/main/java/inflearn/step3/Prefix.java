package inflearn.step3;

public class Prefix {

    public static void main(String[] args) {
        int N = 10;
        int[] data = new int[N];
        int[] sum = new int[N+1];

        for(int i = 1; i <= 10; i++){
            data[i-1] = i;
            sum[i] = data[i-1];
            sum[i] = sum[i-1] + sum[i];
        }

        sum[0] = data[0];

        for(int i = 1; i < 10; i++){
            sum[i] = sum[i-1] + data[i];
        }

        for (int i : sum) {
            System.out.println(i);
        }
    }
}
