class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int c = 0;
        int time = 0;
        int index = 0;
        while (time <= attacks[attacks.length - 1][0]) {
            if (time == attacks[index][0]) {
                answer = Math.max(0, answer - attacks[index][1]);
                index++;
                c = 0;
            } else {
                answer = Math.min(health, answer + bandage[1]);
                c++;
            }
            if (c == bandage[0]) {
                c = 0;
                answer = Math.min(health, answer + bandage[2]);
            }
            if (answer == 0) {
                break;
            }
            time++;
        }
        if (answer == 0) {
            answer = -1;
        }
        return answer;
    }
}