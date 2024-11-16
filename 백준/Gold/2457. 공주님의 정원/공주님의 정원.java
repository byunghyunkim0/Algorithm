import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공주님의 정원
public class Main {
    static class Period {
        int start;
        int end;

        public Period(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Period[] flower = new Period[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());
            flower[i] = new Period(startM * 100 + startD, endM * 100 + endD);
        }
        Arrays.sort(flower, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o2.end - o1.end;
            }
            return o1.start - o2.start;
        });

        int start = 301;
        int end =  0;
        int count = 0;
        int idx = 0;
        while (start < 1201) {
            boolean temp = false;
            for (int i = idx; i < n; i++) {
                if (flower[i].start > start) {
                    break;
                }
                if (flower[i].start <= start && end < flower[i].end) {
                    end = flower[i].end;
                    idx = i + 1;
                    temp = true;
                }
            }
            if (temp) {
                start = end;
                count++;
            } else {
                break;
            }
        }
        if (end < 1201) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }
}