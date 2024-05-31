import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] cup = new int[4];
        cup[1] = 1;
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int temp = cup[s];
            cup[s] = cup[e];
            cup[e] = temp;
        }
        for (int i = 1; i < 4; i++) {
            if (cup[i] == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}