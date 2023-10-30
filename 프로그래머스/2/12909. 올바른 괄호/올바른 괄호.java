import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            // 현재 str이 ( 가 아닐 때 비어있다면 올바르지않음 " ) "
            if(s.charAt(i)=='(') {
                stack.push('(');
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        // 전체 과정을 수행했을 때 스택에 ( 가 남아있다면 false ()()( 의 형태
        return (stack.isEmpty()) ? true : false;
    }
}