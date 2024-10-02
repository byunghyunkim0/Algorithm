import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사전 순 최대 공통 부분 수열
public class Main {
    static class Data {
        int num;
        int index;
        public Data (int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Data[] data = new Data[101];
        int size = 0;
        int idx = 0;
        while (idx < n) {
            int index = 0;
            for (int i = size - 1; i >= 0; i--) {
                if (data[i].num >= a[idx]) {
                    index = i + 1;
                    break;
                }
            }
            if (index == 0) {
                for (int j = 0; j < m; j++) {
                    if (a[idx] == b[j]) {
                        data[index++] = new Data(a[idx], j);
                        size = index;
                        break;
                    }
                }
            } else {
                for (int j = data[index - 1].index + 1; j < m; j++) {
                    if (a[idx] == b[j]) {
                        data[index++] = new Data(a[idx], j);
                        size = index;
                        break;
                    }
                }
            }
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\n");
        for (int i = 0; i < size; i++) {
            sb.append(data[i].num).append(" ");
        }

        System.out.println(sb);
    }
}