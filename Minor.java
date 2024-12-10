import java.util.Random;
import java.util.Scanner;

public class Minor {

    public static int determinant(int[][] matrix, int n) {
        if (n == 1) {
            return matrix[0][0];
        }
        int det = 0;
        int sign = 1;
        for (int f = 0; f < n; f++) {
            int[][] temp = new int[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                int colIndex = 0;
                for (int j = 0; j < n; j++) {
                    if (j != f) {
                        temp[i - 1][colIndex++] = matrix[i][j];
                    }
                }
            }
            det += sign * matrix[0][f] * determinant(temp, n - 1);
            sign = -sign;
        }
        return det;
    }

    public static int[][] generateRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рядків матриці: ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців матриці: ");
        int cols = scanner.nextInt();

        int[][] matrix = generateRandomMatrix(rows, cols);

        System.out.println("Згенерована матриця:");
        printMatrix(matrix);

        if (rows == cols) {
            System.out.print("Введіть рядок для мінору (0-" + (rows - 1) + "): ");
            int rowIndex = scanner.nextInt();
            System.out.print("Введіть стовпець для мінору (0-" + (cols - 1) + "): ");
            int colIndex = scanner.nextInt();

            int[][] minorMatrix = new int[rows - 1][cols - 1];
            int minorRow = 0;
            for (int i = 0; i < rows; i++) {
                if (i == rowIndex) continue;
                int minorCol = 0;
                for (int j = 0; j < cols; j++) {
                    if (j == colIndex) continue;
                    minorMatrix[minorRow][minorCol++] = matrix[i][j];
                }
                minorRow++;
            }

            int minorDeterminant = determinant(minorMatrix, rows - 1);
            System.out.println("Мінор матриці для елементу (" + rowIndex + ", " + colIndex + "): " + minorDeterminant);
        } else {
            System.out.println("Мінор можна обчислити лише для квадратних матриць.");
        }

        scanner.close();
    }
}
