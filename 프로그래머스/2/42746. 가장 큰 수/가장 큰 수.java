import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i=0; i < arr.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                //return (s2+s1).compareTo(s1+s2);
                return Integer.parseInt(s2+s1)-Integer.parseInt(s1+s2);
            }
        });
        // 3, 30 ->   303 compareTo 330 -> 음수 그대로
        // 30, 3 -> 330 compareTo 303 -> 양수 바꿈 3 30 
        if(arr[0].equals("0"))
            return "0";
        
        for(String s : arr){
            answer += s;
        }
        
        return answer;
    }
}