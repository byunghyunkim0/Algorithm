import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 원판 돌리기
public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static List<List<Integer>> map;
    static int n;
    static int m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean check;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }
            map.add(temp);
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            check = false;
            rotate(x, d, k);
            if (!check) {
                cal();
            }
        }

        System.out.println(sum());
    }

    static int sum() {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.get(i).get(j) == -1) {
                    continue;
                }
                res += map.get(i).get(j);
            }
        }
        return res;
    }

    static void cal() {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.get(i).get(j) == -1) {
                    continue;
                }
                sum += map.get(i).get(j);
                count++;
            }
        }
        double avg = (double)sum / count;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.get(i).get(j) == -1) {
                    continue;
                }
                if (map.get(i).get(j) < avg) {
                    map.get(i).set(j, map.get(i).get(j) + 1);
                } else if (map.get(i).get(j) > avg) {
                    map.get(i).set(j, map.get(i).get(j) - 1);
                }
            }
        }
    }

    static void rotate(int x, int d, int k) {
        if (d == 0) {
            d = 1;
        } else {
            d = -1;
        }
        for (int i = x - 1; i < n; i += x) {
            Collections.rotate(map.get(i), k * d);
        }
        delete();
    }

    static void delete() {
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.get(i).get(j) == -1) {
                    continue;
                }
                dfs(new Point(i, j), map.get(i).get(j));
            }
        }
    }

    static void dfs(Point p, int target) {
       for (int d = 0; d < 4; d++) {
           int nx = p.x + dx[d];
           int ny = p.y + dy[d];
           if (ny == m) {
               ny = 0;
           }
           if (ny == -1) {
               ny = m - 1;
           }
           if (nx >= 0 && nx < n && map.get(nx).get(ny) == target) {
               map.get(nx).set(ny, - 1);
               check = true;
               dfs(new Point(nx, ny), target);
           }
       }
    }
}