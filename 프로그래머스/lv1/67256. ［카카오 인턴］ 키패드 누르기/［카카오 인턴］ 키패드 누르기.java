class Solution {
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
    
    public String find_distance(int [] l_idx, int [] r_idx, int [] p_idx ,int number){
        int l_distance = Math.abs(p_idx[0]-l_idx[0]) + Math.abs(p_idx[1]-l_idx[1]);
        int r_distance = Math.abs(p_idx[0]-r_idx[0]) + Math.abs(p_idx[1]-r_idx[1]);
        System.out.println("find_distance");
        System.out.println(l_distance);
        System.out.println(r_distance);
        System.out.println("--------");
        System.out.println(p_idx[0]);
        System.out.println(p_idx[1]);
        System.out.println("p--------");
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
        int [] l_idx = {3,0};
        int [] r_idx = {3,2};
        int [] p_idx = {0,0};
        System.out.println("ddddddddd");
        System.out.println(find_idx(0, keyPads)[0]);
        for(int number : numbers){
            if(number == 1 || number == 4 || number ==7){
                answer+=("L");
                l_idx = find_idx(number, keyPads);
                System.out.println("77777777");
            } else if(number == 3 || number == 6 || number == 9){
                answer+=("R");
                r_idx = find_idx(number, keyPads);
                //System.out.println(r_idx[1]);
            } else {
                System.out.println("0000000");
                p_idx = find_idx(number, keyPads);
                String dist = find_distance(l_idx, r_idx, p_idx, number);
                System.out.println(dist);
                if(dist == "E"){
                    if(hand.equals("left")){
                        System.out.println("LLLLL");
                        answer+=("L");
                        l_idx = p_idx;
                    } else if(hand.equals("right")){
                        System.out.println("RRRRR");
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