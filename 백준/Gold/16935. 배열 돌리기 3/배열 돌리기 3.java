import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr, tempArr;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int turnNum = Integer.parseInt(st.nextToken());
			switch (turnNum) {
			case 1:
				turn1();
				break;
			case 2:
				turn2();
				break;
			case 3:
				turn3();
				break;
			case 4:
				turn4();
				break;
			case 5:
				turn5();
				break;
			case 6:
				turn6();
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void turn1() {
		tempArr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tempArr[N - i - 1][j] = arr[i][j];
			}
		}
		arr = tempArr;
	}

	public static void turn2() {
		tempArr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tempArr[i][M - j - 1] = arr[i][j];
			}
		}
		arr = tempArr;
	}
	
	public static void turn3() {
		tempArr = new int[M][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tempArr[j][N - i - 1] = arr[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		
		arr = tempArr;
	}	
	
	public static void turn4() {
		tempArr = new int[M][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tempArr[M - j - 1][i] = arr[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		
		arr = tempArr;
	}

	public static void turn5() {
		tempArr = new int[N/2][M/2];
		for(int i = 0; i < N / 2; i++) {
			for(int j = M / 2; j < M; j++) {
				tempArr[i][j - M / 2] = arr[i][j]; 
			}
		}
		
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				arr[i][j + M / 2] = arr[i][j];
			}
		}
		for(int i = N / 2; i < N; i++) {
			for(int j = 0; j < M / 2; j++) {
				arr[i - N / 2][j] = arr[i][j];
			}
		}
		for(int i = N / 2; i < N; i++) {
			for(int j = M / 2; j < M; j++) {
				arr[i][j - M / 2] = arr[i][j];
			}
		}
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				arr[i + N / 2][j + M / 2] = tempArr[i][j];
			}
		}
		
	}
	
	public static void turn6() {
		tempArr = new int[N/2][M/2];
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				tempArr[i][j] = arr[i][j];
			}
		}
		for(int i = 0; i < N / 2; i++) {
			for(int j = M/2; j < M ; j++) {
				arr[i][j - M/2] = arr[i][j];
			}
		}
		for(int i = N / 2; i < N; i++) {
			for(int j = M / 2; j < M ; j++) {
				arr[i - N / 2][j] = arr[i][j];
			}
		}
		for(int i = N / 2; i < N; i++) {
			for(int j = 0; j < M/2 ; j++) {
				arr[i][j + M / 2] = arr[i][j];
			}
		}
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M/2 ; j++) {
				arr[i + N / 2][j] = tempArr[i][j];
			}
		}
	}

}
