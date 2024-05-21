import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.replaceAll("XXXX","AAAA");
        str = str.replaceAll("XX", "BB");
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'X'){
                str = "-1";
                break;
            }
        }
        System.out.println(str);
    }
}