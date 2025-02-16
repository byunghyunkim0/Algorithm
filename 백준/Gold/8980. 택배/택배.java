import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 택배
public class Main {
    static class Box {
        int a;
        int b;
        int w;
        public Box(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        Box[] boxes = new Box[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            boxes[i] = new Box(a, b, w);
        }

        Arrays.sort(boxes, (o1, o2) -> {
            if (o1.b == o2.b) {
                return o1.a - o2.a;
            }
            return o1.b - o2.b;
        });

        int[] weight = new int[n + 1];
        int res = 0;
        for (Box box : boxes) {
            int temp = box.w;
            for (int i = box.a; i < box.b; i++) {
                temp = Math.min(temp, c - weight[i]);
            }

            for (int i = box.a; i < box.b; i++) {
                weight[i] += temp;
            }
            res += temp;
        }
        System.out.println(res);
    }
}