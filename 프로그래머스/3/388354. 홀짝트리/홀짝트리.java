import java.util.*;

class Solution {
    static int[] count = new int[1000001];
    static boolean[] visited = new boolean[1000001];
    static List<Integer>[] graph = new ArrayList[1000001];
    static boolean[] check = new boolean[1000001];
    static int[] res;
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = {0, 0};
        
        for (int node : nodes) {
            graph[node] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        for (int node : nodes) {
            if (node % 2 == count[node] % 2) {
                check[node] = true;
            }
        }
        
        for (int node : nodes) {
            if (visited[node]) {
                continue;
            }
            res = new int[2];
            getTree(node);
            if (res[0] == 1) {
                answer[0]++;
            }
            
            if (res[1] == 1) {
                answer[1]++;
            }
        }
        return answer;
    }
    
    static void getTree(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        if (check[node]) {
            res[0]++;
        } else {
            res[1]++;
        }
        for (int next : graph[node]) {
            if (visited[next]) {
                continue;
            }
            getTree(next);
        }
    }
}