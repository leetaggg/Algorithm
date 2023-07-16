import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		int sec = Integer.parseInt(st.nextToken());
		
		int time = Integer.parseInt(br.readLine());
		
		sec = sec + time;
		
		if(sec >= 60) {
			min = min + (sec / 60);
			sec = (sec % 60);
		}
		if(min >= 60) {
			hour = hour + (min / 60);
			min = (min % 60);
		}
		if(hour >= 24) {
			hour = hour % 24;
		}
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb.append(hour).append(" ").append(min).append(" ").append(sec);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
