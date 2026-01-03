package week4.day2;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeanMap {

	public static void main(String[] args) {
		String input="amazon";
		//op is take the occurrence of each character a-2,m-1.z-1,o-1,n-1
		//character is constand so its key and interger(count) should be the value since it will keep on change
		//convert string to array
		char[] chara = input.toCharArray();
		//1st declare map
		Map<Character, Integer> map= new LinkedHashMap<>();
		//METHOD 1
		//add entries to map
//		for (int i = 0; i < chara.length; i++) {
//			//existing for existing key
//			if (map.containsKey(chara[i])) {
//				Integer exis = map.get(chara[i]);
//				map.put(chara[i], exis+1);
//			}
//			else {
//				map.put(chara[i], 1);
//			}
//
//		}
//		  System.out.println(map);
		//METHOD 2
		for (int i = 0; i < chara.length; i++) {
			map.put(chara[i], map.getOrDefault(chara[i], 0)+1);
			
		}
System.out.println(map);
//need explaination to write code for max re occuring character-could not understand from the rexcording
	}

}
