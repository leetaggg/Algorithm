import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int testCase = 0; testCase < t; testCase++) {
			sb.append(func(br.readLine())).append("\n");
		}
		System.out.println(sb);
	}

	static int func(String s) {
		Set<Character> allAlphabets = new HashSet<>();
		for (char c = 'A'; c <= 'Z'; c++) {
			allAlphabets.add(c);
		}

		for (char c : s.toCharArray()) {
			allAlphabets.remove(c);
		}

		int sum = 0;
		for (char c : allAlphabets) {
			sum += (int) c;
		}

		return sum;
	}
}
