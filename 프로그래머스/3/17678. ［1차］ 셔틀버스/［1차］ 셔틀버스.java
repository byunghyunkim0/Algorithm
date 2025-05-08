import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        List<Integer> times = new ArrayList<>();
        for (int i = 0; i < timetable.length; i++) {
            times.add(getTime(timetable[i]));
        }
        times.sort(Comparator.comparingInt(o -> o));
        
        int idx = 0;
        int count = 0;
        int temp = 0;
        for (int i = 540; i < 540 + n * t; i += t) {
            temp = count;
            while (idx < times.size()) {
                if (times.get(idx) <= i) {
                    temp++;
                    idx++;
                } else {
                    break;
                }
            }
            count = Math.max(0, temp - m);
        }
        if (temp < m) {
            answer = getTime(540 + (n - 1) * t);
        } else {
            answer = getTime(times.get(idx - 1 - count) - 1);
        }
        
        return answer;
    }
    
    static String getTime(int time) {
        int hh = time / 60;
        int mm = time % 60;
        String h = "";
        String m = "";
        if (hh < 10) {
            h = "0" + hh;
        } else {
            h = String.valueOf(hh);
        }
        if (mm < 10) {
            m = "0" + mm;
        } else {
            m = String.valueOf(mm);
        }
        return h + ":" + m;
    }
    
    static int getTime(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}