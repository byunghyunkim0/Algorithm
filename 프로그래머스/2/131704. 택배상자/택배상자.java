import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < order.length; i++){
            while (index <= order[i]){
                stack.add(index++);
            }
            if (index == order[i]){
                answer++;
                continue;
            }
            if (stack.pop() == order[i]){
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}