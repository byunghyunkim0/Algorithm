import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 버블 소트
public class Main {
    static class Pair{
        int idx;
        int num;
        public Pair(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
    static int n;
    static Pair[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.num == o2.num) {
                return o1.idx - o2.idx;
            }
            return o1.num - o2.num;
        });
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i].idx - i);
        }
        System.out.println(++max);
    }
}