package algorithm;

import java.util.HashMap;
import java.util.Iterator;

public class kakao_lv1_report {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		int cnt = id_list.length;
		int[] arr = new int[cnt];

		HashMap<String, String> clear = new HashMap<String, String>();
		for (String a : report) {
			clear.put(a, "");
		}

		HashMap<String, Integer> reportHash = new HashMap<String, Integer>();
		reportHash = reportcount(id_list, clear, k); // 누가 몇번 신고 당했는지 를 포함하고 있음
		Iterator<String> iterator = reportHash.keySet().iterator();
		String target = "";
		if (reportHash.size() < 1) { // 신고 카운트가 도달하지 않았을
			for (int i = 0; i < cnt; i++) {
				arr[i] = 0;
			}
			return arr;
		}
		while (iterator.hasNext()) {
			String key = iterator.next();
			if (target.equals("")) {
				target = key;
			} else {
				target = target + "," + key;
			}
		}
		arr = whoisreportiing(clear, id_list, cnt, target); // 누가 누구를 신고했는지를 가지고 ㅇㅆ
		return arr;
	}

	public static int[] whoisreportiing(HashMap<String, String> clear, String[] id_list, int cnt, String target) {
		String[][] repoter = new String[cnt][2];
		String[] targetarr = new String[target.split(",").length];
		int[] result = new int[cnt];
		targetarr = target.split(",");
		Iterator<String> iterator = clear.keySet().iterator();
		HashMap<String, Integer> answerMap = new HashMap<String, Integer>();
		HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
		for (int j = 0; j < cnt; j++) {
			answerMap.put(id_list[j], 0);
			resultMap.put(id_list[j], j);
		}
		while (iterator.hasNext()) {
			String[] temp = new String[2];
			String reprotTemp = iterator.next();
			temp[0] = reprotTemp.split(" ")[0];
			temp[1] = reprotTemp.split(" ")[1];

			for (int z = 0; z < targetarr.length; z++) {
				if (targetarr[z].equals(temp[1])) {
					answerMap.put(temp[0], answerMap.getOrDefault(temp[0], 1) + 1);
				}
			}
		}
		Iterator<String> answerIt = answerMap.keySet().iterator();
		while (answerIt.hasNext()) {
			String key = answerIt.next();
			result[resultMap.get(key)] = answerMap.get(key);
		}
		return result;
	}

	public static HashMap<String, Integer> reportcount(String[] id_list, HashMap<String, String> hs, int k) {

		HashMap<String, Integer> countHash = new HashMap<String, Integer>();
		HashMap<String, Integer> countHash2 = new HashMap<String, Integer>();

		for (int i = 0; i < id_list.length; i++) {
			countHash.put(id_list[i], 0);
		}

		Iterator<String> iterator = hs.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String[] temp = new String[2];
			temp = key.split(" ");
			countHash.put(temp[1], countHash.getOrDefault(temp[1], 0) + 1);
		}

		Iterator<String> iterator2 = countHash.keySet().iterator();
		while (iterator2.hasNext()) {
			String key = iterator2.next();
			if (countHash.get(key) >= k) {
				countHash2.put(key, countHash.get(key));
			}
		}
		return countHash2;
	}
}


