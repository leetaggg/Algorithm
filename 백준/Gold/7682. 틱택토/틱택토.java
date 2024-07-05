import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null) {
			if (line.equals("end")) break;

			char[] arr = line.toCharArray();
			int xCnt = 0;
			int oCnt = 0;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 'X') {
					xCnt++;
				} else if (arr[i] == 'O') {
					oCnt++;
				}
			}

			boolean xWin = isXWin(arr);
			boolean oWin = isOWin(arr);

			if (oCnt > xCnt || xCnt - oCnt > 1) {
				System.out.println("invalid");
			} else if (xWin && oWin) {
				System.out.println("invalid");
			} else if (xWin && xCnt == oCnt + 1) {
				System.out.println("valid");
			} else if (oWin && xCnt == oCnt) {
				System.out.println("valid");
			} else if (!xWin && !oWin && xCnt + oCnt == 9) {
				System.out.println("valid");
			} else {
				System.out.println("invalid");
			}
		}
	}

	public static boolean isXWin(char[] arr) {
		for (int i = 0; i < 9; i += 3) {
			if (arr[i] == 'X' && arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2]) return true;
		}
		for (int i = 0; i < 3; i++) {
			if (arr[i] == 'X' && arr[i] == arr[i + 3] && arr[i + 3] == arr[i + 6]) return true;
		}
		if (arr[0] == 'X' && arr[0] == arr[4] && arr[4] == arr[8]) return true;
		if (arr[2] == 'X' && arr[2] == arr[4] && arr[4] == arr[6]) return true;
		return false;
	}

	public static boolean isOWin(char[] arr) {
		for (int i = 0; i < 9; i += 3) {
			if (arr[i] == 'O' && arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2]) return true;
		}
		for (int i = 0; i < 3; i++) {
			if (arr[i] == 'O' && arr[i] == arr[i + 3] && arr[i + 3] == arr[i + 6]) return true;
		}
		if (arr[0] == 'O' && arr[0] == arr[4] && arr[4] == arr[8]) return true;
		if (arr[2] == 'O' && arr[2] == arr[4] && arr[4] == arr[6]) return true;
		return false;
	}
}
