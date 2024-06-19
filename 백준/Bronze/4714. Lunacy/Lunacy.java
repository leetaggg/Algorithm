import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		double moonGravity = 0.167;

		while ((line = br.readLine()) != null) {
			double weightOnEarth = Double.parseDouble(line.trim());

			if (weightOnEarth < 0) {
				break;
			}

			double weightOnMoon = weightOnEarth * moonGravity;
			System.out.printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.%n", weightOnEarth, weightOnMoon);
		}
	}
}