package _0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1182_부분수열의합 {

	static int result,N,S;
	static int[] arr,result_arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		result_arr = new int[N];
		for (int i=0; i<N; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		dfs(0,0);
		if(S==0)
		{
			result--;
		}
		System.out.println(result);
	}
	public static void dfs(int cnt,int sum_dfs)
	{
		if(cnt==N)
		{
			if(sum_dfs==S)
			{
				result++;
//				if(S==0)
//				{
//					result--;
//				}
			}
			
//			System.out.println(Arrays.toString(result_arr));
//			System.out.println(sum_dfs);
			return;
		}
		result_arr[cnt] = 0;
		dfs(cnt+1,sum_dfs);
		result_arr[cnt] = arr[cnt]; 
		dfs(cnt+1,sum_dfs+arr[cnt]);
	}

}
