import java.io.*;
import java.util.*;

class Solution {
    
    static int[] nums;
    
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int size = map.size();
        
        if(size >= n/2) {
            answer = n/2;
        }
        else {
            answer = size;
        }
        
        return answer;
    }
}