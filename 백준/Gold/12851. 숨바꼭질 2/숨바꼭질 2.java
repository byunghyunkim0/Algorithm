import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] map = new boolean[100001];
        int[] count = new int[100001];
        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        map[n] = true;
        count[n] = 1;
        while (!map[k]) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int cur = queue.remove();
                for (int nx : new int[] {cur - 1, cur + 1, cur * 2}) {
                    if (nx >= 0 && nx <= 100000) {
                        if (!map[nx]) {
                            map[nx] = true;
                            queue.add(nx);
                            count[nx] = count[cur];
                            visited[nx] = visited[cur] + 1;
                        } else if (visited[nx] == visited[cur] + 1) {
                            count[nx] += count[cur];
                        }
                    }
                }
            }
        }
        System.out.println(visited[k]);
        System.out.println(count[k]);
    }
}