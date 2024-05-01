import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine().trim());
		int n = Integer.parseInt(br.readLine().trim());
		int[] a = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine().trim());
		int[] b = new int[m];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i] + k == b[j]) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}