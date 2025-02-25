class Solution {
    public int solution(int[] wallet, int[] bill) {
        int wMax = Math.max(wallet[0], wallet[1]);
        int wMin = Math.min(wallet[0], wallet[1]);
        
        int bMax = Math.max(bill[0], bill[1]);
        int bMin = Math.min(bill[0], bill[1]);
        
        int answer = 0;
        while (true) {
            if (wMax >= bMax && wMin >= bMin) {
                break;
            }
            bMax /= 2;
            if (bMax < bMin) {
                int temp = bMin;
                bMin = bMax;
                bMax = temp;
            }
            answer++;
        }
        return answer;
    }
}