import java.util.PriorityQueue;
import java.util.Scanner;

// 세수 정렬
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            queue.add(sc.nextInt());
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(queue.remove() + " ");
        }
    }
}