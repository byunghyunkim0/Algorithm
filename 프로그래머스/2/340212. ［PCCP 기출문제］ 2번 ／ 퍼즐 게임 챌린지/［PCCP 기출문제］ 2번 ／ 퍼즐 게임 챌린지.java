class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int s = 1;
        int e = 100000;
        int mid;
        
        while (s <= e) {
            mid = (s + e) / 2;
            if (check(diffs, times, limit, mid)) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        answer = s;
        return answer;
    }
    
    static boolean check(int[] diff, int[] time, long limit, int mid) {
        long times = 0L;
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] <= mid) {
                times += time[i];
            } else {
                if (i == 0) {
                    times += (diff[i] - mid) * time[i] + time[i];
                } else {
                    times += (diff[i] - mid) * (time[i] + time[i - 1]) + time[i]; 
                }
            }
        }
        if (times <= limit) {
            return true;
        }
        return false;
    }
}