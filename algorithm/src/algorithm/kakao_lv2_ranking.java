package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class kakao_lv2_ranking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		
		
		String[] query = { 
				"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", 
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", 
				"- and - and - and chicken 100",
				"- and - and - and - 150"
				
		};

		// 1,1,1,1,2,4
		System.out.println("##" + solution(info, query));
	}

	public static int[] solution(String[] info, String[] query) {
		 
		String [][] info2 = new String[info.length][5];
		int i =0;
		for(String a : info) {
			String temp[] =a.split(" ");
			info2[i]= temp;
			i ++;
		}
		
		int answer [] =Arrays.stream(query).mapToInt(value -> {
			String []arr = value.replace(" and", "").split(" ");
			return (int) Arrays.stream(info2).filter(t ->{
				if(Integer.parseInt(t[4]) >= Integer.parseInt(arr[4])){

					if(arr[0].equals(arr[1]) && arr[0].equals(arr[2]) && arr[0].equals(arr[2]) && arr[0].equals(arr[3]) ) {
						
						return true;

					}else {
						if( (arr[0].equals(t[0])  || arr[0].equals("-"))&& 
							(arr[1].equals(t[1])  || arr[1].equals("-"))&& 
						    (arr[2].equals(t[2])  || arr[2].equals("-"))&& 
						    (arr[3].equals(t[3])  || arr[3].equals("-"))) {
							return true;
						}
						return false;
					}
				}else {
					return false;
				}
				
			}).count();
			
		}).toArray();

		
		IntStream aa = Arrays.stream(answer);
		
		aa.forEach(s-> System.out.println("##"+s));
		
		return answer;

	}
}
