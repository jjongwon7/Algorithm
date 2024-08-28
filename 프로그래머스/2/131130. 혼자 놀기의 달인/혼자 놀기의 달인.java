import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        for(int i=0; i<cards.length; i++) {
            int[] box1 = Arrays.copyOf(cards, cards.length);
            int cur = i;
            int box1Size = 0;
            int score = 0;
            
            while(box1[cur] != -1) {
                int next = box1[cur] - 1;
                box1[cur] = -1;
                cur = next;
                box1Size++;
            }
            
            for(int j=0; j<cards.length; j++) {
                int[] box2 = Arrays.copyOf(box1, box1.length);
                cur = j;
                int box2Size = 0;
                if(box2[cur] == -1) {
                    continue;
                }
                
                while(box2[cur] != -1) {
                    int next = box2[cur] - 1;
                    box2[cur] = -1;
                    cur = next;
                    box2Size++;
                }
                
                score = Math.max(score, box1Size * box2Size);
            }
            
            answer = Math.max(answer, score);
        }
        
        return answer;
    }
}