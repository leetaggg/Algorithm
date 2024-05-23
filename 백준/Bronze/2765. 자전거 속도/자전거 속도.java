import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int tripNumber = 1;
		final double PI = 3.1415927;
		final double INCHES_PER_MILE = 5280 * 12;
		final double SECONDS_PER_HOUR = 3600;

		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);
			double diameter = Double.parseDouble(st.nextToken());
			int revolutions = Integer.parseInt(st.nextToken());
			double timeInSeconds = Double.parseDouble(st.nextToken());

			if (revolutions == 0) {
				break;
			}

			// Calculate distance in miles
			double distanceInInches = PI * diameter * revolutions;
			double distanceInMiles = distanceInInches / INCHES_PER_MILE;

			// Calculate speed in miles per hour
			double timeInHours = timeInSeconds / SECONDS_PER_HOUR;
			double mph = distanceInMiles / timeInHours;

			// Print the results
			System.out.printf("Trip #%d: %.2f %.2f%n", tripNumber, distanceInMiles, mph);
			tripNumber++;
		}
	}
}