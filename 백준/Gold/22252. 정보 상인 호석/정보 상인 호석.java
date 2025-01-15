import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 정보 상인 호석
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int q = Integer.parseInt(br.readLine());
        HashMap<String, PriorityQueue<Integer>> data = new HashMap<>();
        long result = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            if (!data.containsKey(name)) {
                data.put(name, new PriorityQueue<>(Comparator.comparingInt(o -> -o)));
            }
            if (f == 1) {
                for (int j = 0; j < k; j++) {
                    data.get(name).add(Integer.parseInt(st.nextToken()));
                }
                continue;
            }
            PriorityQueue<Integer> curQueue = data.get(name);
            while (k > 0 && !curQueue.isEmpty()) {
                result += curQueue.remove();
                k--;
            }
        }
        System.out.println(result);
    }
}