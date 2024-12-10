import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рівнів піраміди: ");
        int n = scanner.nextInt();

        int[][] pyramid = new int[n][];

        for (int i = 0; i < n; i++) {
            pyramid[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                pyramid[i][j] = i + j + 1;
            }
        }

        System.out.println("Звичайний порядок:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < pyramid[i].length; j++) {
                System.out.print(pyramid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Зворотний порядок:");
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < pyramid[i].length; j++) {
                System.out.print(pyramid[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
