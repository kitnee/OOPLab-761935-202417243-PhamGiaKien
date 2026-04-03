import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: "); int r = sc.nextInt();
        System.out.print("Enter cols: "); int c = sc.nextInt();

        int[][] m1 = new int[r][c];
        int[][] m2 = new int[r][c];
        int[][] res = new int[r][c];

        System.out.println("Enter Matrix 1:");
        for(int i=0; i<r; i++) for(int j=0; j<c; j++) m1[i][j] = sc.nextInt();

        System.out.println("Enter Matrix 2:");
        for(int i=0; i<r; i++) for(int j=0; j<c; j++) m2[i][j] = sc.nextInt();

        System.out.println("Resulting Matrix:");
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                res[i][j] = m1[i][j] + m2[i][j];
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}