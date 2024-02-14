package textanalyzer;


import comparable.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextAnalyzer {

	private final File file;

	public TextAnalyzer(String fileName) {
		this.file = new File(fileName);
	}


	public Map<String, Integer> countWords() {
		HashMap<String, Integer> map = new HashMap<>();
        try {
            Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String word = clean(scanner.next());
				if (word.isEmpty()) {
					if (map.containsKey(word)) {
						map.put(word, map.get(word) + 1);
					} else {
						map.put(word, 1);
					}
				}
			}
			scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return map;
	}

	private String clean(String s) {
		StringBuilder r = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				r.append(c);
			}
		}
		return r.toString().toLowerCase();
	}

	public static void main(String[] args) {

		TextAnalyzer ta = new TextAnalyzer("alice30.txt");
		System.out.println(ta.countWords());
		System.out.println("\n------------------------------------------------------------------\n");


	}

}
