import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 순서
public class Main {
    static int[] data;
    static List<Integer> number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int Test = 0; Test < T; Test++) {
            int n = Integer.parseInt(br.readLine());
            data = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            number = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                number.add(i);
            }
            sb.append(getRes(n)).append("\n");
        }
        System.out.print(sb);
    }

    static String getRes(int n) {
        String[] temp = new String[n];
        for (int i = n - 1; i >= 0; i--) {
            if (data[i] >= number.size()) {
                return "IMPOSSIBLE";
            }
            temp[i] = String.valueOf(number.remove(data[i]));
        }

        return String.join(" ", temp);
    }
}