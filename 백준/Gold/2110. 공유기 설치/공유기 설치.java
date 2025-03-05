import java.io.*;
import java.util.*;

public class Main {
	static int n, c;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 1 2 4 8 9
		Arrays.sort(arr);

		// 이분탐색 파트
		int l = 1; // 항상 가능한 값만
		int r = arr[n-1] + 1; // 항상 불가능한 값만
		// int r = Integer.MAX_VALUE; // 불가능한 최대값을 가짐
		int m; // 중간값
		// ... 2, 3 까지는 true
		// 4, 5, ... 부터는 false
		while (l != r - 1) { // l과 r 이 붙어있으면 끝낸다. ex) 3, 4
			m = (l + r) / 2;
			if (checkPossible(m)) {
				l = m;
			} else {
				r = m;
			}
		}

		/*
		1. 답이 될 수 있는 가능여부 판단하는 함수
		2. 그 함수를 통해, 어떤 값이 답이 될 수 있는지를 검사
		2-1. 그 과정을 이분탐색으로
		 */

		/* 꺼꾸로 가능한 최소값?
		int l = -1; // 항상 불가능한 값
		int r = arr[n-1]; // 항상 가능한 값만
		// int r = Integer.MAX_VALUE; // 불가능한 최대값을 가짐
		int m; // 중간값
		// ... 2, 3 까지는 true
		// 4, 5, ... 부터는 false
		while (l != r - 1) { // l과 r 이 붙어있으면 끝낸다. ex) 3, 4
			m = (l + r) / 2;
			if (checkPossible(m)) {
				l = m;
			} else {
				r = m;
			}
		}
		 */

		System.out.println(l);
	}

	// check 파트
	// 최소 dist 거리마다 공유기를 설치하면 설치할 수 있는 공유기의 갯수가 c를 넘는가?
	static boolean checkPossible(int dist) {
		int cnt = 1;
		int start = arr[0];

		for (int i = 1; i < n; i++) {
			int sum = start + dist;

			if (sum <= arr[i]) {
				cnt++;
				start = arr[i];
			}
		}

		return cnt >= c;
	}
}