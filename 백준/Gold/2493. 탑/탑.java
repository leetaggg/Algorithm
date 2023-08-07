import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		Stack<Integer> stack = new Stack<Integer>(); // 탑의 인덱스
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			// 탑의 값을 입력 받아서 arr 저장
			arr[i] = Integer.parseInt(st.nextToken());
			// 스택에 나보다 작은 높이의 탑은 꺼내서 버리기(pop()) : 언제까지 반복?
			// 		공백 스택일 때까지  or 스택에 나보다 크거나 같은 탑이 남아 있을때까지
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stack.pop(); // 꺼내 버리기
			}
			if(stack.isEmpty()) { // 공백 스택
				sb.append("0 ");
			} else {
				sb.append(stack.peek() + " ");
			}
			stack.push(i);
		}
		System.out.println(sb.toString());
	}
}