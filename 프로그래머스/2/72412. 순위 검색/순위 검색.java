import java.util.*;

class Solution {
    static HashMap<String, List<Integer>> score = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (String information : info) {
            dfs(information.split(" "), "", 0);
        }
        for (List<Integer> s : score.values()) {
            s.sort(Comparator.comparingInt(o -> o));
        }
        
        for (int i = 0; i < query.length; i++) {
            answer[i] = getScore(query[i]);
        }
        return answer;
    }
    
    static int getScore(String query) {
        String[] q = query.split(" and ");
        String[] s = q[3].split(" ");
        String key = q[0] + q[1] + q[2] + s[0];
        if (!score.containsKey(key)) {
            return 0;
        }
        int num = Integer.parseInt(s[1]);
        List<Integer> list = score.get(key);
        
        int start = 0;
        int end = list.size();
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (list.get(mid) >= num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return list.size() - start;
    }
    
    static void dfs(String[] info, String key, int idx) {
        if (idx == 4) {
            score.putIfAbsent(key, new ArrayList<>());
            score.get(key).add(Integer.parseInt(info[idx]));
            return;
        }
        dfs(info, key + "-", idx + 1);
        dfs(info, key + info[idx], idx + 1);
    }
}