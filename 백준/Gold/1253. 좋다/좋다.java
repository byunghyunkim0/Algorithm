import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좋다
public class Main {
    static int[] nums;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (search(i, nums[i])) {
                result++;
            }
        }
        System.out.println(result);
    }

    static boolean search(int idx, int target) {
        int start = 0;
        int end = n - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                if (start == idx) {
                    start++;
                } else if (end == idx) {
                    end--;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}