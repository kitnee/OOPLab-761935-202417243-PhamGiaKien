import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Invalid number of elements.");
            sc.close();
            return;
        }
        
        double[] arr = new double[n];
        System.out.println("Enter " + n + " elements:");
        
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextDouble();
        }
        Arrays.sort(arr);
        double sum = 0;
        for (double x : arr) sum += x;
        double avg = sum / arr.length;

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f\n", avg);
        
        sc.close();
    }
}