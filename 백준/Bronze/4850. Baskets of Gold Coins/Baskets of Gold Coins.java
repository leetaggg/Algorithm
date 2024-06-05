import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = br.readLine()) != null && !line.isEmpty()) {
			StringTokenizer st = new StringTokenizer(line);
			long N = Long.parseLong(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			long d = Long.parseLong(st.nextToken());
			long sum = Long.parseLong(st.nextToken());

			long fullWeight = N * (N - 1) / 2 * w;
			long ans = (fullWeight - sum) / d;

			if (ans == 0) {
				ans = N;
			}

			System.out.println(ans);
		}
	}
}