import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 0; test < t; test++) {
            if (sc.next().matches("((100+1+)|(01))+")){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}