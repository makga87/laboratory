package inflearn.step5;

public class Consultant {

    private long result;
    private int N = 7;
    private int[][] table = {
            {1, 0}, // 문제에는 없지만, N+1을 보고 유추해야한다. 아무런 시간없이 1일을 지내는 값을 넣은것이다.
            {4, 10},
            {1, 20},
            {3, 30},
            {1, 40},
            {2, 35},
            {3, 150},
            {2, 10},
    };

    public static void main(String[] args) {
        Consultant consultant = new Consultant();
        consultant.recur(0, 0);

        System.out.println(consultant.result);
    }

    public void recur(int idx, int price) {
        /*
        일단 현재 인덱스가 N일차 보다 크거나 N일차인 경우엔 이후, 연산을 진행하지 않는다.
        하지만 최대값에 대한 계산은 또 다른 얘기다.
         */
        if (idx >= N) {
            /*
            6일차인 경우, t가 3일이므로, 퇴사일 이상 값이 된다.
            하지만, 이 조건을 걸지 않으면, 연산이 되버리므로,
            이때에는, 연산조차 하지 않도록 한다.
             */
            if(idx > N+1) return;
            result = Math.max(result, price);
            return;
        }
        recur(idx + table[idx][0], price + table[idx][1]);
        recur(idx + 1, price);
    }
}
