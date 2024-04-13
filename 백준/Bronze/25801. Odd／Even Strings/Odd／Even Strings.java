import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(oddEvenStrings(br.readLine()));
	}

	public static String oddEvenStrings(String string) {
		int evenCheck = 0;
		int oddCheck = 0;

		String answer = "0/1";

		Map<Character, Integer> charCount = new HashMap<>();
		for (char c : string.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		for (int count : charCount.values()) {
			if (count % 2 == 0) {
				evenCheck++;
			} else if (count % 2 == 1) {
				oddCheck++;
			}
		}

		if (evenCheck > 0 && oddCheck == 0) {
			answer = "0";
		} else if (evenCheck == 0 && oddCheck > 0) {
			answer = "1";
		}

		return answer;
	}
}