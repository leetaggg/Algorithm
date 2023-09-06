import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int[] lan;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		lan = new int[K];
		for (int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
		}
		// 정렬 
		Arrays.sort(lan);
		//이분탐색 - 시작 인덱스, 끝 인덱스
		long start = 1;
		long end = lan[K-1]; //1~최댓값
		
		long res = 0; //정답
		while(start <= end) {
			long target = (start + end)/2; //찾을 값
//			System.out.println(answer(target));
			if(answer(target) >= N) {
				res = target; //저장
				start = target+1;
			}
			else {
				end = target-1;
			}
			
		}//이분 탐색
		
		System.out.println(res);
		
	}
	//계산
	
	static public long answer(long target) {
		long sum = 0;
		//lan을 다 돌면서
		for (int i = 0; i < lan.length; i++) {
			sum += lan[i] / target;
		}
		return sum;
	}
}
