import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 벡터 매칭
public class Main {
    static class Point {
        long x;
        long y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    static Point[] vector;
    static int[] arr;
    static double res;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            vector = new Point[n];
            arr = new int[n];

            for (int i = n / 2; i < n; i++) {
                arr[i] = 1;
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                vector[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            }

            res = Double.MAX_VALUE;
            do {
                res = Math.min(res, getVector());
            } while (permutation());
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    static boolean permutation() {
        int i = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = n - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }

        swap(i - 1, j);

        j = n - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static double getVector() {
        long x = 0;
        long y = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                x += vector[i].x;
                y += vector[i].y;
            } else {
                x -= vector[i].x;
                y -= vector[i].y;
            }
        }

        return Math.sqrt(x * x + y * y);
    }
}