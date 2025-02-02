import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 학생 인기도 측정
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String student = st.nextToken();
            map.put(student, 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String student = st.nextToken();
                map.put(student, map.get(student) + 1);
            }
        }

        map
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue() == o2.getValue()) {
                        int len = Math.min(o1.getKey().length(), o2.getKey().length());
                        for (int i = 0; i < len; i++) {
                            if (o1.getKey().charAt(i) != o2.getKey().charAt(i)) {
                                return o1.getKey().charAt(i) - o2.getKey().charAt(i);
                            }
                        }
                        return o1.getKey().length() - o2.getKey().length();
                    }
                    return o2.getValue() - o1.getValue();
                })
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}