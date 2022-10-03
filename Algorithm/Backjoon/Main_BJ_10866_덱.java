package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_Backjoon_10866_덱 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		Deque<Integer> que = new LinkedList<>();
		String str;
		int x=0;
		for(int i=0; i<N; i++)
		{
			str = br.readLine();
			if(str.contains("push_front")) 
			{
				st = new StringTokenizer(str," ");
				str = st.nextToken();
				x = Integer.parseInt(st.nextToken());
				que.addFirst(x);
			}
			else if(str.contains("push_back")) 
			{
				st = new StringTokenizer(str," ");
				str = st.nextToken();
				x = Integer.parseInt(st.nextToken());
				que.addLast(x);
			}
			else if(str.equals("front"))
			{
				if(que.isEmpty()) sb.append(-1+"\n");
				else {
					sb.append(que.peekFirst()+"\n");
				}
				
			}
			else if(str.equals("pop_front")) 
			{
				if(que.isEmpty()) sb.append(-1+"\n");
				else {
					sb.append(que.pollFirst()+"\n");
				}
			}
			else if(str.equals("pop_back")) 
			{
				if(que.isEmpty()) sb.append(-1+"\n");
				else {
					sb.append(que.pollLast()+"\n");
				}
			}
			else if(str.equals("size")) sb.append(que.size()+"\n"); 
			else if(str.equals("empty")) sb.append((que.isEmpty()?1:0)+"\n"); 
			else if(str.equals("back")) 
			{
				if(que.isEmpty()) sb.append(-1+"\n");
				else {
					sb.append(que.peekLast()+"\n");
				}
			}
		}
		System.out.println(sb);
	}
}
