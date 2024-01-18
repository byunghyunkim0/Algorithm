class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        boolean[] alpha = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < skip.length(); i++){
            char c = skip.charAt(i);
            alpha[c - 'a'] = true;
        }
        for (int i = 0; i < s.length(); i++){
            int temp = s.charAt(i) - 'a';
            int count = 0;
            while (count != index){
                temp++;
                temp = temp % 26;
                if (alpha[temp]){
                    continue;
                }
                count++;
            }
            sb.append((char)(temp + 'a'));
            
        }
        answer = sb.toString();
        return answer;
    }
}