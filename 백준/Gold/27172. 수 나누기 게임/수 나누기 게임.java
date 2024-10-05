import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수 나누기 게임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] nums = new boolean[1000001];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            nums[arr[i]] = true;
        }

        int[] score = new int[1000001];

        for (int i = 0; i < n; i++) {
            for (int j = 2 * arr[i]; j < 1000001; j += arr[i]) {
                if (nums[j]) {
                    score[j]--;
                    score[arr[i]]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(score[num]).append(" ");
        }
        System.out.println(sb);
    }
}