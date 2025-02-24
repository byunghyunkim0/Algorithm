import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 교환
public class Main {
    static class Data {
        int count;
        String num;
        public Data(int count, String num) {
            this.count = count;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int k = Integer.parseInt(st.nextToken());

        int res = 0;
        boolean[][] visited = new boolean[1000001][k + 1];
        visited[Integer.parseInt(n)][0] = true;
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, n));

        while (!queue.isEmpty()) {
            Data cur = queue.remove();
            if (cur.count == k) {
                res = Math.max(res, Integer.parseInt(cur.num));
                continue;
            }

            for (int i = 0; i < cur.num.length() - 1; i++) {
                for (int j = i + 1; j < cur.num.length(); j++) {
                    String num = swap(cur.num, i, j);
                    if (num == null) {
                        continue;
                    }
                    int number = Integer.parseInt(num);
                    if (visited[number][cur.count + 1]) {
                        continue;
                    }
                    queue.add(new Data(cur.count + 1, num));
                    visited[number][cur.count + 1] = true;
                }
            }
        }

        if (res == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(res);
    }

    static String swap(String num, int i, int j) {
        char[] arr = num.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        if (arr[0] == '0') {
            return null;
        }
        return String.valueOf(arr);
    }
}