import java.util.*;

class Solution {
    static class Time {
        int startTime;
        int endTime;
        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public int solution(String[] lines) {
        int answer = 0;
        List<Time> times = new ArrayList<>();
        for (String line : lines) {
            String[] temp = line.split(" ");
            int end = getTime(temp[1].split("[:.]"));
            int start = end - (int)(Double.parseDouble(temp[2].substring(0, temp[2].length() - 1)) * 1000) + 1;
            times.add(new Time(start, end));
        }
        
        for (int i = 0; i < times.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < times.size(); j++) {
                if (times.get(i).endTime + 1000 > times.get(j).startTime) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
    
    static int getTime(String[] times) {
        int res = Integer.parseInt(times[0]);
        res *= 60;
        res += Integer.parseInt(times[1]);
        res *= 60;
        res += Integer.parseInt(times[2]);
        res *= 1000;
        res += Integer.parseInt(times[3]);
        return res;
    }
}