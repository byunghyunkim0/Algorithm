import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long result = 0;
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int b = sc.nextInt();
        int c = sc.nextInt();
        for (int i = 0; i < n; i++){
            if (a[i] <= b){
                result++;
                continue;
            }
            a[i] -= b;
            result += (int) Math.ceil((double)(a[i]) / c) + 1;
        }
        System.out.println(result);
    }
}