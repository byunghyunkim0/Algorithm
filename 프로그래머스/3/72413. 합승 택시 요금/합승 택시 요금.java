import java.util.*;

class Solution {
    static List<int[]>[] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < fares.length; i++) {
            graph[fares[i][0]].add(new int[] {fares[i][2], fares[i][1]});
            graph[fares[i][1]].add(new int[] {fares[i][2], fares[i][0]});
        }
        int[] dists = dijkstra(s, n);
        int[] dista = dijkstra(a, n);
        int[] distb = dijkstra(b, n);
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dists[i] <= 100000000 && dista[i] <= 100000000 && distb[i] <= 100000000) {
                answer = Math.min(answer, dista[i] + distb[i] + dists[i]);
            }
        }
        return answer;
    }
    static int[] dijkstra(int start, int n) {
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[] {start, 0});
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (dist[cur[0]] < cur[1]) {
                continue;
            }
            for (int i = 0; i < graph[cur[0]].size(); i++) {
                int[] next = graph[cur[0]].get(i);
                if (dist[next[1]] > next[0] + cur[1]) {
                    dist[next[1]] = next[0] + cur[1];
                    queue.add(new int[] {next[1], dist[next[1]]});
                }
            }
        }
        return dist;
    }
}