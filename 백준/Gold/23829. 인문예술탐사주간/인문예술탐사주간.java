import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	private static long[] arr;
	private static int[] trees;
	private static int n;
	private static int q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		trees = new int[n+1];
		arr = new long[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(trees);
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i-1]+trees[i];
		}
		for (int i = 0; i < q; i++) { 
			long x = Integer.parseInt(br.readLine());//target
			int start = solved(x);//이진탐색 start점 찾기(trees의 인덱스 점)
			long first;
			long second;
			
			if(trees[start] <= x) {
				first = x*(start) - arr[start]; 
				second = (arr[n] - arr[start]) - ((long)x*(n-start));
			}else {
				first = x*(start-1) - (arr[start-1]); 
				second = (arr[n] - arr[start-1]) - ((long)x*(n-start+1));
			}
			long answer = first + second;
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}//end main

	private static int solved(long target) {
		int l = 1;
		int r = n;
		int mid = 0;
		
		while(l <= r) {
			mid = (l+r)/2;
			
			if(trees[mid] < target) {
				l =  mid + 1;
			}else if(trees[mid] > target){
				r = mid - 1;
			}else {
				break;
			}
		}
		
		return mid;
		
	}
	
}//end class
