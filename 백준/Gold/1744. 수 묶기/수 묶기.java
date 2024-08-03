import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> nQueue = new PriorityQueue<>();
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            if (number > 0) {
                pQueue.add(number);
            } else {
                nQueue.add(number);
            }
        }
        int result = 0;
        while (nQueue.size() > 1) {
            result += nQueue.remove() * nQueue.remove();
        }
        while (pQueue.size() > 1) {
            int temp1 = pQueue.remove();
            int temp2 = pQueue.remove();
            if (temp1 == 1 || temp2 == 1) {
                result += temp1 + temp2;
            } else {
                result += temp1 * temp2;
            }
        }
        if (!pQueue.isEmpty()) {
            result += pQueue.remove();
        }
        if (!nQueue.isEmpty()) {
            result += nQueue.remove();
        }
        System.out.println(result);
    }
}