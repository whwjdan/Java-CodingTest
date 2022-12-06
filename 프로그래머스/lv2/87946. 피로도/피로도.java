import java.util.*;

class Solution {
    
    static boolean [] visited;
    int answer = 0;
    static int cnt = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean [dungeons.length];
        permutation(k, dungeons, 0);
        return answer;
    }
    
    public void permutation(int piro, int[][] dungeons, int depth){
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && piro >= dungeons[i][0]){
                visited[i] = true;
                //System.out.println("현재 피로도는 " + piro);
                //System.out.println("최소 피로도는 " + dungeons[i][0]);
                //System.out.println("방문 피로도는 " + dungeons[i][1]);
                //System.out.println("줄어든 현재 피로도는 " + piro);
                //System.out.println("i는 " + i + " depth는 " + depth);
                permutation(piro - dungeons[i][1], dungeons, depth+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
        //System.out.println("증가한 현재 피로도는 " + piro);
    }
}