import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int maxValue = 0;
        
        for(int citation : citations) {
            maxValue = Math.max(maxValue, citation);
        }
        
        Arrays.sort(citations);
        
        for(int hIdx=0; hIdx<maxValue; hIdx++) {
            int cnt = 0;
            for(int i=citations.length-1; i>=0; i--) {
                if(citations[i] >= hIdx) {
                    cnt++;
                }
                else {
                    break;
                }
            }
            if(cnt >= hIdx) {
                answer = hIdx;
            }
            else {
                break;
            }
        }
        
        return answer;
    }
}