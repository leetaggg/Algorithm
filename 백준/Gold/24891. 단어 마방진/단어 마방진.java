import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static String[] words, answer;
	private static int r;
	private static int c;
	private static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		words = new String[r];
		answer = new String[c];

		for (int i = 0; i < r; i++) {
			words[i] = br.readLine();
		} // 입력 완료

		Arrays.sort(words);

		numbers = new int[c];
		isSelected = new boolean[r];

		solved(0);
		if(sb.toString().equals("")) {
			sb.append("NONE");
		}
		System.out.println(sb.toString());

	}// end main

	static int[] numbers;
	static boolean flag = false;

	public static void solved(int depth) { // 단어들 조합 콤비
		if(flag) {
			return;
		}
		// 기저조건
		if (depth == c) {
			for (int i = 0; i < c; i++) {
				answer[i] = words[numbers[i]];
			}
			// 만들어진 String[] 을 갖고 마방진인지 check;
			// check 에서 true 일 경우 String[] 차례로 출력
			if(checked(answer)) {
				for (int i = 0; i < c; i++) {
					sb.append(answer[i]).append("\n");
				}
				flag = true;
			}
			return;
		}

		for (int i = 0; i < r; i++) {
			if (isSelected[i])
				continue;
			numbers[depth] = i;
			isSelected[i] = true;
			solved(depth + 1);
			isSelected[i] = false;
		}

	}

	public static boolean checked(String[] temp) {
		// 가로는 무조건 다 읽어야함.
		// 가로 길이만큼 가로 세로 읽으면서 확인함.
		// 틀렸을 경우

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < c; j++) {
				if(temp[j].charAt(i) != temp[i].charAt(j)) {
					return false;
				}
				
			}
			
		}
		
		return true;
	}

}// end class
