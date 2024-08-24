import java.util.*;

class Solution {
    
    static Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
    static List<String> ansList = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        for(String[] ticket : tickets) {
            fromToMap.putIfAbsent(ticket[0], new PriorityQueue<>());
            fromToMap.get(ticket[0]).add(ticket[1]);
        }
        
        dfs("ICN");
        
        return ansList.toArray(new String[ansList.size()]);
    }
    
    public void dfs(String from) {
        while(fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            String to = fromToMap.get(from).poll();
            dfs(to);
        }
        
        ansList.add(0, from);
    }
}