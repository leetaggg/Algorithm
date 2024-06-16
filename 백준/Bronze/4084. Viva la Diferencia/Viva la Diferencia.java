import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;

		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0 && d == 0) {
				break;
			}

			int steps = 0;
			while (!(a == b && b == c && c == d)) {
				int newA = Math.abs(a - b);
				int newB = Math.abs(b - c);
				int newC = Math.abs(c - d);
				int newD = Math.abs(d - a);

				a = newA;
				b = newB;
				c = newC;
				d = newD;

				steps++;
			}

			System.out.println(steps);
		}
	}
}