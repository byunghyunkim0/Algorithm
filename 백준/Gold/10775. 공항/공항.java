import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 공항
public class Main {
    static int[] airport;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        airport = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            airport[i] = i;
        }
        int count = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int pg = find(g);
            if (pg == 0) {
                break;
            }
            union(find(pg - 1), pg);
            count++;
        }
        System.out.println(count);
    }
    static int find(int x) {
        if (x != airport[x]) {
            return airport[x] = find(airport[x]);
        }
        return x;
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            airport[pb] = pa;
        }
    }
}