package _0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1463_1로만들기_정도형 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N+1];
		
		for(int i=2; i<N+1; i++)
		{
			// N = 3이면 ?
			// dp[2] = dp[1] + 1 ( dp[1]=0 )
			// dp[2] = 1이 됨.
			
			// dp[3] = dp[2] + 1 ( dp[2]=1 )
			// dp[3] = 2가 됨.
			dp[i] = dp[i-1] + 1;
			// dp[2]는 1, dp[1] +1 은 1, dp[2]는 1로 고정
			if (i%2 == 0 && dp[i] > dp[i/2] +1)
				dp[i] = dp[i/2]+1;
			// dp[3]은 2, dp[1] +1은 1, dp[3]은 1이 됨.
			if (i%3 == 0 && dp[i] > dp[i/3] +1)
				dp[i] = dp[i/3]+1;
		}
		System.out.println(dp[N]);
	}
}
