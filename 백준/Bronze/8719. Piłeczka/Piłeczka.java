import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			int result = 0;
			while (x < w) {
				x *= 2;
				result++;
			}

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
