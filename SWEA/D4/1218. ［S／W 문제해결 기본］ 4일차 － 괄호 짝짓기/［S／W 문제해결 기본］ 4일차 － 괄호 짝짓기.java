import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = 10;
		
		for (int t = 1; t <= test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			String buckets = br.readLine();
			
			if(isValid(buckets, n)) {
				 sb.append("#").append(t).append(" ").append(1).append("\n");
			}else {
				sb.append("#").append(t).append(" ").append(0).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	private static boolean isValid(String buckets, int n) {
		char[] stack = new char[n];
		int top = -1;
		
		for (int i = 0; i < buckets.length(); i++) {
			char bucket = buckets.charAt(i);
			
			switch(bucket) {
				case '(':
				case '[':
				case '{':
				case '<':
					stack[++top] = bucket;
					continue;
			}
			if(top < 0) {
				return false;
			}
			
			switch(bucket) {
				case ')':
					if(stack[top--] != '(') {
						return false;
					}
					break;
				case ']':
					if(stack[top--] != '[') {
						return false;
					}
					break;
				case '}':
					if(stack[top--] != '{') {
						return false;
					}
					break;
				case '>':
					if(stack[top--] != '<') {
						return false;
					}
					break;
			}
					
		}
		return top < 0;
	}

}
