package inflearn.step5;

public class Napsack {

    private int N = 4;
    private int B = 7;
    private long result;

    int[][] wv = {
            {6, 13},
            {4, 8},
            {3, 6},
            {5, 12}
    };
    public static void main(String[] args) {
        Napsack napsack = new Napsack();
        napsack.recur(0, 0, 0);
        System.out.println(napsack.result);
    }

    public void recur(int idx, int w, int v){
        if(w > B){
            return;
        }
        if(idx == N) {
            result = Math.max(result, v);
            return;
        }

        recur(idx + 1, w + wv[idx][0], v + wv[idx][1]);
        recur(idx + 1, w, v);
    }
}
