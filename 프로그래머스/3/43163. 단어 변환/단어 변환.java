import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        wordList.add(begin);
        return bfs(target, wordList);
    }
    
    public int bfs(String target, List<String> wordList) {
        int answer = 0;
        boolean[] visited = new boolean[wordList.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[wordList.size() - 1] = true;
        queue.offer(wordList.size() - 1);
        
        while(!queue.isEmpty()) {
            answer++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int idx = queue.poll();
                
                for(int j=0; j<wordList.size()-1; j++) {
                    if(!visited[j] && isDiffOnlyOneAlphabet(wordList.get(idx), wordList.get(j))) {
                        if(wordList.get(j).equals(target)) {
                            return answer;
                        }
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }
        
        return 0;
    }
    
    public boolean isDiffOnlyOneAlphabet(String begin, String target) {
        int p1 = 0;
        int p2 = 0;
        int diffCnt = 0;
        
        for(int i=0; i<begin.length(); i++) {
            if(begin.charAt(p1) != target.charAt(p2)) {
                diffCnt++;
                
                if(diffCnt > 1) {
                    return false;
                }
            }
            
            p1++;
            p2++;
        }
        
        return true;
    }
}