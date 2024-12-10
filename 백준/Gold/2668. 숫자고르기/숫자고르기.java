import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 센서
public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        list = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        list.sort(Comparator.comparingInt(o -> o));
        System.out.println(list.size());
        for (int num : list) {
            System.out.println(num);
        }
    }

    static void dfs(int start, int target) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }

        if (arr[start] == target) {
            list.add(target);
        }
    }
}