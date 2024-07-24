import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            if (queue.size() < k) {
                queue.add(enemy[i]);
            } else if (queue.peek() < enemy[i]){
                n -= queue.remove();
                queue.add(enemy[i]);
            } else {
                n -= enemy[i];
            }
            if (n < 0) {
                break;
            }
            answer++;
        }
        return answer;
    }
}