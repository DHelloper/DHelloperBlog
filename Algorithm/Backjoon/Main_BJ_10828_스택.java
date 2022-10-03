package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Backjoon_10828_스택 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++)
		{
			String str = br.readLine();
			if(str.contains("push"))
			{
				st = new StringTokenizer(str," ");
				st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				stack.push(a);
			}
			else if(str.equals("pop"))
			{
				if(stack.size()==0)
				{
					System.out.println(-1);
					continue;
				}
				System.out.println(stack.pop());
			}
			else if(str.equals("size"))
			{
				System.out.println(stack.size());
			}
			else if(str.equals("empty"))
			{
				if(stack.empty())
				{
					System.out.println(1);
					continue;
				}
				System.out.println(0);
			}
			else if(str.equals("top"))
			{
				if(stack.size()==0)
				{
					System.out.println(-1);
					continue;
				}
				System.out.println(stack.peek());
			}
		}
		
	}

}
