import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 두 원
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double r1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double r2 = Double.parseDouble(st.nextToken());

        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        System.out.printf("%.3f", getResult(distance, r1, r2));
    }

    private static double getResult(double distance, double r1, double r2) {
        if (distance >= r1 + r2) {
            return 0;
        }
        if (distance <= Math.abs(r1 - r2)) {
            return Math.min(Math.pow(r1, 2), Math.pow(r2, 2)) * Math.PI;
        }
        double alpha = 2 * Math.acos((distance * distance + r1 * r1 - r2 * r2) / (2 * distance * r1));
        double beta = 2 * Math.acos((distance * distance + r2 * r2 - r1 * r1) / (2 * distance * r2));
        return (r1 * r1 * (alpha - Math.sin(alpha)) + r2 * r2 * (beta - Math.sin(beta))) / 2;
    }
}