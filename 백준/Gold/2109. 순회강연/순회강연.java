import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 순회강연
public class Main {
    static class Program {
        int pay;
        int day;
        public Program(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }
        List<Program> programs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            programs.add(new Program(p, d));
        }
        programs.sort(Comparator.comparingInt(o -> o.day));

        PriorityQueue<Program> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.pay));
        pq.add(programs.get(0));

        for (int i = 1; i < n; i++) {
            if (pq.size() < programs.get(i).day) {
                pq.add(programs.get(i));
                continue;
            }
            if (!pq.isEmpty() && pq.peek().pay < programs.get(i).pay) {
                pq.remove();
                pq.add(programs.get(i));
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.remove().pay;
        }
        System.out.println(result);
    }
}