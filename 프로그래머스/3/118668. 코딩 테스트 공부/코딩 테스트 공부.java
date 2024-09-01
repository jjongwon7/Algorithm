import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        Algorithm[] algorithms = new Algorithm[problems.length + 2];

        algorithms[0] = new Algorithm(0, 0, 1, 0, 1); // 알고리즘 공부
        algorithms[1] = new Algorithm(0, 0, 0, 1, 1); // 코딩 공부

        int idx = 2;
        int maxAlpReq = Integer.MIN_VALUE;
        int maxCopReq = Integer.MIN_VALUE;

        for(int[] problem : problems) {
            algorithms[idx++] = new Algorithm(problem[0], problem[1], problem[2], problem[3], problem[4]);
            maxAlpReq = Math.max(maxAlpReq, problem[0]);
            maxCopReq = Math.max(maxCopReq, problem[1]);
        }
        
        if(alp >= maxAlpReq && cop >= maxCopReq) return 0;
        
        alp = Math.min(alp, maxAlpReq);
        cop = Math.min(cop, maxCopReq);

        // row: alp, col: cop, value: time
        int[][] mem = new int[maxAlpReq + 1][maxCopReq + 1];
        for(int i=alp;i<=maxAlpReq; i++){
            for(int j=cop;j<=maxCopReq; j++){
                mem[i][j] = Integer.MAX_VALUE;
            }
        }

        mem[alp][cop] = 0;
        
        for (int curAlp = alp; curAlp <= maxAlpReq; curAlp++) {
            for (int curCop = cop; curCop <= maxCopReq; curCop++) {
                for (Algorithm algorithm : algorithms) {
                    if (curAlp < algorithm.alp_req || curCop < algorithm.cop_req) continue;
                    
                    int afterAlp = curAlp + algorithm.alp_rwd;
                    int afterCop = curCop + algorithm.cop_rwd;
                    
                    afterAlp = Math.min(afterAlp, maxAlpReq);
                    afterCop = Math.min(afterCop, maxCopReq);
                    
                    mem[afterAlp][afterCop] = Math.min(mem[afterAlp][afterCop], mem[curAlp][curCop] + algorithm.cost);
                }
            }
        }

        return mem[maxAlpReq][maxCopReq];
    }

    static class Algorithm {
        int alp_req;
        int cop_req;
        int alp_rwd;
        int cop_rwd;
        int cost;

        public Algorithm(int alp_req, int cop_req, int alp_rwd, int cop_rwd, int cost) {
            this.alp_req = alp_req;
            this.cop_req = cop_req;
            this.alp_rwd = alp_rwd;
            this.cop_rwd = cop_rwd;
            this.cost = cost;
        }
    }
}