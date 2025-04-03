import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 연료 채우기
public class Main {
    static class Station {
        int idx;
        int fuel;
        public Station(int idx, int fuel) {
            this.idx = idx;
            this.fuel = fuel;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Station[] stations = new Station[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stations[i] = new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(stations, Comparator.comparingInt(o -> o.idx));
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int cur = p;
        PriorityQueue<Station> queue = new PriorityQueue<>(Comparator.comparingInt(o -> -o.fuel));

        int stop = 0;
        for (int i = 0; i < n; i++) {
            if (cur >= l) {
                break;
            }
            if (stations[i].idx <= cur) {
                queue.add(stations[i]);
                continue;
            }
            while (cur < stations[i].idx && !queue.isEmpty()) {
                cur += queue.remove().fuel;
                stop++;
            }
            if (cur >= stations[i].idx) {
                queue.add(stations[i]);
            }
        }
        while (cur < l && !queue.isEmpty()) {
            cur += queue.remove().fuel;
            stop++;
        }
        if (cur < l) {
            System.out.println(-1);
        } else {
            System.out.println(stop);
        }
    }
}