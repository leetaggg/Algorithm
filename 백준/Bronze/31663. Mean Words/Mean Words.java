import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		String[] words = new String[n];
		int maxLength = 0;

		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
			maxLength = Math.max(maxLength, words[i].length());
		}

		StringBuilder sb = new StringBuilder();

		for (int pos = 0; pos < maxLength; pos++) {
			int sum = 0;
			int count = 0;

			for (String word : words) {
				if (pos < word.length()) {
					sum += word.charAt(pos);
					count++;
				}
			}

			if (count > 0) {
				char meanChar = (char) (sum / count);
				sb.append(meanChar);
			}
		}

		System.out.println(sb);
	}
}