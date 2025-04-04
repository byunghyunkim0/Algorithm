import java.util.*;

class Solution {
    static class Node {
        int idx;
        int cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    List<List<Integer>> graph = new ArrayList<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[destination] = 0;
        pq.add(new Node(destination, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.remove();
            if (distance[cur.idx] < cur.cost) {
                continue;
            }
            for (int next : graph.get(cur.idx)) {
                if (distance[next] > cur.cost + 1) {
                    distance[next] = cur.cost + 1;
                    pq.add(new Node(next, distance[next]));
                }
            }
        }
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}