import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < book_time.length; i++){
            pq.add(new int[] {cal(book_time[i][0]), cal(book_time[i][1])});
        }
        pq1.add(pq.remove());
        while (!pq.isEmpty()){
            int[] temp = pq.remove();
            if (pq1.peek()[1] + 10 <= temp[0]){
                pq1.remove();
            }
            pq1.add(temp);
            answer = Math.max(answer, pq1.size());
        }
        return answer;
    }
    public static int cal(String time){
        String[] temp = time.split(":");
        int res = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        return res;
    }
}