import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 나무 재테크
public class Main {
    static class Tree{
        int x;
        int y;
        int age;
        boolean dead;
        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
            this.dead = false;
        }
    }
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int n;
    static int m;
    static int[][] map;
    static int[][] food;
    static List<Tree> tree;
    static Queue<Tree> deadTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 5);
        }

        food = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                food[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tree = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            tree.add(new Tree(x, y, z));
        }
        deadTree = new LinkedList<>();
        while (k > 0) {
            spring();
            summer();
            autumn();
            winter();
            k--;
        }
        System.out.println(tree.size());
    }

    static void spring() {
        for (int i = tree.size() - 1; i >= 0; i--) {
            Tree cur = tree.get(i);
            if (cur.dead) {
                continue;
            }
            if (map[cur.x][cur.y] >= cur.age) {
                map[cur.x][cur.y] -= cur.age;
                cur.age++;
                continue;
            }
            deadTree.add(cur);
            cur.dead = true;
        }
    }

    static void summer() {
        while (!deadTree.isEmpty()) {
            Tree cur = deadTree.remove();
            map[cur.x][cur.y] += cur.age / 2;
        }
    }

    static void autumn() {
        List<Tree> newTree = new ArrayList<>();
        for (Tree tree : tree) {
            if (!tree.dead) {
                newTree.add(tree);
            }
        }
        for (int i = newTree.size() - 1; i >= 0; i--) {
            Tree cur = newTree.get(i);
            if (cur.age % 5 != 0) {
                continue;
            }
            for (int d = 0; d < 8; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    newTree.add(new Tree(nx, ny, 1));
                }
            }
        }
        tree = newTree;
    }

    static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] += food[i][j];
            }
        }
    }
}