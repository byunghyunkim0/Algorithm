import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Tower{
        int index;
        int height;
        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Tower> towerStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            Tower temp = new Tower(i, Integer.parseInt(st.nextToken()));
            while (!towerStack.isEmpty()) {
                if (temp.height > towerStack.peek().height) {
                    towerStack.pop();
                } else {
                    sb.append(towerStack.peek().index).append(' ');
                    break;
                }
            }
            if (towerStack.isEmpty()) {
                sb.append(0).append(' ');
            }
            towerStack.add(temp);
        }
        System.out.println(sb);
    }
}