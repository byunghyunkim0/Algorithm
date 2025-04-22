import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 물통
public class Main {
    static class Work {
        int a;
        int b;
        public Work(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    static int a;
    static int b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Queue<Work> works = new LinkedList<>();
        works.add(new Work(0, 0));

        HashMap<String, Integer> map = new HashMap<>();
        map.put("0_0", 0);

        int time = 0;
        while (!works.isEmpty()) {
            int len = works.size();
            for (int i = 0; i < len; i++) {
                Work cur = works.remove();
                if (cur.a == c && cur.b == d) {
                    System.out.println(time);
                    return;
                }

                String[] water = getWater(cur.a, cur.b);

                if (!map.containsKey(water[0])) {
                    map.put(water[0], 0);
                    works.add(new Work(a, cur.b));
                }
                if (!map.containsKey(water[1])) {
                    map.put(water[1], 0);
                    works.add(new Work(cur.a, b));
                }

                if (!map.containsKey(water[2])) {
                    map.put(water[2], 0);
                    works.add(new Work(0, cur.b));
                }
                if (!map.containsKey(water[3])) {
                    map.put(water[3], 0);
                    works.add(new Work(cur.a, 0));
                }

                int sum = cur.a + cur.b;
                if (!map.containsKey(water[4])) {
                    map.put(water[4], 0);
                    works.add(new Work(Math.min(sum, a), Math.max(sum - a, 0)));
                }

                if (!map.containsKey(water[5])) {
                    map.put(water[5], 0);
                    works.add(new Work(Math.max(sum - b, 0), Math.min(sum, b)));
                }
            }
            time++;
        }
        System.out.println(-1);
    }

    static String[] getWater(int x, int y) {
        int sum = x + y;
        return new String[] {"a_" + y, x + "_b", "0_" + y, x + "_0", Math.min(sum, a) + "_" + Math.max(sum - a, 0), Math.max(sum - b, 0) + "_" + Math.min(sum, b)};
    }
}