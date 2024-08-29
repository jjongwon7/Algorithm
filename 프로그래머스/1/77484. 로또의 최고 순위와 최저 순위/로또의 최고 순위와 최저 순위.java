import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winSet = new HashSet<>();
        
        for(int win_num : win_nums) {
            winSet.add(win_num);
        }
        
        int matchedCnt = 0;
        int unknownCnt = 0;
        for(int lotto : lottos) {
            if(lotto == 0) {
                unknownCnt++;
            } else if(winSet.contains(lotto)) {
                matchedCnt++;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = 7 - (matchedCnt + unknownCnt);
        answer[1] = 7 - matchedCnt;
        
        answer[0] = answer[0] > 6 ? 6 : answer[0];
        answer[1] = answer[1] > 6 ? 6 : answer[1];
        
        return answer;
    }
}