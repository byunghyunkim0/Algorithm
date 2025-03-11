import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 책 나눠주기
public class Main {
    static List<List<Integer>> books;
    static boolean[] check;
    static int[] done;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int Test = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < Test; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            books = new ArrayList<>();
            for (int i = 0; i <= m; i++) {
                books.add(new ArrayList<>());
            }

            done = new int[n + 1];

            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                books.get(i).add(Integer.parseInt(st.nextToken()));
                books.get(i).add(Integer.parseInt(st.nextToken()));
            }

            int count = 0;
            for (int i = 1; i <= m; i++) {
                check = new boolean[n + 1];
                if (dfs(i)) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static boolean dfs(int cur) {
        for (int next = books.get(cur).get(0); next <= books.get(cur).get(1); next++) {
            if (check[next]) {
                continue;
            }
            check[next] = true;
            if (done[next] == 0 || dfs(done[next])) {
                done[next] = cur;
                return true;
            }
        }
        return false;
    }
}