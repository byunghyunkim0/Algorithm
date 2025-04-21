import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 피자판매
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] pieceA = new int[2 * m + 1];
        int[] pieceB = new int[2 * n + 1];
        initPiece(br, m, pieceA);
        initPiece(br, n, pieceB);

        int[] sizeA = makeSizeArr(m, pieceA);
        int[] sizeB = makeSizeArr(n, pieceB);

        int count = 0;
        for (int i = 1; i < target; i++) {
            count += sizeB[target - i] * sizeA[i];
        }
        count += sizeA[target] + sizeB[target];
        System.out.println(count);
    }

    static int[] makeSizeArr(int n, int[] piece) {
        int[] size = new int[1000001];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < i + n; j++) {
                size[piece[j] - piece[i]]++;
            }
        }
        size[piece[n]]++;
        return size;
    }

    static void initPiece(BufferedReader br, int n, int[] piece) throws IOException {
        for (int i = 1; i <= n; i++) {
            piece[i] = piece[i - 1] + Integer.parseInt(br.readLine());
        }
        for (int i = n + 1; i < piece.length; i++) {
            piece[i] = piece[i - n] + piece[n];
        }
    }
}