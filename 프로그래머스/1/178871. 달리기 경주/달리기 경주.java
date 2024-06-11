import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players.clone();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++) {
            int index = map.get(callings[i]);
            map.put(callings[i], map.get(callings[i]) - 1);
            String temp = answer[index - 1];
            answer[index - 1] = answer[index];
            answer[index] = temp;
            map.put(temp, map.get(temp) + 1);
        }
        return answer;
    }
}