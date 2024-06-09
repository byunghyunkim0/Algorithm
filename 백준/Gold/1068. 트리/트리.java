import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer>[] list;
    static int n;
    static int count;
    static int d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new ArrayList[n];
        count = 0;
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        int start = 0;
        for (int i = 0; i < n; i++) {
            int node = sc.nextInt();
            if (node == -1) {
                start = i;
            } else {
                list[node].add(i);
            }
        }
        d = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list[i].remove(Integer.valueOf(d));
        }
        dfs(start);
        if (d == start) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }

    static void dfs(int start) {
        if (list[start].isEmpty()) {
            count++;
        }
        for (int i = 0; i < list[start].size(); i++) {
            dfs(list[start].get(i));
        }
    }
}