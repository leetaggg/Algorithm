import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] firstLine = br.readLine().split(" ");
		int A = Integer.parseInt(firstLine[0]);
		int B = Integer.parseInt(firstLine[1]);

		String[] secondLine = br.readLine().split(" ");
		int C = Integer.parseInt(secondLine[0]);
		int D = Integer.parseInt(secondLine[1]);

		double[] values = new double[4];
		values[0] = (double) A / C + (double) B / D;
		values[1] = (double) C / D + (double) A / B;
		values[2] = (double) D / B + (double) C / A;
		values[3] = (double) B / A + (double) D / C;

		int maxIndex = 0;
		for (int i = 1; i < 4; i++) {
			if (values[i] > values[maxIndex]) {
				maxIndex = i;
			}
		}

		System.out.println(maxIndex);
	}
}