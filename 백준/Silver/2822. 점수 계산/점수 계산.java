import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < 8; i++) {
            queue.add(new int[] {sc.nextInt(), i});
        }
        boolean[] index = new boolean[8];
        for (int i = 0; i < 5; i++) {
            int[] temp = queue.remove();
            result += temp[0];
            index[temp[1]] = true;
        }
        System.out.println(result);
        for (int i = 0; i < 8; i++) {
            if (index[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}