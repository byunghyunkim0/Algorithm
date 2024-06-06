import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int p = sc.nextInt();
        int target = l * p;
        int[] result = new int[5];
        for (int i = 0; i < 5; i++) {
            result[i] = sc.nextInt() - target;
        }
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}