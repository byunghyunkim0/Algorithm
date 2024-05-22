import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[] list = new int[1001];
        for (int i = 0; i < n; i++){
            list[arr[i]]++;
        }
        for (int i = 1; i < 1001; i++){
            list[i] += list[i - 1];
        }
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--){
            result[i] = --list[arr[i]];
        }
        for (int i = 0; i < n; i++){
            System.out.print(result[i] + " ");
        }
    }
}