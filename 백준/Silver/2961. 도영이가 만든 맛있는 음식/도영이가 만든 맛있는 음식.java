import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int[] sour;
	private static int[] bitter;
	private static boolean[] isSelected;
	
	private static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		sour = new int[n];
		bitter = new int[n];
		isSelected = new boolean[n];

		// 신맛, 쓴맛 배열
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}

//		System.out.println(Arrays.toString(bitter));
		min = Integer.MAX_VALUE;
		Subset(0);
		// 부분합 구해서 신맛은 부분합 끼리 곱하기, 쓴맛은 부분합끼리 더하기, 조합
		System.out.println(min);

	}

	public static void Subset(int cnt) {
		// 제어문
		if (cnt == n) {
			int sum_sour = 1;
			int sum_bitter = 0;
			int index = 0;
			for (int i = 0; i < n; i++) {
				if (isSelected[i]) {
					index++;
					sum_sour *= sour[i];
					sum_bitter += bitter[i];
				}
			}
			if(index == 0)
				return; //공집합
			min=Math.min(min, Math.abs(sum_sour-sum_bitter));
			return;
		}

		isSelected[cnt] = true; // 뽑은경우
		Subset(cnt + 1);
		isSelected[cnt] = false; // 안뽑은 경우
		Subset(cnt + 1);
	}

}
