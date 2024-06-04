import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if(a == 0 && b == 0 && c == 0) {
				break;
			}

			int n = b - a;
			int m = c - b;

			String result = (n == m) ? ("AP " + (c + m)) : ("GP " + (c + (m * (m / n))));

			System.out.println(result);
		}
	}
}