import java.util.*;

public class Main {
    static List<Integer>[] map;
    static boolean[] visited;
    static Queue<int[]> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new ArrayList[5];
        queue = new LinkedList<>();
        for (int i = 1; i <= 4; i++) {
            String temp = sc.next();
            map[i] = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                map[i].add(temp.charAt(j) - '0');
            }
        }
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            visited = new boolean[5];
            int index = sc.nextInt();
            int d = sc.nextInt();
            move(index, d);
            while (!queue.isEmpty()) {
                int[] cur = queue.remove();
                Collections.rotate(map[cur[0]], cur[1]);
            }
        }
        int result = 0;
        for (int i = 1; i <= 4; i++) {
            result += map[i].get(0) * (int)Math.pow(2.0, i - 1);
        }
        System.out.println(result);
    }

    static void move(int index, int d) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        queue.add(new int[] {index, d});
        if (index == 1) {
            if (!map[1].get(2).equals(map[2].get(6))) {
                move(2, d * (-1));
            }
        } else if (index == 4) {
            if (!map[4].get(6).equals(map[3].get(2))) {
                move(3, d * (-1));
            }
        } else {
            if (!map[index].get(2).equals(map[index + 1].get(6))) {
                move(index + 1, d * (-1));
            }
            if (!map[index].get(6).equals(map[index - 1].get(2))) {
                move(index - 1, d * (-1));
            }
        }
    }
}