import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, 0});
        boolean[] visited = new boolean[y + 1];
        visited[x] = true;
        while (!queue.isEmpty()){
            int[] data = queue.remove();
            if (data[0] == y){
                answer = data[1];
                break;
            }
            if (data[0] + n <= y && !visited[data[0] + n]){
                queue.add(new int[] {data[0] + n, data[1] + 1});
                visited[data[0] + n] = true;
            }
            if (data[0] * 2 <= y && !visited[data[0] * 2]){
                queue.add(new int[] {data[0] * 2, data[1] + 1});
                visited[data[0] * 2] = true;
            }
            if (data[0] * 3 <= y && !visited[data[0] * 3]){
                queue.add(new int[] {data[0] * 3, data[1] + 1});
                visited[data[0] * 3] = true;
            }
        }
        if (x == y){
            answer = 0;
        } else if (answer == 0){
            answer--;
        }
        return answer;
    }
}