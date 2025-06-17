import java.util.*;

class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static int answer = 0;
    public int solution(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        List<Integer> move = new ArrayList<>();
        move.add(0);
        dfs(0, 0, 0, move, info);
        return answer;
    }
    
    static void dfs(int node, int sheep, int wolf, List<Integer> move, int[] info) {
        if (info[node] == 0) {
            sheep++;
        } else {
            wolf++;
        }
        
        if (sheep == wolf) {
            return;
        }
        
        answer = Math.max(answer, sheep);
        
        List<Integer> newMove = new ArrayList<>(move);
        newMove.remove(Integer.valueOf(node));
        if (!graph.get(node).isEmpty()) {
            newMove.addAll(graph.get(node));
        }
        for (int next : newMove) {
            dfs(next, sheep, wolf, newMove, info);
        }
    }
}