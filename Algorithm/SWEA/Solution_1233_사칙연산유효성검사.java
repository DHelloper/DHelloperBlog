package _0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사_정도형 {
	static char[] node;
	static boolean check;
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			check = true;
			node = new char[N+1];
			for(int i=1; i<=N; i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				st.nextToken();
				node[i] = st.nextToken().charAt(0);
			}
			if(node[1]!='+' && node[1]!='-' && node[1]!='*' && node[1]!='/') 
			{
				check = false;
			}
			check(1);
			if(!check)
			{
				System.out.println("#"+t+" "+0);
			}
			else {
				System.out.println("#"+t+" "+1);
			}
		}
	}
	public static void check(int cnt)
	{
		if(cnt*2+1>=node.length)
		{
			if(N%2==0)
			{
				check = false;
			}
			else {
				if(node[cnt]=='+' || node[cnt]=='-' || node[cnt]=='*' || node[cnt]=='/')
				{
					check = false;
				}				
			}
			return;
		}
		
		if(node[cnt]!='+' && node[cnt]!='-' && node[cnt]!='*' && node[cnt]!='/') {
			if(node[cnt*2]!='+' && node[cnt*2]!='-' && node[cnt*2]!='*' && node[cnt*2]!='/') {
				if(node[cnt*2+1]!='+' && node[cnt*2+1]!='-' && node[cnt*2+1]!='*' && node[cnt*2+1]!='/')
				{
					check = false;
					return;
				}
			}
		}
		check(cnt*2);
		check(cnt*2+1);
		return;
	}
}
