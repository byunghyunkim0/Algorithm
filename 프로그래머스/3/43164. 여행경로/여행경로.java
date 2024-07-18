import java.util.*;

class Solution {
    public class Place {
        private String point;
        private boolean visite;
        
        public Place(String point, boolean visite) {
            this.point = point;
            this.visite = visite;
        }
    }
    static HashMap<String, List<Place>> map;
    static Stack<String> visited;
    static String[] answer;
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        visited = new Stack<>();
        for (int i = 0; i < tickets.length; i++) {
            if (!map.containsKey(tickets[i][0])) {
                map.put(tickets[i][0], new ArrayList<>());
            }
            if (!map.containsKey(tickets[i][1])) {
                map.put(tickets[i][1], new ArrayList<>());
            }
            map.get(tickets[i][0]).add(new Place(tickets[i][1], false));
        }
        for (String key : map.keySet()) {
            map.get(key).sort((o1, o2) -> o1.point.compareTo(o2.point));
        }
        answer = new String[] {"ICN"};
        visited.add("ICN");
        dfs("ICN");
        return answer;
    }
    
    public static void dfs(String start) {
        for (int i = 0; i < map.get(start).size(); i++) {
            Place p = map.get(start).get(i);
            if (!p.visite) {
                p.visite = true;
                visited.add(p.point);
                dfs(p.point);
                visited.pop();
                p.visite = false;
            }
        }
        
        if (visited.size() > answer.length) {
            answer = new String[visited.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = visited.get(i);
            }
        }
    }
    
}