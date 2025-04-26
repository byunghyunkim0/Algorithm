import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 박스 채우기
public class Main {
    static int[] cube;
    static int count = 0;
    static boolean check = false;
    static int n;
    static int[] cubeSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());
        cube = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cube[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        cubeSize = new int[n];
        cubeSize[0] = 1;
        for (int i = 1; i < n; i++) {
            cubeSize[i] = cubeSize[i - 1] * 2;
        }

        getCount(l, w, h);

        if (check) {
            System.out.println(count);
            return;
        }
        System.out.println(-1);
    }

    static void getCount(int l, int w, int h) {
        if (l == 0 || w == 0 || h == 0) {
            return;
        }

        check = false;

        int size = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (cube[i] == 0) {
                continue;
            }
            if (Math.min(Math.min(l, w), h) >= cubeSize[i] && cube[i] > 0) {
                cube[i]--;
                count++;
                check = true;
                size = i;
                break;
            }
        }

        if (!check) {
            return;
        }

        getCount(l - cubeSize[size], cubeSize[size], cubeSize[size]);
        getCount(l, w - cubeSize[size], cubeSize[size]);
        getCount(l, w, h - cubeSize[size]);
    }
}