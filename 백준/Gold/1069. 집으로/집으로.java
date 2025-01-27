import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 집으로
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        double dist = Math.sqrt(x * x + y * y);
        if (d <= t) {
            System.out.println(dist);
            return;
        }

        int jump = (int)(dist / d);
        double jumpWalk, jumpJump;
        if (dist >= d) {
            jumpWalk = t * jump + (dist - (d * jump));
            jumpJump = t * (jump + 1);
        } else {
            jumpWalk = t + (d - dist);
            jumpJump = t * 2;
        }
        System.out.println(Math.min(dist, Math.min(jumpWalk, jumpJump)));
    }
}