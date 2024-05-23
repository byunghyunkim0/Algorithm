import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int minSet = 1001;
        int minOne = 1001;
        for (int i = 0; i < m; i++){
            minSet = Math.min(minSet, sc.nextInt());
            minOne = Math.min(minOne, sc.nextInt());
        }
        int allOne = n * minOne;
        int allSet = (int)Math.ceil(n / 6.0) * minSet;
        int setOne = (n / 6) * minSet + (n % 6) * minOne;
        int result = Math.min(allOne, Math.min(allSet, setOne));
        System.out.println(result);
    }
}