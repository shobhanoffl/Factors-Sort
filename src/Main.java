import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] elements = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            elements[i] = scanner.nextInt();
        }

        sortArrayByFactorCount(elements);

        System.out.println("Sorted array based on the number of distinct factors:");
        System.out.println(Arrays.toString(elements));
    }

    static int countDistinctFactors(int number) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }

    static void sortArrayByFactorCount(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (countDistinctFactors(arr[j]) > countDistinctFactors(arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
