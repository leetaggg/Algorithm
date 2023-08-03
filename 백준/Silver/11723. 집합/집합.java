import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		HashSet<Integer> S = new HashSet<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x;
			switch (st.nextToken()) {
			case "add":
				S.add(Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				S.remove(Integer.parseInt(st.nextToken()));
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				if(S.contains(x)) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if(S.contains(x)) {
					S.remove(x);
				} else {
					S.add(x);
				}
				break;
			case "all":
				for(int j = 1; j <= 20; j++) {
					S.add(j);
				}
				break;
			case "empty":
				S.clear();
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
