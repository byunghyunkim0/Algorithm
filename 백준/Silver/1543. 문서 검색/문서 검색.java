import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String word = sc.nextLine();
        int result = 0;
        f : for (int i = 0; i <= str.length() - word.length(); i++) {
            if (str.charAt(i) == word.charAt(0)){
                for (int j = 1; j < word.length(); j++){
                    if (str.charAt(i + j) != word.charAt(j)) {
                        continue f;
                    }
                }
                result++;
                i += word.length() - 1;
            }
        }
        System.out.println(result);
    }
}