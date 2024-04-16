import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        // map을 만들어서 yellow_hat의 경우
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        int sum = 1;
        for(String key : map.keySet()) {
            sum *= (map.get(key) + 1);
        }
        
        sum -= 1;
        
        return sum;
    }
}