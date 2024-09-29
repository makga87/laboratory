package bruteforce.step3;

public class NumberArrayMax {
    public static void main(String[] args) {

        int[] data = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
        int[] prefix = new int[data.length+1];

        for(int i = 1; i <= data.length; i++){
            // 누적을 하는 값이, 오히려 더 작아지면, 누적된 값은 무시하고, 현재값을 덮어쓰겠다.!!
            prefix[i] = Math.max(prefix[i-1] + data[i-1], data[i-1]);
        }

        for (int i : prefix) {
            System.out.println(i);
        }
    }
}
