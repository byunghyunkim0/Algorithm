import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int size = message.length();
        boolean[] check = new boolean[size];
        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                check[i] = true;
            }
        }
        String[] words = message.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        int start = 0;
        int end = 0;
        for (String word : words) {
            end = start + word.length();
            boolean flag = false;
            for (int i = start; i < end; i++) {
                if (check[i]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                map.put(word, map.get(word) - 1);
            }
            start = end + 1;
        }
        int answer = 0;
        for (int c : map.values()) {
            if (c == 0) answer++;
        }
        return answer;
    }
}