import java.util.*;

class Solution {
    static int[] parents;
    static HashMap<String, Integer> index = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        parents = new int[n];
        
        for (int i = 0; i < n; i++) {
            index.put(enroll[i], i);
            if (referral[i].equals("-")) {
                parents[i] = -1;
            } else {
                parents[i] = index.get(referral[i]);
            }
        }
        
        for (int i = 0; i < seller.length; i++) {
            getMoney(answer, seller[i], amount[i]);
        }
        
        return answer;
    }
    
    static void getMoney(int[] answer, String seller, int amount) {
        int m = amount * 100;
        int cur = index.get(seller);
        while (true) {
            if (m < 10) {
                answer[cur] += m;
                break;
            } else {
                answer[cur] += m - (m / 10);
            }
            m /= 10;
            cur = parents[cur];
            if (m == 0 || cur == -1) {
                break;
            }
        }
    }
}