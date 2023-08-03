import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	private static int[] arr;
	private static boolean[] isSelected;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//백설공주 - 의자 7, 접시 7, 나이프 7
		//일곱난쟁이의 모자에 쓰여있는 합이 100
		//부분집합의 합 이용??
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[9];
		isSelected = new boolean[9];
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Subset(0);
		System.out.println(sb);
		
		
	}
	public static void Subset(int cnt) {
		if(cnt == 9) {
			int sum = 0;
			int count = 0;
			for (int i = 0; i < 9; i++) {
				if(isSelected[i] ) {
					sum += arr[i];
					count++;
				}
			}
			if(sum == 100 && count == 7) {
				for (int i = 0; i < 9; i++) {
					if(isSelected[i]) {
						sb.append(arr[i]).append("\n");
					}
				}
			}
			return;
		}
		isSelected[cnt] = true;
		Subset(cnt+1);
		isSelected[cnt] = false;
		Subset(cnt+1);
				
	}
}
