import java.util.*;

class Solution {
    ArrayList<String> arr = new ArrayList<>();
    boolean [] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        String[] answer = {};
        
        dfs("ICN", tickets, "ICN", 0);
        Collections.sort(arr);
        
        return arr.get(0).split(" ");
    }
    public void dfs(String currTicket, String[][] tickets, String route, int cnt){
        if(cnt == tickets.length){
            arr.add(route);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(currTicket)){
                visited[i] = true;
                dfs(tickets[i][1], tickets, route + " " + tickets[i][1], cnt + 1);
                visited[i] = false;
            }
        }
    }
}