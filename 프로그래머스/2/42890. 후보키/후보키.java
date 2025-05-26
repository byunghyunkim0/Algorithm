import java.util.*;

class Solution {
    static List<Integer> keys = new ArrayList<>();
    static int n;
    static int m;
    public int solution(String[][] relation) {
        n = relation.length;
        m = relation[0].length;
        for (int key = 1; key < (1 << m); key++) {
            if (check(key)) {
                continue;
            }
            if (unique(key, relation)) {
                keys.add(key);
            }
        }
        return keys.size();
    }
    
    static boolean unique(int key, String[][] relation) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 0; j < m; j++) {
                if ((key & (1 << j)) != 0) {
                    temp += relation[i][j] + " ";
                }
            }
            
            if (set.contains(temp)) {
                return false;
            }
            set.add(temp);
        }
        return true;
    }
    
    static boolean check(int key) {
        for (int k : keys) {
            if ((k & key) == k) {
                return true;
            }
        }
        return false;
    }
}