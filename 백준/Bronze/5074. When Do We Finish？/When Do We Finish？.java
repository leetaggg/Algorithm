import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;

		while ((line = br.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(line);
			String startTime = tokenizer.nextToken();
			String durationTime = tokenizer.nextToken();

			if (startTime.equals("00:00") && durationTime.equals("00:00")) {
				break;
			}

			int startMinutes = convertToMinutes(startTime);
			int durationMinutes = convertToMinutes(durationTime);
			int endMinutes = startMinutes + durationMinutes;

			int days = endMinutes / 1440;
			endMinutes = endMinutes % 1440;

			String endTime = convertToTime(endMinutes);

			if (days > 0) {
				endTime += " +" + days;
			}

			System.out.println(endTime);
		}
	}

	private static int convertToMinutes(String time) {
		String[] parts = time.split(":");
		int hours = Integer.parseInt(parts[0]);
		int minutes = Integer.parseInt(parts[1]);
		return hours * 60 + minutes;
	}

	private static String convertToTime(int totalMinutes) {
		int hours = totalMinutes / 60;
		int minutes = totalMinutes % 60;
		return String.format("%02d:%02d", hours, minutes);
	}
}