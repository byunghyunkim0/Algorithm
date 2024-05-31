import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] list = new int[5000];
        int index = 1;
        int result = 0;
        for (int i = 1; i < 50; i++){
            for (int j = 0; j < i; j++) {
                list[index++] = i;
            }
        }
        for (int i = a; i <= b; i++){
            result += list[i];
        }
        System.out.println(result);
    }
}