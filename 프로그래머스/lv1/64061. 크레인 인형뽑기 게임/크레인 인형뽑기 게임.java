import java.util.*;

class Solution {
    
    Stack <Integer> baguni = new Stack<>();
    
    static int answer = 0;
    public int solution(int[][] board, int[] moves) {
        for(int move: moves){
            System.out.println("move : "+ (move-1));
            //board[move-1] = moving(board[move-1]);
            //moving(boards[move-1]);
            for(int j=0; j<board.length; j++){
                if(board[j][move-1] != 0){
                    
                    if(!baguni.empty() && baguni.peek() == board[j][move-1]){
                        answer+=2;
                        baguni.pop();
                    } else{
                        baguni.push(board[j][move-1]);    
                    }
                    
                    board[j][move-1] = 0;
                    break;
                }
                    
            }
        }
        return answer;
    }
    
    
}

/**
n by n 크기
아래부터 쌓임
바구니는 따로
같은인형 2개는 터진다
**/