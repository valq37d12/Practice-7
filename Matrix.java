import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 5; // Розмір матриці 5x5
        int[][] matrix = new int[size][size];

        // Запитуємо у користувача елементи матриці
        System.out.println("Введіть елементи матриці 5x5 :");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nВаша матриця:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int determinant = calculateDeterminant(matrix);
        System.out.println("\nВизначник матриці: " + determinant);

        scanner.close();
    }

    public static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;

        for (int i = 0; i < n; i++) {
            int[][] minor = getMinor(matrix, 0, i);
            determinant += matrix[0][i] * calculateDeterminant(minor) * (i % 2 == 0 ? 1 : -1);
        }

        return determinant;
    }

    public static int[][] getMinor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];

        int minorRow = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;

            int minorCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;

                minor[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
        }

        return minor;
    }
}
