import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 뉴스 전하기
public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 1; i < n; i++) {
            graph.get(Integer.parseInt(st.nextToken())).add(i);
        }
        System.out.println(getTime(0) - 1);
    }

    static int getTime(int node) {
        if (graph.get(node).isEmpty()) {
            return 1;
        }
        List<Integer> times = new ArrayList<>();
        for (int next : graph.get(node)) {
            times.add(getTime(next));
        }
        times.sort(Comparator.comparingInt(o -> -o));
        int res = 0;
        for (int i = 0; i < times.size(); i++) {
            res = Math.max(res, times.get(i) + i);
        }
        return res + 1;
    }
}