import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); //명령의 수
			
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			
			if(command == 1) { //정수 x를 넣는다.
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				
			}else if(command == 2) { //스택에 정수가 있다면 맨위 정수를 빼고 출력한다. pop(), 없다면 -1출력
				if(!stack.isEmpty()) {
					sb.append(stack.pop()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				
			}else if(command == 3) { //스택에 들어있는 정수의 개수를 출력
				sb.append(stack.size()).append("\n");
				
			}else if(command == 4) { //비어있어면 1, 아니면 0 출력
				if(stack.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				
			}else if(command == 5) { //스택에 정수가 있다면 맨위의 정수를 출력, 없다면 -1 , peek()
				if(!stack.isEmpty()) {
					sb.append(stack.peek()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
			}
			
		} //end for
		
		System.out.println(sb.toString());
		
	}//end main

}//end class
