import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int s;
	private static int[] input;
	private static boolean[] isSelected;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		input = new int[n];
		isSelected = new boolean[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		answer = 0;
		PowerSet(0, 0);

		if (s == 0) {
			answer--;
		}
		System.out.println(answer);
	}

	private static void PowerSet(int cnt, int sum) {

		// 기저조건
		if (cnt == n) {
			if (sum == s) {
				answer++;
			}
			return;
		}
		isSelected[cnt] = true;
		PowerSet(cnt + 1, sum + input[cnt]);
		isSelected[cnt] = false;
		PowerSet(cnt + 1, sum);

	}

}
