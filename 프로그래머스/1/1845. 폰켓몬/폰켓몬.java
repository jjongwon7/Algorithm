import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        if(map.size() >= nums.length/2) {
            return nums.length/2;
        }
        else {
            return map.size();
        }
    }
}