import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        String n = br.readLine();

        // when
        int q = 0;
        for (int i = 0; i < n.length(); i++) {
            q = (q * 10 + (n.charAt(i) - '0')) % 20000303;
        }

        // then
        System.out.println(q);
    }
}