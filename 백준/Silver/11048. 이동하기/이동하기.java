import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] maze = new int[n+1][m+1];
		int[][] gift = new int[n+1][m+1]; //memo
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				gift[i][j] = Math.max(gift[i-1][j], Math.max(gift[i-1][j-1], gift[i][j-1]))
						+ maze[i][j];
			}
		}
		System.out.println(gift[n][m]);
		
	}//메인 끝

}// 클래스 끝
