import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sincereTeams = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int T1 = Integer.parseInt(st.nextToken());
			int T2 = Integer.parseInt(st.nextToken());
			int T3 = Integer.parseInt(st.nextToken());

			if (isSincere(T1, T2, T3)) {
				sincereTeams++;
			}
		}

		System.out.println(sincereTeams);
	}

	private static boolean isSincere(int T1, int T2, int T3) {
		if (T1 == -1 && T2 == -1 && T3 == -1) return false;
		if (T1 != -1 && T2 == -1 && T3 == -1) return true;
		if (T1 != -1 && T2 != -1 && T3 == -1 && T1 <= T2) return true;
		if (T1 != -1 && T2 != -1 && T3 != -1 && T1 <= T2 && T2 <= T3) return true;
		return false;
	}
}