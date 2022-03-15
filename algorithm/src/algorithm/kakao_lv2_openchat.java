package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kakao_lv2_openchat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arr= {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(arr);
	}
	public static String[] solution(String[] record) {
        Map<String, String > map = new HashMap<String, String>();
	        
	        for(int k = 0 ; k < record.length; k ++) {
	        	String arr[] = record[k].split(" ");
	        	if(arr.length>2) {
	        		map.put(arr[1],   arr[2]) ;
	        		
	        	
	        	}
	        }
	        List <String > a = new ArrayList();
	        for(int k = 0 ; k < record.length; k ++) {
	        	String arr[] = record[k].split(" ");
	        	if(!(arr[0].charAt(0)  == 'C') ) {
	        	arr[0] = arr[0].equals("Enter") ? "들어왔습니다." : "나갔습니다."; 
	        	 a.add(map.get(arr[1])+"님이 "+arr[0]);

	        	}
	        }

	        String [] answer = new String[a.size()];
	        for(int k =0 ; k < a.size(); k ++) {
	        	answer [k] = a.get(k);
	        }
	        return answer;
	}
 }
