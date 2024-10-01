package bruteforce.step3;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class ImosLaw {
    public static void main(String[] args) {
        ImosLaw imosLaw = new ImosLaw();
        imosLaw.imosRefactor();

    }

    /**
     * 강사의 소스는 입력된 값을 전부 펼치는 것이 아니라, 입력된 값을 기준으로 연산하여 저장될 공간만을
     * 사용한다.
     */
    private void imosRefactor(){
        int width = 6;
        int height = 7;
        int[] input = {1, 5, 3, 3, 5, 1};

        int[] temp = new int[height];

        for(int i = 0; i < width; i++){
            if (i % 2 == 0) {
                temp[0] += 1;
                temp[input[i]] += -1;
            } else {
                temp[height - input[i]] = 1;
            }
        }

        int[] prefix = new int[height + 1];
        for (int i = 1; i <= temp.length; i++) {
            prefix[i] = prefix[i - 1] + temp[i - 1];
        }

//        int minValue = IntStream.range(1, prefix.length-1).min().getAsInt();
        int minValue = Integer.MAX_VALUE;
        int minCount = 0;


        for (int i = 1; i < prefix.length; i++) {
            if (prefix[i] < minValue) {
                minValue = prefix[i];
                minCount = 1;
            } else if (prefix[i] == minValue) {
                minCount++;
            }
        }
        System.out.println(minValue);
        System.out.println(minCount);
    }

    /**
     * 내가 작성한 것은 입력한 값을 일단 2차원 배열에 펼쳐 둔다음부터 시작한다.
     */
    public void imosMine(){
        //  int width = 6;
        int width = 14;
//        int height = 7;
        int height = 5;

        int[] input = {1,
                3,
                4,
                2,
                2,
                4,
                3,
                4,
                3,
                3,
                3,
                2,
                3,
                3};
//        int[] input = {1, 5, 3, 3, 5, 1};

        int[][] matrix = new int[height][width];

        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                matrix[height - 1][i] = 1;
                matrix[height - input[i] - 1][i] = -1;
            } else {
                matrix[input[i] - 1][i] = 1;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf(matrix[i][j] + "  ");
            }
            System.out.println();
        }

        int[] prefix = new int[height + 1];
        for (int i = matrix.length - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
            prefix[height - i] = prefix[height - 1 - i] + sum;
        }

        int minValue = Integer.MAX_VALUE;
        int minCount = 0;
        for (int i = 1; i < prefix.length; i++) {
            if (prefix[i] < minValue) {
                minValue = prefix[i];
                minCount = 1;
            } else if (prefix[i] == minValue) {
                minCount++;
            }
        }
        System.out.println(minValue);
        System.out.println(minCount);
    }


}
