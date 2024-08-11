import java.util.Scanner;

public class Main {
    static int[] result;
    static int index;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[501];
        for (int i = 0; i < n; i++) {
            arr[sc.nextInt()] = sc.nextInt();
        }
        result = new int[501];
        index = 0;
        for (int i = 1; i <= 500; i++) {
            if (arr[i] != 0) {
                if (result[index] < arr[i]) {
                    result[++index] = arr[i];
                } else {
                    int idx = search(arr[i]);
                    result[idx] = arr[i];
                }
            }
        }
        System.out.println(n - index);
    }

    static int search(int n) {
        int start = 0;
        int end = index;
        int mid = (start + end) / 2;

        while (start < end) {
            if (result[mid] > n) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return mid;
    }
}