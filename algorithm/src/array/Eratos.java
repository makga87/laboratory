package array;

import java.util.Scanner;
import java.util.Stack;

public class Eratos {

    public int solution(int n) {

        int answer = 0;

        int[] ch = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + 1) {
                    ch[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Eratos t = new Eratos();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(t.solution(n));
    }
}
