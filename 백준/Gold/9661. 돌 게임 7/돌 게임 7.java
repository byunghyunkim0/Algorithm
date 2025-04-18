import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 돌 게임 7
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int mod = (int)(n % 5);
        String[] res = {"CY", "SK", "CY", "SK", "SK"};
        System.out.println(res[mod]);
    }
}