import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];

        ArrayList<Integer> list = new ArrayList<>();
        for(int num : numlist)
            list.add(num);
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                int gap1 = Math.abs(num1 - n);
                int gap2 = Math.abs(num2 - n);
                if(gap1 == gap2) {
                    return num2 - num1;
                }
                return gap1 - gap2;
            }
        });

        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}