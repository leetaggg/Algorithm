import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int r;
	private static int c;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		//r행 c열을 몇번째로 방문했는가
		cnt = 0;
		int length = (int) Math.pow(2, n);
		
		//몇사분면인지 파악
		dfs(r, c, length);
		System.out.println(cnt);
		
	}
	private static void dfs(int nr, int nc, int length) {
		//기저조건
		if(length == 1) { //depth 4 되면 return 넘어가야함
			return;
		}
		
		if(nr < length/2 && nc < length/2) {
			dfs(nr, nc, length/2); //0,0,4  // 0, 0, 2
		}else if(nr < length/2 && nc >= length/2) {
			cnt += (length*length/4);
			dfs(nr, nc-length/2,  length/2); //0, 
			//4, 4  // 0, 0, 1 
		}else if(nr >= length/2 && nc < length/2) {
			cnt +=(length*length/4)*2;
			dfs(nr-length/2, nc,  length/2); // 4, 0, 4 // 2, 0, 1
			
		}else {
			cnt +=(length*length/4)*3;
			dfs(nr-length/2, nc-length/2,  length/2); //4, 4, 4
		}
	}

}
