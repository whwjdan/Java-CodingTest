import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int cnt = 0;
        int second = 0;
        int curr_weight = 0;
        boolean button = true;
        int idx = 0;
        // 건너는 중인 트럭
        Queue<Integer> q = new LinkedList<>();
        // 모든 트럭이 건널때 까지
        // 모든 트럭이 올라간 뒤 bridge_length를 더하면 답이다.
        while(true){
                        
            if(idx == truck_weights.length)
                break;
            
            //다리에 트럭이 가득찬 경우 
            if(q.size() == bridge_length){
                curr_weight -= q.poll();
            } 
            // 다리에 공간이 있지만 무게가 가득찼을 때
            else if(curr_weight+truck_weights[idx] > weight){
                second++;
                q.offer(0);
            }
            else{
                q.offer(truck_weights[idx]);
                curr_weight += truck_weights[idx];
                second++;
                idx++;
                }
        }
        
        int answer = second+bridge_length;
        return answer;
    }
}