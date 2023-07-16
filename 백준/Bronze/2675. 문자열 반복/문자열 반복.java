import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int a = 0; a < T; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			int r = Integer.parseInt(st.nextToken());
			String[] spstr = st.nextToken().split("");
			for(String i : spstr) {
				for(int j = 0; j < r; j++) {
					sb.append(i);
				}
			}
			System.out.println(sb.toString());
		}
	}

}
