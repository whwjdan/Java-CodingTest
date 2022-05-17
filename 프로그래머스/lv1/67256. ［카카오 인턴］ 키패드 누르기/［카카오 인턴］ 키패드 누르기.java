class Solution {
    
    // 번호를 누른 후 새롭게 누른 번호의 좌표를 반환
    public int [] find_idx(int number, int [][] keyPads){
        int [] return_val = new int[2];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(number == 0){
                    return_val[0] = 3;
                    return_val[1] = 1;
                }
                else if(number == keyPads[i][j]){
                    return_val[0] = i;
                    return_val[1] = j;
                }
            }
        }
        return return_val;
    }
    // 규칙 4의 경우 거리를 측정후 누르는 숫자를 리턴
    public String find_distance(int [] l_idx, int [] r_idx, int [] p_idx ,int number){
        int l_distance = Math.abs(p_idx[0]-l_idx[0]) + Math.abs(p_idx[1]-l_idx[1]);
        int r_distance = Math.abs(p_idx[0]-r_idx[0]) + Math.abs(p_idx[1]-r_idx[1]);

        if(l_distance < r_distance){
            return "L";
        } else if(l_distance > r_distance){
            return "R";
        } else{
            return "E";
        }   
    }
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        //String [][] keyPads = {{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*","0","#"}};
        // 10 : *  /  11 : #
        int [][] keyPads = {{1,2,3},{4,5,6},{7,8,9},{10,0,11}};
        // l_idx = 왼손가락의 좌표, r_idx = 오른손가락의 좌표, p_idx = 눌러야 할 숫자의 좌표
        int [] l_idx = {3,0};
        int [] r_idx = {3,2};
        int [] p_idx = {0,0};
        
        for(int number : numbers){
            if(number == 1 || number == 4 || number ==7){
                answer+=("L");
                l_idx = find_idx(number, keyPads);
            } else if(number == 3 || number == 6 || number == 9){
                answer+=("R");
                r_idx = find_idx(number, keyPads);
            } else {
                p_idx = find_idx(number, keyPads);
                String dist = find_distance(l_idx, r_idx, p_idx, number);
                if(dist == "E"){
                    if(hand.equals("left")){
                        answer+=("L");
                        l_idx = p_idx;
                    } else if(hand.equals("right")){
                        answer+=("R");
                        r_idx = p_idx;
                    }
                } else if(dist == "L"){
                    answer+=("L");
                    l_idx = p_idx;
                } else{
                    answer+=("R");
                    r_idx = p_idx;
                }
            }
        }
        return answer;
    }
}