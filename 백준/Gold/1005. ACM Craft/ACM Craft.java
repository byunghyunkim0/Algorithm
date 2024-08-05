import java.util.*;

public class Main {
    static class Node {
        int cost;
        int point;
        public Node(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] time = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                time[i] = sc.nextInt();
            }

            int[] d = new int[n + 1];
            for (int i = 0; i < k; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                graph[s].add(e);
                d[e]++;
            }

            int[] result = new int[n + 1];
            Queue<Node> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (d[i] == 0) {
                    queue.add(new Node(i, time[i]));
                    result[i] = time[i];
                }
            }
            int w = sc.nextInt();
            while (!queue.isEmpty()) {
                Node cur = queue.remove();
                for (int i = 0; i < graph[cur.point].size(); i++) {
                    d[graph[cur.point].get(i)]--;
                    result[graph[cur.point].get(i)] = Math.max(result[graph[cur.point].get(i)], time[graph[cur.point].get(i)] + cur.cost);
                    if (d[graph[cur.point].get(i)] == 0) {
                        queue.add(new Node(graph[cur.point].get(i), result[graph[cur.point].get(i)]));
                    }
                }
            }
            System.out.println(result[w]);
        }
    }
}