import java.util.*;

class Solution {
    public int[] solution(String[] id_lists, String[] reports, int k) {
        int[] answer = new int [id_lists.length];
        // 중복 제거된 리스트  
        Map <String, Integer> conflicts = new HashMap<String, Integer>();
        // 중복 제거 후 신고된 이름과 횟수
        Map <String, Integer> reportedMembers = new HashMap<String, Integer>();
        // 정지된 사람들 데이터
        ArrayList<String> rejectMembers = new ArrayList<String>();
        // id_lists를 맵으로
        Map <String, Integer> idListMap = new LinkedHashMap<String, Integer>();
        
        //idListMap에 데이터 넣기
        for(String idLst: id_lists){
            idListMap.put(idLst,0);
        }
        
        //report에서 중복제거하기 Map으로
        for(String report : reports){
            conflicts.put(report,0);
        }
        // 중복 제거
        //System.out.println("중복 제거 데이터 : "+conflicts);
        
        for(String conflict : conflicts.keySet()){
            String[] strList = conflict.split(" ");
            String reportedMem = strList[1];
            if(reportedMembers.get(reportedMem) == null){
                reportedMembers.put(reportedMem, 1);
            }else{
                reportedMembers.put(reportedMem, reportedMembers.get(reportedMem)+1);
            }
        }
        
        //System.out.println("신고된 사람들 : "+ reportedMembers);
        //신고 된 사람들을 순회하면서 정지된 사람들 추가하기
        for(String reportedMember: reportedMembers.keySet()){
            if(reportedMembers.get(reportedMember) >= k){
                rejectMembers.add(reportedMember);
            }
        }
        
        //System.out.println("정지된 사람들 : "+ rejectMembers);
        
        // 중복 제거 데이터를 순회하면서 [0](신고한사람)이 [1](신고당한사람)(rejectMembers)라면 
        // idListMap에 데이터 추가
        for(String conflict : conflicts.keySet()){
            String[] strList = conflict.split(" ");
            String reportMem = strList[0];
            String reportedMem = strList[1];
            if(rejectMembers.contains(reportedMem)){
                idListMap.put(reportMem, idListMap.get(reportMem)+1);
                
            }
        }
        //System.out.println(idListMap);
        int i = 0;
        for(String idList : idListMap.keySet()){
            answer[i] = idListMap.get(idList);
            i++;
        }
        return answer;
    }
}