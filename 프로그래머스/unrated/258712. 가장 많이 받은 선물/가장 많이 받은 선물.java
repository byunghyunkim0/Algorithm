import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int[][] board = new int[n][n];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(friends[i], i);
        }
        for (int i = 0; i < gifts.length; i++){
            String[] people = gifts[i].split(" ");
            board[map.get(people[0])][map.get(people[1])]++;
        }
        int[] gesu = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                gesu[i] += board[i][j] - board[j][i];
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (board[i][j] > board[j][i]){
                    res[i]++;
                } else if (board[i][j] == board[j][i]){
                    if (gesu[i] > gesu[j]){
                        res[i]++;
                    } else if (gesu[i] < gesu[j]){
                        res[j]++;
                    }
                } else {
                    res[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++){
            answer = Math.max(answer, res[i]);
        }
        
        return answer;
    }
}