import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int m;
	private static boolean[] isSelected;
	private static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		isSelected = new boolean[n+1];
		numbers = new int[m];
		
//		Per(0);
		dice4(0,1);
		
	}
	/*public static void Per(int cnt) {
		if(cnt == m) {
			for(int n : numbers) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(isSelected[i]) 
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			
			Per(cnt + 1);
			isSelected[i] = false;
			
		}
		
		
	}*/
	private static void dice4(int cnt, int start) { // cnt+1 번째 주사위 던지기.

		if (cnt == m) {
			for (int n : numbers) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}

		// 한번 던질 때 가능한 상황에 대한 시도(1,2,3,4,5,6 주사위 눈이 가능)
		for (int i = start; i <= n; i++) { //i 뽑는 수
			// 기존 주사위의 눈과 중복되는지 체크
			numbers[cnt] = i;
			dice4(cnt + 1, i+1);
		}
	}

}
