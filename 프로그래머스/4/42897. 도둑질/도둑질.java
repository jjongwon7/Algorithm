class Solution {
    public int solution(int[] money) {
        int[] dpO = new int[money.length];
        int[] dpX = new int[money.length];
        
        dpO[0] = money[0];
        dpO[1] = money[0];
        dpX[0] = 0;
        dpX[1] = money[1];
        
        for(int i=2; i<money.length; i++) {
            dpO[i] = Math.max(dpO[i-1], dpO[i-2] + money[i]);
            dpX[i] = Math.max(dpX[i-1], dpX[i-2] + money[i]);
        }
        
        return Math.max(dpO[money.length-2], dpX[money.length-1]);
    }
}