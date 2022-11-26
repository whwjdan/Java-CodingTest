import java.util.*;

// 이중 for문으로 구현시 시간복잡도 = O(N^2)이므로 100억 -> 시간제한이 1초인 경우 최악의 경우 시간 초과
// 스택으로 구현시 O(N)
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Stack <Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // 가격이 떨어졌을 때만 스택에서 제외
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // i : 현재 주식이 감소한 시점, stack.peek() : 주식에 처음 들어간 시점
                answer[stack.peek()] = i - stack.peek();
                stack.pop(); // 답을 구했기 때문에 stack에서 제거한다
            }
            // stack에 prices의 인덱스가 하나씩 넣어짐 
            // for문에서 i와 스택의 값들은 인덱스임과 동시에 시간값이 된다.
            stack.push(i);
        }

        while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        
        
        return answer;
    }
}