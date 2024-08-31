class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] firstO = new int[n];
        int[] firstX = new int[n];
        firstO[1] = firstO[0] = money[0];
        firstX[1] = money[1];
        
        for(int i=2; i<n-1; i++) {
            firstO[i] = Math.max(firstO[i-1], firstO[i-2] + money[i]);
        }
        
        for(int i=2; i<n; i++) {
            firstX[i] = Math.max(firstX[i-1], firstX[i-2] + money[i]);
        }
        
        return Math.max(firstO[n - 2], firstX[n - 1]);
    }
}