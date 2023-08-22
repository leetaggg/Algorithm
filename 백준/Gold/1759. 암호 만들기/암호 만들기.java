import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	private static char[] input;
	static String answer ="";
	private static int L;
	private static int C;
	static HashSet<Character> hash;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		hash = new HashSet<>();
		
		input = new char[C];
		String s = br.readLine();
		for (int i = 0, index = 0; i < C; i++, index+=2) {
			input[i] = s.charAt(index);
			if(s.charAt(index) == 'a'|| s.charAt(index) == 'e'||  s.charAt(index) == 'i'|| s.charAt(index) == 'e'|| s.charAt(index) == 'o'|| s.charAt(index) == 'u') {
				hash.add(s.charAt(index));
			}
		}
		Arrays.sort(input);
		
		combination_NextPermutation();
	
		
	}

	 public static boolean nextPermutation(int[] numbers) {
	    	
	    	int i = C-1;
	    	while(i >0 && numbers[i-1] >= numbers[i]) i--;
	    	if(i == 0)
	    		return false;
	    	
	    	int j = C-1;
	    	while(numbers[i-1] >= numbers[j]) j--;
	    	swap(numbers, i-1, j);
	    	
	    	int k = C-1;
	    	while(i < k) swap(numbers, i++, k--);
	    	
	    	return true;
	    	
	    }

		public static void swap(int[] numbers, int i, int j) {
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
		
		/** 조합 nCr : NextPermutation 사용 */
		public static void combination_NextPermutation() {
			//00000111 정렬된 상태로 시작할 수 있도록 배치
			//0은 뽑을 R개 만큼 작성, 안 뽑을 것은 1로 채우기
			int[] p = new int[C];
			for (int i = L; i < C; i++) {
				p[i] = 1;//0은 선택, 1은 비선택
			}
			do {
				//p배열의 값이 0 이면 원소 출력
				answer = "";
				for (int i = 0; i < C; i++) {
					if(p[i] == 0) {
						answer += input[i];
					}
				}
				
				int cnt1 = 0;
				int cnt2 = 0;
				for (int index = 0; index < L; index++) {
					if(hash.contains(answer.charAt(index))) {
						cnt1++;
					}
					else {cnt2++;}
					if(cnt1!=0 && cnt2>=2) {
						System.out.println(answer);
						break;
					}
				}
			} while (nextPermutation(p));
		}

}
