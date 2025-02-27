class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int limit = getTime(schedules[i]);
            if (check(i, limit, timelogs, startday - 1)) {
                continue;
            }
            answer++;
        }
        
        return answer;
    }
    
    static boolean check(int idx, int limit, int[][] timelogs, int startday) {
        for (int i = 0; i < 7; i++) {
            if (startday > 4) {
                startday++;
                startday %= 7;
                continue;
            }
            if (timelogs[idx][i] > limit) {
                return true;
            }
            startday++;
            startday %= 7;
        }
        return false;
    }
    
    static int getTime(int time) {
        if (time % 100 >= 50) {
            return time + 50;
        }
        return time + 10;
    }
}