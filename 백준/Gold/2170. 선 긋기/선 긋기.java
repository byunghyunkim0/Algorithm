import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 선 긋기
public class Main {
    static class Line{
        int start;
        int end;
        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(lines, ((o1, o2) -> {
            if (o1.start == o2.start) {
                return o2.end - o1.end;
            }
            return o1.start - o2.start;
        }));
        long result = 0;
        int s = lines[0].start;
        int e = lines[0].end;
        for (int i = 1; i < n; i++) {
            if (lines[i].start > e) {
                result += (e - s);
                s = lines[i].start;
                e = lines[i].end;
            } else if (lines[i].end > e) {
                e = lines[i].end;
            }
        }
        result += (e - s);
        System.out.println(result);
    }
}