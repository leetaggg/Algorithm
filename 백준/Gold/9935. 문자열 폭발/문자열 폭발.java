import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String bombS = br.readLine();

		Stack<Character> stack = new Stack<>();
		int len = bombS.length();

		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));

			if (stack.size() >= len) {
				boolean flag = true;

				for (int j = 0; j < len; j++) {
					if (stack.get(stack.size() - len + j) != bombS.charAt(j)) {
						flag = false;
						break;
					}
				}

				if (flag) {
					for (int j = 0; j < len; j++) {
						stack.pop();
					}
				}
			}
		}

		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for (Character c : stack) {
				sb.append(c);
			}
			System.out.println(sb);
		}

	}
}
