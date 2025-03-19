import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 컬러볼
public class Main {
    static class Ball {
        int idx;
        int color;
        int size;
        public Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Ball[] balls = new Ball[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            balls[i] = new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(balls, (o1, o2) -> {
            if (o1.size == o2.size) {
                return o1.color - o2.color;
            }
            return o1.size - o2.size;
        });

        int[] res = new int[n];
        int[] sum = new int[n + 1];
        int total = 0;

        Queue<Ball> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i != 0 && balls[i - 1].size != balls[i].size) {
                while (!queue.isEmpty()) {
                    Ball cur = queue.remove();
                    total += cur.size;
                    sum[cur.color] += cur.size;
                }
            }
            queue.add(balls[i]);
            res[balls[i].idx] = total - sum[balls[i].color];
        }

        StringBuilder sb = new StringBuilder();
        for (int result : res) {
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}