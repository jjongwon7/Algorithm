import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        // 바위 2개를 제거해서 가장 큰 길이로 배치하시오.
        
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        answer = distance; // 모든 바위를 삭제하는 경우 대비
        
        while(left <= right) {
            int mid = (left + right) / 2;
            boolean isPossible = false;
            int front = 0; // 시작점: 0으로 초기화
            int rockCnt = 0;
            for(int i=0; i<rocks.length; i++) {
                int back = rocks[i];
                
                // 현재 mid 길이보다 크거나 같으면 만족하는 것이므로, 돌을 설치
                if(back - front >= mid) {
                    rockCnt++;
                    front = back;
                    
                    // 조건을 만족하는 경우
                    if(rockCnt == rocks.length - n) {
                        // 마지막 설치한 돌과 목표지점 사이의 거리도 고려
                        back = distance;
                        if(back - front >= mid) {
                            left = mid + 1;
                            answer = mid;
                            isPossible = true;
                        }
                        break;
                    }
                }
            }
            
            if(!isPossible) right = mid - 1;
        }
        
        
        return answer;
    }
}