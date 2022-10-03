package _0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2xn타일링 {
	static long[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		dp  = new long[n+1];
		System.out.println(fib(n));
	}
	public static long fib(int n)
	{
		if(n<3)
		{
			return n;
		}
		if(dp[n]>0)
		{
			return dp[n];
		}
		dp[n] = (fib(n-1) + fib(n-2)) % 10007;
        // 나머지를 해서 저장해야 값이 변하기 전에 담을 수 있음.
        return dp[n];
	}

}
