import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] cnt = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            if(p1[i % 5] == answers[i]) cnt[0]++;
            if(p2[i % 8] == answers[i]) cnt[1]++;
            if(p3[i % 10] == answers[i]) cnt[2]++;
        }
        
        int max = 0;
        
        for(int i=0; i<3; i++) {
            max = Math.max(max, cnt[i]);
        }
        
        ArrayList<Integer> ansList = new ArrayList<>();
        
        for(int i=0; i<3; i++) {
            if(max == cnt[i]) ansList.add(i+1);
        }
        
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}