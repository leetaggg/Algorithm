import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		for (int i = 0; i < N - 2; i++) {
			int x = A[i];
			if (Arrays.binarySearch(A, x + 3) >= 0 && Arrays.binarySearch(A, x + 6) >= 0) {
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}
}