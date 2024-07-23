import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			sb.append("String #").append(i).append("\n");

			for (char c : line.toCharArray()) {
				if (c == 'Z') {
					sb.append('A');
				} else {
					sb.append((char)(c + 1));
				}
			}

			sb.append("\n\n");
		}

		sb.setLength(sb.length() - 1);

		System.out.print(sb);
	}
}
