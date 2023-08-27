import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int r;
	private static int c;
	private static int t;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상하좌우
	private static int[][] map;
	private static int[][] tmp_map;
	private static int cx;
	private static int cy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());//행
		c = Integer.parseInt(st.nextToken());//열
		t = Integer.parseInt(st.nextToken());//시간
		
		map = new int[r][c];
		tmp_map = new int[r][c];
		
		cx = 0;
		cy = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					cx = i;
					cy = j;
				}//마지막 값 일 것임
			}
		} //입력 끝
		//-1 일 경우 확산되지 않음. 0이 아니면 4방 확산
		for (int i = 0; i < t; i++) {
			spread();
			
			for (int a = 0; a < r; a++) {
				map[a] = Arrays.copyOf(tmp_map[a], tmp_map[a].length);
				Arrays.fill(tmp_map[a], 0);
			}
			//배열돌리기
			runclean();
			
//			for (int[] t : map) {
//				System.out.println(Arrays.toString(t));
//			}
//			System.out.println();
		}
		int res = 0;

		
		for (int[] t : map) {
			for (int s : t) {
				if(s != -1) {
					res += s;
				}
			}
			
		}
		System.out.println(res);
		
	}//main 끝
	static void left(int x, int a, int b) {
		for (int y = a; y <= b; y++) {
			map[x][y-1] = map[x][y];
			map[x][y] = 0;
		}
	}
	static void right(int x, int a, int b) {
		for (int y = b; y >= a; y--) {
			map[x][y+1] = map[x][y];
			map[x][y] = 0;
		}
	}
	static void up(int y, int a, int b) {
		for (int x = a; x <= b; x++) {
			map[x-1][y] = (map[x-1][y] == -1)?-1 : map[x][y];
			map[x][y] = 0;
		}
	}
	static void down(int y, int a, int b) {
		for (int x = b; x >= a; x--) {
			map[x+1][y] = (map[x+1][y] == -1 ) ? -1 : map[x][y];
			map[x][y] = 0;
		}
	}
	private static void runclean() {
		//밑에 공청 - (cx, cy) , 위에 공청 - (cx-1, cy)
		//위쪽
		down(0, 0, cx-2);
		left(0, 1, c-1);
		up(c-1, 1, cx-1);
		right(cx-1, 1, c-2);
		
		//아래
		up(0, cx+1 +1, r-1);
		left(r-1, 1, c-1);
		down(c-1, cx, r-2);
		right(cx, 1, c-2);
			
		
	}//clean 함수 끝

	private static void spread() { //미세먼지 확산하는 함수
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] != -1) {//-1이 아니고 0이 아니면 4방 퍼짐
					//(r, c) 자리는 map[r][c] - (map[r][c]/5 * 4방 위치 카운트)
					int cnt = 0;
					int m = 0;
					for (int d = 0; d < dir.length; d++) {
						int nr = i + dir[d][0];//다음 행
						int nc = j + dir[d][1];//다음 열
						
						//범위 카운트 체크
						if(nr < 0 || nr >= r || nc <0 || nc >= c) {
							continue; //범위 밖일 경우 continue;
						}
						if(map[nr][nc] == -1) continue; //청정기 있으면 확산 불가
						
						//확산될 미세먼지 양
						m = map[i][j] / 5;
						tmp_map[nr][nc] += m;
						cnt++;
					}
					tmp_map[i][j] = tmp_map[i][j] + (map[i][j] - (m * cnt)); 
//					System.out.println("(i, j): "+i+","+j+ " map: "+ map[i][j]);
				}//if 1 끝
				if(map[i][j] == -1) {
					tmp_map[i][j] = -1;
				}
			}//for c
			
		}//for r
		
	}// 함수 끝

}//class끝
