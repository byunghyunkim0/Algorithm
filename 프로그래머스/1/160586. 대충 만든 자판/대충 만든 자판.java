class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] alpha = new int[26];
        for (int i = 0; i < alpha.length; i++){
            alpha[i] = 101;
        }
        for (int i = 0; i < keymap.length; i++){
            String temp = keymap[i];
            for (int j = 0; j < temp.length(); j++){
                char c = temp.charAt(j);
                if (alpha[c - 'A'] > j){
                    alpha[c - 'A'] = j;
                }
            }
        }
        for (int i = 0; i < targets.length; i++){
            String temp = targets[i];
            for (int j = 0; j < temp.length(); j++){
                char c = temp.charAt(j);
                if (alpha[c - 'A'] > 100){
                    answer[i] = -1;
                    break;
                }
                answer[i] += alpha[c - 'A'] + 1;
            }
        }
        return answer;
    }
}