import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[m];
		isSelected = new boolean[n+1];
		
		answer(0);

	}

	/**
	 * @param start 시작값
	 * @param m index 담는 값
	 */
	public static void answer(int cnt) {
		
		if(cnt == m) {
			for (int i : numbers) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (isSelected[i])
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			
			answer(cnt+1);
			isSelected[i] = false;
		}
		
	}

}
