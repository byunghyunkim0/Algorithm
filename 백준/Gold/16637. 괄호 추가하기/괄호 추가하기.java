import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 괄호 추가하기
public class Main {
    static boolean[] selected;
    static int n;
    static String formula;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        formula = br.readLine();
        if (n < 3) {
            System.out.println(formula);
            return;
        }
        selected = new boolean[n / 2 + 1];
        result = Integer.MIN_VALUE;
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int idx) {
        result = Math.max(result, getResult());
        for (int i = idx + 1; i < n / 2; i++) {
            if (selected[i - 1]) {
                continue;
            }
            selected[i] = true;
            dfs(i);
            selected[i] = false;
        }
    }

    static int getResult() {
        char[] calFormula = formula.toCharArray();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(calFormula[0] - '0');
        List<Character> operators = new ArrayList<>();
        for (int i = 1; i < calFormula.length; i += 2) {
            int index = i / 2;
            if (selected[index]) {
                continue;
            }
            if (selected[index + 1]) {
                numbers.add(cal(calFormula[i + 1] - '0', calFormula[i + 2], calFormula[i + 3] - '0'));
            } else {
                numbers.add(calFormula[i + 1] - '0');
            }
            operators.add(calFormula[i]);
        }
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = cal(result, operators.get(i), numbers.get(i + 1));
        }
        return result;
    }

    static int cal(int left, char op, int right) {
        int result = left;
        if (op == '+') {
            result += right;
        } else if (op == '-') {
            result -= right;
        } else {
            result *= right;
        }
        return result;
    }
}