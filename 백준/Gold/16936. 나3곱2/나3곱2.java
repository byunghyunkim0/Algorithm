import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나3곱2
public class Main {
    static class Number {
        int count2;
        int count3;
        long remain;
        public Number(int count2, int count3, long remain) {
            this.count2 = count2;
            this.count3 = count3;
            this.remain = remain;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Number[] count = new Number[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            count[i] = countNum(Long.parseLong(st.nextToken()));
        }

        Arrays.sort(count, (o1, o2) -> {
            if (o1.count3 == o2.count3) {
                return o1.count2 - o2.count2;
            }
            return o2.count3 - o1.count3;
        });

        StringBuilder sb = new StringBuilder();
        for (Number c : count) {
            sb.append(calNumber(c)).append(" ");
        }

        System.out.print(sb);
    }

    static Number countNum(long num) {
        int c2 = 0;
        int c3 = 0;
        while (num % 2 == 0 || num % 3 == 0) {
            if (num % 2 == 0) {
                c2++;
                num /= 2;
            }
            if (num % 3 == 0) {
                c3++;
                num /= 3;
            }
        }
        return new Number(c2, c3, num);
    }

    static long calNumber(Number number) {
        long result = number.remain;
        for (int i = 0; i < number.count2; i++) {
            result *= 2;
        }
        for (int i = 0; i < number.count3; i++) {
            result *= 3;
        }
        return result;
    }
}