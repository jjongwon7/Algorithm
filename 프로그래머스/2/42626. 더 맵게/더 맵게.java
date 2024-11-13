import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        for(int value : scoville) {
            pQ.offer(value);
        }
        
        while(!pQ.isEmpty()) {
            int minValue = pQ.poll();

            if(minValue >= K) {
                return answer;
            }

            if(pQ.isEmpty()) {
                return -1;
            }

            int nextMinValue = pQ.poll();

            pQ.offer(minValue + nextMinValue * 2);
            answer++;
        }
        
        return answer;
    }
}