import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] parents;
	static int n, MAX;
    static long ans;
	static int[] depth;
	static ArrayList<Integer>[] graph;
	static ArrayList<Integer> target;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TEST = sc.nextInt();
		for (int testCase = 1; testCase <= TEST; testCase++) {
			n = sc.nextInt();
			ans = 0;
			MAX = (int)(Math.log(n) / Math.log(2));
			parents = new int[n + 1][MAX + 1];
			depth = new int[n + 1];
			graph = new ArrayList[n + 1];
			target = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 2; i <= n; i++) {
				int parent = sc.nextInt();
				graph[parent].add(i);
				graph[i].add(parent);
			}
			bfs(1, 0);
			setParent();
			for (int i = 0; i < target.size() - 1; i++) {
				int node1 = target.get(i);
				int node2 = target.get(i + 1);
				int common = lca(node1, node2);
				ans += depth[node1] - depth[common] + depth[node2] - depth[common];
			}
			System.out.println("#" + testCase + " " + ans);
		}
		sc.close();
	}
	public static void bfs(int node, int d) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		boolean[] visited = new boolean[n + 1];
		visited[node] = true;
		while (!queue.isEmpty()) {
			int cur = queue.remove();
			target.add(cur);
			
			for (int i = 0; i < graph[cur].size(); i++) {
				int curNode = graph[cur].get(i);
				if (visited[curNode]) {
					continue;
				}
				queue.add(curNode);
				visited[curNode] = true;
				depth[curNode] = depth[cur] + 1;
				parents[curNode][0] = cur;
			}
		}
	}
	public static void setParent() {
		for (int i = 1; i < MAX; i++) {
			for (int cur = 1; cur <= n; cur++) {
				parents[cur][i] = parents[parents[cur][i - 1]][i - 1];
			}
		}
	}
	public static int lca(int x, int y) {
		if (depth[x] > depth[y]) {
			int temp = x;
			x = y;
			y = temp;
		}
		
		for (int i = MAX; i >= 0; i--) {
			int jump = 1 << i;
			if (depth[y] - depth[x] >= jump) {
				y = parents[y][i];
			}
		}
		
		if (x == y) {
			return x;
		}
		for (int i = MAX; i >= 0; i--) {
			if (parents[x][i] == parents[y][i]) {
				continue;
			}
			x = parents[x][i];
			y = parents[y][i];
		}
		return parents[x][0];
	}
}
