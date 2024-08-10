import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double speed = Double.parseDouble(st.nextToken());
			double weight = Double.parseDouble(st.nextToken());
			double strength = Double.parseDouble(st.nextToken());

			if (speed == 0 && weight == 0 && strength == 0) {
				break;
			}

			boolean noPosition = true;
			StringBuilder sb = new StringBuilder();

			if (speed <= 4.5 && weight >= 150 && strength >= 200) {
				sb.append("Wide Receiver ");
				noPosition = false;
			}
			if (speed <= 6.0 && weight >= 300 && strength >= 500) {
				sb.append("Lineman ");
				noPosition = false;
			}
			if (speed <= 5.0 && weight >= 200 && strength >= 300) {
				sb.append("Quarterback ");
				noPosition = false;
			}

			if (noPosition) {
				System.out.println("No positions");
			} else {
				System.out.println(sb.toString().trim());
			}
		}
	}
}
