import java.util.*;

class Solution {
    static class Data {
        char A;
        char B;
        char function;
        int distance;
        public Data(char A, char B, char function, int distance) {
            this.A = A;
            this.B = B;
            this.function = function;
            this.distance = distance;
        }
    }
    static char[] friend = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static List<Character> line = new ArrayList<>();
    static boolean[] visited = new boolean[8];
    static int answer;
    static Data[] fData;
    public int solution(int n, String[] data) {
        answer = 0;
        fData = new Data[n];
        init(data);
        dfs(0);
        return answer;
    }
    
    static void dfs(int idx) {
        if (idx == 8) {
            if (check()) {
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < 8; i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            line.add(friend[i]);
            dfs(idx + 1);
            line.remove(line.size() - 1);
            visited[i] = false;
        }
    }
    
    static void init(String[] data) {
        for (int i = 0; i < data.length; i++) {
            fData[i] = new Data(data[i].charAt(0), data[i].charAt(2), data[i].charAt(3), data[i].charAt(4) - '0');
        }
    }
    
    static boolean check() {
        for (Data f : fData) {
            int diff = Math.abs(line.indexOf(f.A) - line.indexOf(f.B)) - 1;
            
            if (f.function == '=') {
                if (diff != f.distance) {
                    return false;
                }
            } else if (f.function == '<') {
                if (diff >= f.distance) {
                    return false;
                }
            } else {
                if (diff <= f.distance) {
                    return false;
                }
            }
        }
        return true;
    }
}