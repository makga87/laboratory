package inflearn.step3;

public class NumberArray {

    public static void main(String[] args) {
        int A = 10;
        int B = 2;
        int[] input = {3, -2, -4, -9, 0, 3, 7, 13, 8, -3};

        int[] prefix = new int[A+1];
        prefix[0] = 0;

        for(int i = 1; i <= A; i++) {
            prefix[i] = prefix[i-1] + input[i-1];
        }

        int max = Integer.MIN_VALUE;

        for(int j = B; j < prefix.length; j++){
            max = Math.max(max, prefix[j] - prefix[j-B]);
        }

        System.out.println(max);
    }
}
