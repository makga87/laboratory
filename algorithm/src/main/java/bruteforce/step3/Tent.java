package bruteforce.step3;

import java.util.Arrays;

public class Tent {

    public static void main(String[] args) {
        int[][] input = {
                {2, 4},
                {11, 4},
                {15, 8},
                {4, 6},
                {5, 3},
                {8, 10},
                {13, 6}
        };

        Arrays.sort(input, (o1, o2) -> o1[0] - o2[0]);

        int maxY = 0;
        int maxYPos = 0;

        for (int i = 0; i < input.length; i++) {
            if (maxY < input[i][1]) {
                maxY = input[i][1];
                maxYPos = input[i][0];
            }
        }

        int tot = 0;

        int beforeMax = 0;
        int beforeMaxPos = 0;

        for (int j = 0; j < input.length; j++) {
            if (beforeMax <= input[j][1]) {
                tot += (input[j][0] - beforeMaxPos) * beforeMax;
                beforeMax = input[j][1];
                beforeMaxPos = input[j][0];
                if (input[j][0] == maxYPos) {
                    break;
                }
            }
        }
        System.out.println(tot);

        beforeMax = input[input.length - 1][1];
        beforeMaxPos = input[input.length - 1][0];

        for (int k = input.length - 1; k >= 0; k--) {
            if (beforeMax <= input[k][1]) {
                tot += (beforeMaxPos - input[k][0]) * beforeMax;
                beforeMax = input[k][1];
                beforeMaxPos = input[k][0];
                if (input[k][0] == maxYPos) {
                    break;
                }
            }
        }

        tot += maxY;
    }
}
