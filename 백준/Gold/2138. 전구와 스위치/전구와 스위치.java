import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] first = new int[n];
		int[] second = new int[n];
		int[] answer = new int[n];

		String s1 = br.readLine();
		String s2 = br.readLine();

		for (int i = 0; i < n; i++) {
			first[i] = s1.charAt(i) - '0';
			second[i] = s1.charAt(i) - '0';

			answer[i] = s2.charAt(i) - '0';
		}

		int firstCnt = 0;
		int secondCnt = 1;

		switchLights(second, 0);

		for (int i = 1; i < n; i++) {
			if (first[i - 1] != answer[i - 1]) {
				switchLights(first, i);
				firstCnt++;
			}
			if (second[i - 1] != answer[i - 1]) {
				switchLights(second, i);
				secondCnt++;
			}
		}

		if (first[n - 1] != answer[n - 1]) firstCnt = Integer.MAX_VALUE;
		if (second[n - 1] != answer[n - 1]) secondCnt = Integer.MAX_VALUE;

		if (firstCnt == Integer.MAX_VALUE && secondCnt == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(Math.min(firstCnt, secondCnt));
		}
	}

	private static void switchLights(int[] arr, int i) {
		arr[i] = 1 - arr[i];
		if (i > 0) {
			arr[i - 1] = 1 - arr[i - 1];
		}
		if (i < arr.length - 1) {
			arr[i + 1] = 1 - arr[i + 1];
		}
	}
}
