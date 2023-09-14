import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int target;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = Integer.parseInt(br.readLine());

		int priorValue = 3;
		int cnt = 1;
		while (true) {
			if (target < 2 * priorValue + cnt + 4) { // 길이 최소
				break;
			}
			priorValue = 2 * priorValue + (cnt++) + 3;
		}

//		System.out.println(S); //10 => S(1) 길이 값
//		System.out.println(cnt); //2 => S(2) 부터 탐색해야함

		solve(priorValue, cnt);

	}

	private static void solve(int s, int cnt) { // 길이, 길이만큼 조회
		// solve
		int length = cnt + 3;
		int prior = (s - length + 1) / 2;


		// 기저조건
		if (target >= s + 1 && target < s + 1 + length) {
			if (s + 1 == target) { // 만약 target이 같으면
				System.out.println("m");
			} else {
				System.out.println("o");
			}
			return;
		}
		else if (target <= s) { // 작을 경우
			solve(prior, cnt - 1);
		} 
		else if (s + length < target) {
			
			target = target - (s + length);
			solve(prior, cnt - 1);
		}

	}

}
