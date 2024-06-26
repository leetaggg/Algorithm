import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] sticks = new int[n];
		int[] numbers = new int[10];

		for (int i = 0; i < n; i++) {
			int s = Integer.parseInt(st.nextToken());
			sticks[i] = s;
		}

		int kind = 0;
		int cnt = 0;

		int left = 0;
		int right = 0;

		while (right < n) {
			if(numbers[sticks[right]] == 0) {
				kind++;
			}

			cnt++;
			numbers[sticks[right]]++;

			if(kind > 2) {
				if(--numbers[sticks[left]] == 0) {
					kind--;
				}
				cnt--;
				left++;
			}

			right++;
		}

		System.out.println(cnt);
	}
}