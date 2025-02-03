import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 아무래도이문제는A번난이도인것같다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TEST = Integer.parseInt(br.readLine());
        System.out.print("yes\n".repeat(TEST));
    }
}