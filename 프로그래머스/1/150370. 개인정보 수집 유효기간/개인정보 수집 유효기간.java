import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] temp = terms[i].split(" ");
            map.put(temp[0], getDay(today, temp[1]));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            if (check(map.get(temp[1]), temp[0])) {
                result.add(i + 1);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public static String getDay(String day, String term) {
        String[] temp = day.split("\\.");
        int t = Integer.parseInt(term);
        int y = Integer.parseInt(temp[0]) - (t / 12);
        int m = Integer.parseInt(temp[1]) - (t % 12);
        if (m <= 0) {
            y--;
            m += 12;
        }
        temp[0] = String.valueOf(y);
        temp[1] = String.valueOf(m);
        if (temp[1].length() == 1) {
            temp[1] = "0" + temp[1];
        }
        return String.join(".", temp);
    }
    
    public static boolean check(String day, String privacy) {
        for (int i = 0; i < day.length(); i++) {
            if (day.charAt(i) < privacy.charAt(i)) {
                return false;
            } else if (day.charAt(i) > privacy.charAt(i)) {
                return true;
            }
        }
        return true;
    }
}