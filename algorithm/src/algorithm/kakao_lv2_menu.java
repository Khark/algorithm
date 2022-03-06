package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class kakao_lv2_menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []arr = {"ABCD", "ABCD", "ABCD"};
		int []course = {2,3,4};
		System.out.println("##"+solution(arr, course));
		//'AB', 'ABC', 'ABCD', 'ABD', 'AC', 'ACD', 'AD', 'BC', 'BCD', 'BD', 'CD'
	}
    private static HashMap<String, Integer> comMap = new HashMap<String, Integer>();
    private static StringBuilder sb = new StringBuilder();
    public static String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            boolean[] visited = new boolean[charArr.length];
            Arrays.sort(charArr);
            for (int j = 0; j < course.length; j++) {

                if(charArr.length>=course[j]) {
                    dfs(charArr, visited, 0, charArr.length, course[j], course[j]);
                	//combination(charArr, visited, 0  ,charArr.length, course[j]);
                }
            }
        }
    	List<String> list = new  ArrayList<String>();
    	int maxcount=0;
    
    	for(int i = 0 ; i < course.length; i ++) {
    		maxcount = 0;
        	Iterator<String > it = comMap.keySet().iterator();
        	Iterator<String > it2 = comMap.keySet().iterator();

    		while(it.hasNext()) {
    			String key = it.next();
    			if(comMap.get(key) > 1  &&  key.length() == course[i] ) {
    				if(maxcount == 0 ) {
    	    			maxcount  = comMap.get(key);
        			}else {
   	    				 if(maxcount < comMap.get(key)) {
   	    					maxcount  = comMap.get(key);
    	    			}
    	    		}
    	    	}
    		}
    		while(it2.hasNext()) {
    			String key = it2.next();
    			if(comMap.get(key) > 1 && key.length() == course[i] && comMap.get(key) == maxcount) {
    				list.add(key);
    			}
    		}
    	}

        String[] answer = list.toArray(new String[list.size()]);
        Collections.sort(list);


    	for(String a  : answer) {
    		System.out.println("#"+a);
    	}
    	
    	// 'AB', 'ABC', 'ABCD', 'ABD', 'AC', 'ACD', 'AD', 'BC', 'BCD', 'BD', 'CD'
    	return answer;
    }

    
    
    public static void dfs(char [] obj, boolean [] visited, int start, int end, int course ,int course2) {
    	if(course == 0 ) {
    		push(obj , visited, end, course2);
    		return;
    	}
    	for(int i = start ; i < end; i ++) {
    		
    		visited[i] = true;
    		dfs(obj, visited, i +1 , end , course -1, course2);
    		visited[i] = false;
    		
    	}
    }
     public static void push(char [] obj, boolean [] visited , int end, int course) {

   // public static void push(char [] obj, boolean [] visited , int end) {
    	sb.setLength(0);
    	
    	for(int i = 0 ; i < end ; i ++) {
    		if(visited[i]) {
    			sb.append(obj[i]);
    		}
    	}

    	char [] temp = sb.toString().toCharArray();
    	Arrays.sort(temp);
    		String temp2 = new String(temp);
    		comMap.put(temp2, comMap.getOrDefault(temp2, 0) +1);
    }
    
//	public static String[] solution(String[] orders, int[] course) {
//        String[] answer = {};
//        //모든 경우의 수를 가져와야할듯.. dfs로?
//
//        
//        for(int i = 0 ; i < orders.length; i ++) {
//        	// 모든 배열의 조합을 다 가져와봄 
//        	// 그런다음 모든 조합을 해쉬에 넣는데 있으면 +1 로 해주는 
//        	char[] obj = orders[i].toCharArray();
//        	boolean []visited = new boolean[obj.length];
//        	//dfs(obj )
//        	for(int j = 0 ; j < course.length; j ++) {
//        		dfs(obj, visited, 0, obj.length, obj[0]);
//        	}
//        	
//        }
//        return answer;
//    }
//	
//	public static void dfs(char [] obj, boolean [] visited, int start, int end , int course  ) {
//		
//		if(course == 0) {
//			push(obj, visited, end);
//		}else {
//			for(int i = 0 ; i < end; i ++) {
//				visited[i]= true;
//				dfs(obj, visited, start + 1, end, course - 1);
//				visited[i]= false;
//			}
//
//		}
//	}
//	
//	public static void push(char[]obj, boolean [] visited, int n ) {
//		sb.setLength(0);
//		  for (int i = 0; i < n; i++) {
//	            if (visited[i]) {
//	                sb.append(obj[i]);
//	            }
//	        }
//	        char[] set = sb.toString().toCharArray();
//	        Arrays.sort(set);
//
//	        String str = new String(set);
//
//	        if(!comMap.containsKey(str)) {
//	        	comMap.put(str, 1);
//	        } else {
//	            int num = comMap.get(str);
//	            comMap.put(str, num+=1);
//	        }
//	}
	
}
