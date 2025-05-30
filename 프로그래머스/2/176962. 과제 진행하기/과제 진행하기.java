import java.util.*;

class Solution {
    static class Plan {
        String name;
        int start;
        int playTime;
        public Plan(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Plan> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
        for (String[] plan : plans) {
            queue.add(new Plan(plan[0], getTime(plan[1]), Integer.parseInt(plan[2])));
        }
        
        Stack<Plan> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        int cur = 0;
        while (!queue.isEmpty()) {
            Plan p = queue.remove();
            if (stack.isEmpty()) {
                cur = p.start;
                stack.add(p);
                continue;
            }
            
            while (!stack.isEmpty()) {
                if (cur + stack.peek().playTime > p.start) {
                    stack.peek().playTime -= p.start - cur;
                    break;
                }
                Plan temp = stack.pop();
                cur += temp.playTime;
                res.add(temp.name);
            }
            cur = p.start;
            stack.add(p);
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop().name);
        }
        for (int i = 0; i < plans.length; i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
    
    static int getTime(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}