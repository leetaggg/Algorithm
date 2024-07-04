import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int testCase = 0; testCase < t; testCase++) {
			char[] str = br.readLine().toCharArray();
			int k = Integer.parseInt(br.readLine());

			if (k == 1) {
				sb.append("1 1").append("\n");
				continue;
			}

			List<List<Integer>> strIdx = new ArrayList<>(26);
			for (int i = 0; i < 26; i++) {
				strIdx.add(new ArrayList<>());
			}

			for (int i = 0; i < str.length; i++) {
				strIdx.get(str[i] - 'a').add(i);
			}

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < 26; i++) {
				int size = strIdx.get(i).size();
				if (size < k) continue;

				for (int j = 0; j < size - k + 1; j++) {
					int len = strIdx.get(i).get(j + k - 1) - strIdx.get(i).get(j) + 1;
					if (min > len) min = len;
					if (max < len) max = len;
				}
			}

			if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
				sb.append("-1").append("\n");
			} else {
				sb.append(min).append(" ").append(max).append("\n");
			}
		}
		System.out.println(sb);
	}
}