import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            if (n == 1){
                System.out.println(1);
                continue;
            }
            int target = 111;
            int result = 3;
            while (target % n != 0){
                target = target * 10 + 1;
                target %= n;
                result++;
            }
            System.out.println(result);
        }
    }
}