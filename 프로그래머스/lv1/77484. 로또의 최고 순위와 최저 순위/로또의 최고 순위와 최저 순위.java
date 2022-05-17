import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int worst = 0;
        int best = 0;
        int[] winning = {6, 6, 5, 4, 3, 2, 1};
        ArrayList<Integer> lottoList = new ArrayList<>();
        for(int lotto : lottos){
            lottoList.add(lotto);
        }
        for(int win_num : win_nums){
            if(lottoList.contains(win_num)){
                lottoList.remove(Integer.valueOf(win_num));
                //System.out.println("remove is : " + win_num);
                cnt++;
            }
        }
        worst = winning[cnt];
        //System.out.println("worst is : " + worst);
        if(lottoList.size() > 0){
            for(Integer lotto : lottoList){
            System.out.println(lotto);
                if(lotto == 0){
                    cnt++;
                }
            }
        }
        best = winning[cnt];
        //System.out.println("best is : " + best);
        
        int[] answer = {best, worst};
        return answer;
    }
}

// case1 : 0을 일치하는 숫자로
// case2 : 0을 일치하지 않는 번호로

// lottos를 가진 어레이리스트를 만들고 & win_nums에서 있는 숫자를 빼며 당첨번호 카운트 ++
// 0에 관해 아무것도 하지않은 것 = 최저 순위
// 0의 숫자만큼 당첨번호 카운트 ++ ( 당첨으로 가정하기 때문에)

// 등수 : 6%cnt. + 1