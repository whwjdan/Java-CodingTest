import java.util.*;

class Solution {
    
    ArrayList<YellowCapet> yellowList = new ArrayList<>();
    ArrayList<Capet> totalList = new ArrayList<>();
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        input(yellow, brown + yellow);
        
        for(YellowCapet yellowCapet : yellowList){
            System.out.println("yellow " + yellowCapet.width + " " + yellowCapet.row);
        }
        
        for(int i=0; i<yellowList.size(); i++){
            for(int j=0; j<totalList.size(); j++){
                if(yellowList.get(i).width + 2 == totalList.get(j).width && 
                   yellowList.get(i).row + 2 == totalList.get(j).row){
                    return new int [] {totalList.get(j).width, totalList.get(j).row};
                }
            }
        }
        
        
        
        
        return answer;
    }
    
    // 노랑 카펫의 가로 세로의 경우의 수와 전체 카펫 가로세로의 경우의 수를 입력
    void input(int yellow, int total){
        for(int i =1; i<=yellow; i++){
            if(yellow % i == 0){
                int width = i;
                int row = yellow / i;
                yellowList.add(new YellowCapet(width, row));
            }
        }
        for(int i =1; i<=total; i++){
            if(total % i == 0){
                int width = i;
                int row = total / i;
                if(width >= row)
                    totalList.add(new Capet(width, row));
            }
        }
    }
}

class YellowCapet{
    int width;
    int row;
    YellowCapet(int width, int row){
        this.width = width;
        this.row = row;
    }
}

class Capet{
    int width;
    int row;
    Capet(int width, int row){
        this.width = width;
        this.row = row;
    }
}