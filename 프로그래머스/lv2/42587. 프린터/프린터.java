import java.util.*;

class Solution {
    
    Queue<Task> q = new LinkedList<>();
    int answer = 0;
    
    public int solution(int[] priorities, int location) {
        for(int i=0; i<priorities.length; i++){
            q.add(new Task(i, priorities[i]));
        }
        print(location);
        return answer;
    }
    
    void print(int location){
        int cnt = 0;
        while(!q.isEmpty()){
            // 조건 2 : 대기목록에서 중요도 체크
            boolean button = true;
            Task curr = q.poll();
            for(Task t : q){
                if(t.priorities > curr.priorities){
                    button = false;
                    q.offer(curr);
                    break;
                }
            }
            if(button){
                cnt++;
                if(curr.location == location){
                    answer = cnt;
                    break;
                }
                    
            }
        }
    }
    
    
    
}

class Task {
    int location;
    int priorities;
    
    public Task(int location, int priorities){
        this.location = location;
        this.priorities = priorities;
    }
}