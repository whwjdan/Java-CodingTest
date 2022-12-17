import java.util.*;

class Solution {
    boolean [] visited;
    int answer = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean [words.length];
        
        dfs(words, begin, target, 0);
        return answer;
    }
    public void dfs(String[] words, String currWord, String target, int cnt){
        if(currWord.equals(target)){
            answer = cnt;
            return;    
        }
        for(int i=0; i<words.length; i++){
            if(!visited[i] && check(currWord, words[i])){
                visited[i] = true;
                dfs(words, words[i], target, cnt+1);
                visited[i] = false;
            }
        }
    }
    public boolean check(String word1, String word2){
        int cnt = 0;
        for(int i = 0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                cnt++;
            }
        }
        if(cnt != 1){
            return false;
        }
        return true;
    }
}