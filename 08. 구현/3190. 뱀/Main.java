import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 뱀
public class Main {
    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Command {
        int second;
        String direction;

        public Command(int second, String direction) {
            this.second = second;
            this.direction = direction;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // given
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Queue<Command> commands = new LinkedList<>();
        for (int command = 0; command < l; command++) {
            st = new StringTokenizer(br.readLine());
            commands.add(new Command(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        int time = 0;
        int d = 0;
        Deque<Point> snake = new ArrayDeque<>();
        snake.addFirst(new Point(0, 0));
        map[0][0] = 2;

        while (!snake.isEmpty()) {
            time++;
            Point head = snake.peekFirst();
            int nx = head.x + dx[d];
            int ny = head.y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                break;
            }
            if (map[nx][ny] == 2) {
                break;
            } else if (map[nx][ny] == 0) {
                Point tail = snake.removeLast();
                map[tail.x][tail.y] = 0;
            }
            snake.addFirst(new Point(nx, ny));
            map[nx][ny] = 2;
            if (!commands.isEmpty() && commands.peek().second == time) {
                Command c = commands.remove();
                if (c.direction.equals("D")) {
                    d = (d + 1) % 4;
                } else {
                    d = (d + 3) % 4;
                }
            }
        }

        // then
        System.out.println(time);
    }
}