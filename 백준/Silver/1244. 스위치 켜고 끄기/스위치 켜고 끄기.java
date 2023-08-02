import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 스위치 수
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 스위치 상태
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()); // 학생 수

		int person = 0;
		int switch_num = 0;
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			person = Integer.parseInt(st.nextToken());
			switch_num = Integer.parseInt(st.nextToken());

			// 스위치 조작 함수 작성
			answer(n, person, switch_num);
		}
		// switch 배열 출력 n 사이즈 만큼
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}

	}

	/**
	 * 
	 * @param n 스위치 개수
	 * @param p 남자인지 여자인지 구분
	 * @param s 해당 스위치 번호
	 */
	public static void answer(int n, int p, int s) {

		if (p == 1) {// 남자일 경우 - 자기 배수 바꾸기
			// s 값을 기준으로 n 값 전까지
			for (int i = s; i <= n; i += s) {
				if (arr[i] == 0)
					arr[i] = 1;
				else
					arr[i] = 0;
			}

		} // 남자 끝
		else if (p == 2) {// 여자일 경우
			// 없을 경우 자기 자신만 바꿈, 있을 경우 자기포함 맞는 데까지 다 바꿈
			int min = s;
			int max = s;

			while (min >= 1 && max <= n) {
				if (arr[min] != arr[max])
					break;
				min--;
				max++;
			}

			for (int j = min+1; j <= max-1; j++) {
				if (arr[j] == 0)
					arr[j] = 1;
				else
					arr[j] = 0;
			}
		}
	}

}
