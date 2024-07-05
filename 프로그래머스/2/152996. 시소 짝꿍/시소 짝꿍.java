class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] people = new int[4001];
        for (int i = 0; i < weights.length; i++) {
            people[weights[i]]++;
        }
        for (int i = 100; i <= 1000; i++) {
            if (people[i] != 0) {
                answer += (long)people[i] * (people[i] - 1) / 2;
                answer += (long)people[i] * people[i * 2];
                if (i % 3 == 0) {
                    answer += (long)people[i] * people[i * 4 / 3];
                }
                if (i % 2 == 0) {
                    answer += (long)people[i] * people[i * 3 / 2];
                }
            }
        }
        return answer;
    }
}
