import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static char[] ops = {' ', '+', '-'};
	static char[] str;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < t; testCase++) {
			n = Integer.parseInt(br.readLine());

			str = new char[n * 2 - 1];
			str[0] = '1';
			dfs(1, 0, 1, 1);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int num, int sum, int op, int depth) {
		if (depth == n) {
			sum += (num * op);
			if (sum == 0) {
				sb.append(str).append("\n");
			}
			return;
		}
		
		for (char c : ops) {
			str[2 * depth - 1] = c;
			str[2 * depth] = Character.forDigit(depth + 1, 10);
			if (c == ' ') {
				dfs(num * 10 + (depth + 1), sum, op, depth + 1);
			} else if (c == '+') {
				dfs(depth + 1, sum + (num * op), 1, depth + 1);
			} else if (c == '-') {
				dfs(depth + 1, sum + (num * op), -1, depth + 1);
			}
		}
	}
}
