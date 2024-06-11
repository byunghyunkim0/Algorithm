import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Long> map = new HashMap<>();
        String[] str = {"black", "brown", "red", "orange", "yellow", "green", "blue","violet", "grey", "white"};
        for (int i = 0; i < 10; i++) {
            map.put(str[i], (long)i);
        }
        long result = (map.get(sc.next()) * 10 + map.get(sc.next())) * (long)Math.pow(10, map.get(sc.next()));
        System.out.println(result);
    }
}