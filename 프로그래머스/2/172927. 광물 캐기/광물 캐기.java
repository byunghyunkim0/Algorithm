import java.util.*;

class Solution {
    static class Count {
        int dCount;
        int iCount;
        int sCount;
        public Count(int dCount, int iCount, int sCount) {
            this.dCount = dCount;
            this.iCount = iCount;
            this.sCount = sCount;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int iCount = 0;
        int sCount = 0;
        int dCount = 0;
        List<Count> list = new ArrayList<>();
        int size = picks[0] + picks[1] + picks[2];
        for (int i = 0; i < Math.min(minerals.length, 5 * size); i++) {
            if (minerals[i].length() == 7) {
                iCount += 5;
                sCount += 25;
            } else if (minerals[i].length() == 4) {
                iCount++;
                sCount += 5;
            } else {
                iCount++;
                sCount++;
            }
            dCount++;
            if (i % 5 == 4) {
                list.add(new Count(dCount, iCount, sCount));
                dCount = 0;
                iCount = 0;
                sCount = 0;
            }
        }
        if (dCount != 0) {
            list.add(new Count(dCount, iCount, sCount));
        }
        
        list.sort((o1, o2) -> {
            if (o1.sCount == o2.sCount) {
                if (o1.iCount == o2.iCount) {
                    return o1.dCount - o2.dCount;
                }
                return o2.iCount - o1.iCount;
            }
            return o2.sCount - o1.sCount;
        });
        for (Count c : list) {
            if (picks[0] != 0) {
                picks[0]--;
                answer += c.dCount;
                continue;
            }
            if (picks[1] != 0) {
                picks[1]--;
                answer += c.iCount;
                continue;
            }
            answer += c.sCount;
        }
        return answer;
    }
}