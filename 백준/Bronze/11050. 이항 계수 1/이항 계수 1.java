import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long top = factorial(n);
		long bottom = factorial(k) * factorial(n-k);
		System.out.print(top / bottom);
	}

	static long factorial(int n) {
		long ret = 1;
		while (n > 1) {
			ret *= n;
			n--;
		}
		return ret;
	}
}