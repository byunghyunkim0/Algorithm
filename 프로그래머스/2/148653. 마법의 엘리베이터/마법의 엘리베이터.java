class Solution {
    public int solution(int storey) {
        int count = 0;
        while (storey != 0){
            if (storey % 10 > 5){
                count += 10 - (storey % 10);
                storey = storey / 10 + 1;
            } else if (storey % 10 < 5){
                count += storey % 10;
                storey = storey / 10;
            } else {
                if ((storey / 10) % 10 > 4){
                    count += storey % 10;
                    storey = storey / 10 + 1;
                } else {
                    count += storey % 10;
                    storey = storey /10;
                }
            }
        }
        return count;
    }
}