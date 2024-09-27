import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 별 찍기 - 11
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        int n = Integer.parseInt(br.readLine());

        // when
        List<String> result = recursive(n);

        // then
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }

    static List<String> recursive(int n) {
        if (n == 3) {
            return new ArrayList<>(List.of("  *  ", " * * ", "*****"));
        }
        List<String> stars = recursive(n / 2);
        List<String> temp = new ArrayList<>();
        for (String s : stars) {
            temp.add(" ".repeat(n / 2) + s + " ".repeat(n / 2));
        }
        for (String s : stars) {
            temp.add(s + " " + s);
        }
        return temp;
    }
}