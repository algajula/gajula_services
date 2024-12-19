package com.gajula.faqs.corejava;

import java.util.HashMap;
import java.util.Map;

public class LetterCount {

	public static void main(String[] args) {
		String str = "capgemini gajula";
		Map<Character, Integer> lettercount = new HashMap<Character, Integer>(); 
		for(int i=0; i<str.length();i++) {
			char letter = str.charAt(i);
			if(letter != ' ') {
				if(!lettercount.containsKey(letter)) {
					lettercount.put(letter, 1);
				}else {
					lettercount.put(letter, lettercount.get(letter)+1);
				}
			}
		}

		for(Map.Entry<Character, Integer> letter: lettercount.entrySet()) {
			System.out.println(letter.getKey()+"=="+letter.getValue());
		}
	}

}
