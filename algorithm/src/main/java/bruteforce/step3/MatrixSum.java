package bruteforce.step3;

public class MatrixSum {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {4, 5, 6, 7}
        };

//        int x1 = 2;
//        int y1 = 2;
//
//        int x2 = 4;
//        int y2 = 3;

        int x1 = 4;
        int y1 = 4;

        int x2 = 4;
        int y2 = 4;

        int[][] sumMatrix = new int[5][5];

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                sumMatrix[x+1][y+1] = sumMatrix[x][y+1] + sumMatrix[x+1][y] - sumMatrix[x][y] + matrix[x][y];
            }
        }

        for (int x = 0; x < sumMatrix.length; x++) {
            for (int y = 0; y < sumMatrix[0].length; y++) {
                System.out.printf(sumMatrix[x][y] + " ");
            }
            System.out.println();
        }

        int result = sumMatrix[x2][y2] - sumMatrix[x2][y1-1] - sumMatrix[x1-1][y2] + sumMatrix[x1-1][y1-1];
        System.out.println(result);
    }
}
