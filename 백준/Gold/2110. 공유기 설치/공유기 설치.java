import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공유기 설치
public class Main {
    static int[] house;
    static int n;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        // when
        Arrays.sort(house);
        int start = 0;
        int end = house[n - 1];
        int mid = (start + end) / 2;
        while (start <= end) {
            if (check(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }

        // then
        System.out.println(mid);
    }

    public static boolean check(int inter) {
        int count = 1;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (house[i] - house[index] >= inter) {
                index = i;
                count++;
            }
        }
        return count >= c;
    }
}