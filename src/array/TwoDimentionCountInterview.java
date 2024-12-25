package array;

public class TwoDimentionCountInterview {
    public static void main(String[] args) {
        int[] x = {0, 1};
        int[] y = {0, 1};
        int count = 0;
        int[][] arr = new int[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = count;
                count++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Calculation");
        int finalCount = 0;
        for (int i = 0; i <= x.length; i++) {
            for (int j = 0; j <= y.length; j++) {
                if ((i <= x[1] && j <= y[1])) {
                    finalCount += arr[i][j];
                }
            }
        }
        System.out.println("finalCount :" + finalCount);
    }
}
