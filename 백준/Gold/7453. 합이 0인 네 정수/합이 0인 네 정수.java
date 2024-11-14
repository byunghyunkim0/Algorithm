import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 합이 0인 네 정수
public class Main {
    static int[] left;
    static int[] right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a.add(Integer.parseInt(st.nextToken()));
            b.add(Integer.parseInt(st.nextToken()));
            c.add(Integer.parseInt(st.nextToken()));
            d.add(Integer.parseInt(st.nextToken()));
        }
        left = new int[n * n];
        right = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                left[i * n + j] = a.get(i) + b.get(j);
                right[i * n + j] = c.get(i) + d.get(j);
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);
        long count = 0;
        for (int num : left) {
            count += upperBound(-num) - lowerBound(-num);
        }
        System.out.println(count);
    }

    static int upperBound(int target) {
        int start = 0;
        int end = right.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (right[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    static int lowerBound(int target) {
        int start = 0;
        int end = right.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (right[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}