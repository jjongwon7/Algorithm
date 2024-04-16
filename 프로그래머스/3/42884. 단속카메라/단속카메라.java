import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        CarPath[] carPaths = new CarPath[routes.length];
        
        for(int i=0; i<routes.length; i++) {
            carPaths[i] = new CarPath(routes[i][0], routes[i][1]);
        }
        
        Arrays.sort(carPaths);
        
        int cameraPoint = -30001;
        
        for(CarPath carPath : carPaths) {
            if(cameraPoint < carPath.in) {
                cameraPoint = carPath.out;
                answer++;
            }
        }
        
        return answer;
    }
    
    static class CarPath implements Comparable<CarPath> {
        int in;
        int out;
            
        public CarPath(int in, int out) {
            this.in = in;
            this.out = out;
        }
        
        @Override
        public int compareTo(CarPath c) {
            return this.out - c.out;
        }
    }
}