import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int evenSum = 0;
			int oddSum = 0;

			for (int j = 0; j < k; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num % 2 == 0) {
					evenSum += num;
				} else {
					oddSum += num;
				}
			}

			if (evenSum > oddSum) {
				sb.append("EVEN");
			} else if (oddSum > evenSum) {
				sb.append("ODD");
			} else {
				sb.append("TIE");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
