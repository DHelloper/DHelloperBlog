package _0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트_정도형 {
	static int[] burger, result;
	static int[] cal;
	static boolean[] isChecked;
	static int N,L;
	static int max;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int t=1;t<=T; t++)
		{
			max = 0;
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			burger = new int[N];
			cal = new int[N];
			isChecked = new boolean[burger.length];
			result = new int[burger.length];
			for(int i=0; i<N; i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				burger[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			subset(0);
			System.out.println("#"+t+" "+max);
		}
	}
	
	public static void subset(int cnt)
	{
		int sum = 0;
		int sum2 = 0;
		
		if(cnt==cal.length)
		{
			for(int i=0; i<result.length; i++)
			{
				sum+=result[i];
				if(result[i]!=0)
				{
					sum2+=burger[i];
				}
				
			}
			if(sum<=L)
			{
				max = Math.max(sum2, max);
			}
			return;
		}
		isChecked[cnt] = true; // 뽑는다. 방문처리
		result[cnt] = cal[cnt]; // 선택을 했을때는, 해당 위치에 있는 값을 result에 넣는다.
		subset(cnt+1);
		
		isChecked[cnt] = false; // 뽑지 않는다. 방문하지 않는다.
		result[cnt] = 0; // 선택을 하지 않았을 때는, 해당 위치에 있는 값을 넣지 않는다.
		subset(cnt+1);
	}
}
