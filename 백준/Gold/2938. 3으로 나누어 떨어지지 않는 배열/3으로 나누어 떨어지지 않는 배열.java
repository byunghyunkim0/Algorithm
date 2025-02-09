import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 3으로 나누어 떨어지지 않는 배열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Queue<Integer>> count = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            count.add(new LinkedList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            count.get(num % 3).add(num);
        }

        if (count.get(0).size() > (n + 1) / 2 || count.get(0).isEmpty() && !count.get(1).isEmpty() && !count.get(2).isEmpty()) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();

        while (!count.get(1).isEmpty()) {
            if (count.get(0).size() > 1) {
                sb.append(count.get(0).remove()).append(" ");
            }
            sb.append(count.get(1).remove()).append(" ");
        }

        if (!count.get(0).isEmpty()) {
            sb.append(count.get(0).remove()).append(" ");
        }

        while (!count.get(2).isEmpty()) {
            sb.append(count.get(2).remove()).append(" ");
            if (!count.get(0).isEmpty()) {
                sb.append(count.get(0).remove()).append(" ");
            }
        }
        System.out.print(sb);
    }
}