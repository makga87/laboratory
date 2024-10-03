package inflearn.step5;

public class Cook {

    private int N = 4;
    private long result = Integer.MAX_VALUE;
    private int[][] input = {
            {1, 7},
            {2, 6},
            {3, 8},
            {4, 9},
    };

    public static void main(String[] args) {

        Cook cook = new Cook();
        cook.recur(0, 0, 1);

        System.out.println(cook.result);
    }

    public void recur(int idx, int sweet, int salty) {
        if (idx == 4) {
            return;
        }
        result = Math.min(Math.abs(sweet - salty), result);
        recur(idx + 1, sweet + input[idx][0], salty + input[idx][1]);
        recur(idx + 1, sweet, salty);
    }
}
