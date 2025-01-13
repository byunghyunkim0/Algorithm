import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 다음 팰린드롬 수
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        n = str.length();
        if (str.equals("9")) {
            System.out.println("11");
            return;
        }
        if (n == 1) {
            System.out.println(Integer.parseInt(str) + 1);
            return;
        }
        String pre, suf, rev;
        if (n % 2 == 1) {
            pre = str.substring(0, n / 2);
            suf = str.substring(n / 2 + 1);
            rev = reverse(pre);
            if (check(suf, rev)) {
                System.out.println(pre + str.charAt(n / 2) + rev);
            } else {
                if (str.charAt(n / 2) != '9') {
                    System.out.println(pre + (str.charAt(n / 2) - '0' + 1) + rev);
                } else {
                    String temp = sum(pre);
                    if (temp.length() > pre.length()) {
                        System.out.println(temp + reverse(temp));
                    } else {
                        System.out.println(temp + '0' + reverse(temp));
                    }
                }
            }
        } else {
            pre = str.substring(0, n / 2);
            suf = str.substring(n / 2);
            rev = reverse(pre);
            if (check(suf, rev)) {
                System.out.println(pre + rev);
            } else {
                String temp = sum(pre);
                if (str.charAt(n / 2 - 1) != '9') {
                    System.out.println(temp + reverse(temp));
                } else {
                    if (temp.length() > pre.length()) {
                        System.out.println(temp + reverse(temp.substring(0, temp.length() - 1)));
                    } else {
                        System.out.println(temp + reverse(temp));
                    }
                }
            }
        }
    }

    static String sum(String str) {
        BigInteger bigInteger = new BigInteger(str);
        return bigInteger.add(new BigInteger("1")).toString();
    }

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    static boolean check(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) < b.charAt(i)) {
                return true;
            } else if (a.charAt(i) > b.charAt(i)) {
                return false;
            }
        }
        return false;
    }
}