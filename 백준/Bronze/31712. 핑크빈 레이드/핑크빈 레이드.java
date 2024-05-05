import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C_U = Integer.parseInt(st.nextToken());
		int D_U = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int C_D = Integer.parseInt(st.nextToken());
		int D_D = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int C_P = Integer.parseInt(st.nextToken());
		int D_P = Integer.parseInt(st.nextToken());

		int H = Integer.parseInt(br.readLine());

		int totalDamage = 0;
		int time = 0;

		totalDamage = D_U + D_D + D_P;

		if (totalDamage >= H) {
			System.out.println(0);
			return;
		}

		H -= totalDamage;

		while (H > 0) {
			time++;
			if (time % C_U == 0) H -= D_U;
			if (time % C_D == 0) H -= D_D;
			if (time % C_P == 0) H -= D_P;

			if (H <= 0) {
				System.out.println(time);
				break;
			}
		}
	}
}