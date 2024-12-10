import java.util.Scanner;
import java.util.Random;

public class Transpose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмірність матриці (n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        System.out.println("Оригінальна матриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(100);
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int[][] transposedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        System.out.println("Транспонована матриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(transposedMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
