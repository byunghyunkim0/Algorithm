import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// 상어 키우기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> shark = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            shark.add(Integer.parseInt(st.nextToken()));
        }
        shark.sort(Comparator.comparingInt(o -> o));

        Stack<Integer> food = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (shark.get(i) < t) {
                food.add(shark.get(i));
                continue;
            }

            while (!food.isEmpty() && shark.get(i) >= t && k > 0) {
                t += food.pop();
                k--;
            }
            if (k == 0 || t <= shark.get(i)) {
                break;
            }
            food.add(shark.get(i));
        }
        while (k > 0 && !food.isEmpty()) {
            t += food.pop();
            k--;
        }
        System.out.println(t);
    }
}