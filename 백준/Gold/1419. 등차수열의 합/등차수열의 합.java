import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 등차수열의 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int d = k * (k + 1) / 2;
        l = Math.max(l, d);
        if (l > r) {
            System.out.println(0);
            return;
        }
        int count;
        if (k == 2) {
            count = Math.max(r - l + 1, 0);
        } else if (k == 3) {
            count = r / 3;
            if (l % 3 == 0) {
                count -= l / 3 - 1;
            } else {
                count -= l / 3;
            }
        } else if (k == 4) {
            count = r / 2;
            if (l % 2 == 0) {
                count -= l / 2 - 1;
            } else {
                count -= l / 2;
            }
            if (l <= 12 && r >= 12) {
                count--;
            }
        } else {
            count = r / 5;
            if (l % 5 == 0) {
                count -= l / 5 - 1;
            } else {
                count -= l / 5;
            }
        }
        System.out.println(count);
    }
}