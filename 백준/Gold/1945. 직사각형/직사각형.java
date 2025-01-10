import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 직사각형
public class Main {
    static class Gradient {
        double g;
        int v;
        public Gradient(double g, int v) {
            this.g = g;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Gradient> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int xa = Integer.parseInt(st.nextToken());
            int ya = Integer.parseInt(st.nextToken());
            int xb = Integer.parseInt(st.nextToken());
            int yb = Integer.parseInt(st.nextToken());
            list.add(new Gradient((double)yb / xa, 1));
            list.add(new Gradient((double)ya / xb, -1));
        }
        list.sort((o1, o2) -> {
            if (o1.g == o2.g) {
                return o2.v - o1.v;
            } else if (o1.g > o2.g) {
                return -1;
            }
            return 1;
        });
        int result = 0;
        int count = 0;
        for (Gradient gradient : list) {
            count += gradient.v;
            result = Math.max(result, count);
        }
        System.out.println(result);
    }
}