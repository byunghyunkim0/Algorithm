import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> words;
    static int l;
    static int c;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        words = new ArrayList<>();
        visited = new boolean[c];
        for (int i = 0; i < c; i++) {
            words.add(sc.next());
        }
        Collections.sort(words);
        combination(0, l);
    }

    static void combination(int idx, int count) {
        if (count == 0) {
            int temp = 0;
            for (int i = 0; i < c; i++) {
                if (visited[i]) {
                    if (words.get(i).equals("a") || words.get(i).equals("e") || words.get(i).equals("i") || words.get(i).equals("o") || words.get(i).equals("u")) {
                        temp++;
                    }
                }
            }
            if (temp >= 1 && temp <= l - 2) {
                for (int i = 0; i < c; i++) {
                    if (visited[i]) {
                        System.out.print(words.get(i));
                    }
                }
                System.out.println();
            }
            return;
        }

        for (int i = idx; i < c; i++) {
            visited[i] = true;
            combination(i + 1, count - 1);
            visited[i] = false;
        }
    }
}