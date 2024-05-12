import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long r1 = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		long r2 = Long.parseLong(st.nextToken());

		long dx = x2 - x1;
		long dy = y2 - y1;
		long distanceSquared = dx * dx + dy * dy;

		long radiusSum = r1 + r2;
		long radiusSumSquared = radiusSum * radiusSum;

		if (distanceSquared < radiusSumSquared) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}
}