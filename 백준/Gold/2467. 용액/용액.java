import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        int sum = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (start < end) {
            int temp = arr[start] + arr[end];
            if (Math.abs(sum) > Math.abs(temp)) {
                sum = temp;
                result[0] = arr[start];
                result[1] = arr[end];
            }
            if (temp > 0) {
                end--;
            } else if (temp == 0) {
                break;
            } else {
                start++;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}