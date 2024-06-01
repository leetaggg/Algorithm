import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line1 = br.readLine().split(" ");
		int A = Integer.parseInt(line1[0]);
		int B = Integer.parseInt(line1[1]);
		int C = Integer.parseInt(line1[2]);
		int D = Integer.parseInt(line1[3]);

		String[] line2 = br.readLine().split(" ");
		int P = Integer.parseInt(line2[0]);
		int M = Integer.parseInt(line2[1]);
		int N = Integer.parseInt(line2[2]);

		System.out.println(getAttackCount(A, B, C, D, P));
		System.out.println(getAttackCount(A, B, C, D, M));
		System.out.println(getAttackCount(A, B, C, D, N));
	}

	public static int getAttackCount(int A, int B, int C, int D, int time) {
		int count = 0;

		if (isAttacking(A, B, time)) {
			count++;
		}

		if (isAttacking(C, D, time)) {
			count++;
		}

		return count;
	}

	public static boolean isAttacking(int attackTime, int restTime, int time) {
		int cycle = attackTime + restTime;
		int timeInCycle = time % cycle;
		return timeInCycle > 0 && timeInCycle <= attackTime;
	}
}