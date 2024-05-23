import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int one = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n - 1; i++){
            queue.add(sc.nextInt());
        }
        int result = 0;
        while (!queue.isEmpty() && queue.peek() >= one){
            int temp = queue.remove();
            if (temp >= one) {
                temp--;
                one++;
                result++;
                queue.add(temp);
            }
        }
        System.out.println(result);
    }
}