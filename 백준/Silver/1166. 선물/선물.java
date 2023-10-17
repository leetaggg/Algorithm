import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	private static long[] arr;
	private static long n;
	private static long min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		double left = 0;
		double right = Math.min(L, Math.min(W, H));

		while (left < right) {
			double target = (left + right) / 2;
			
			if((long)(L/target)*(long)(W/target)*(long)(H/target)<N) {
				if(right == target) break;
				right = target;
			}else {
				if(left == target) break;
				left = target;
			}
			
		}

		System.out.println(left);

	}

}
