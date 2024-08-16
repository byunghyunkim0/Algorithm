import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 강의실 배정
public class Main {
    static class Study {
        int start;
        int end;
        public Study(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int n = Integer.parseInt(st.nextToken());
        Study[] studies = new Study[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            studies[i] = new Study(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // when
        Arrays.sort(studies, Comparator.comparingInt(o -> o.start));
        int result = 0;
        PriorityQueue<Study> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && queue.peek().end <= studies[i].start) {
                queue.remove();
            }
            queue.add(studies[i]);
            result = Math.max(result, queue.size());
        }

        // then
        System.out.println(result);
    }
}