import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] breads = new int[N * K];
		for (int i = 0; i < N * K; i++) {
			breads[i] = Integer.parseInt(st.nextToken());
		}

		int sellableGroups = 0;
		for (int i = 0; i < N; i++) {
			int noCreamCount = 0;
			for (int j = 0; j < K; j++) {
				if (breads[i * K + j] == 0) {
					noCreamCount++;
				}
			}
			if (noCreamCount < P) {
				sellableGroups++;
			}
		}

		System.out.println(sellableGroups);
		br.close();
	}
}