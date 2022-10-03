package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_15486_퇴사2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		// 일하는데 걸리는 일수에 대한 정보
		int[] T = new int[N+2];
		// 일을 했을 때 받는 보수에 대한 정보
		int[] P = new int[N+2];
		//계산 결과값을 갱신하며 최댓값 계산을 위한 dp 배열 생성
		int[] dp = new int[N+2];
		int max =0;
		int max2=0;
		for(int i=1; i<=N; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=N; i++)
		{
			//만약 max보다 dp[i]가 크다면, max를 dp[i]로 바꿈
			//처음엔 max, dp[1] 모두 0이기에 max는 0으로 유지, 점점 값을 계산해 나가며 max가 갱신됨
			if(max<dp[i])
			{
				max = dp[i];
			}
			//현재 날짜에 T[i]를 더해서 일이 끝나는 날짜를 가리킴
			int day = i+T[i];
			if(day<=N+1) //범위 체크
			{
				//일이 끝나는 날, 기존에 저장되어 있는 dp[day]의 값과 현재까지 번 금액에 P[i]를 더해서 더 큰값을 저장
				/*
				 
				       1  2  3  4  5  6  7
				 T[i]  3  5  1  1  2  4  2
				 P[i] 10 20 10 20 15 40 200
				dp[i]  0  0  0  0  0  0  0 

				i==1일 때,
				dp[1] = 0 이므로 max = 0
				day = 1+3
				dp[4] = Math.max(0, 0+10);
				
				       1  2  3  4  5  6  7
				 T[i]  3  5  1  1  2  4  2
				 P[i] 10 20 10 20 15 40 200
				dp[i]  0  0  0 10  0  0  0
				
				i==2일 때,
				dp[2] = 0 이므로 max = 0
				day = 2+5
				dp[7] = Math.max(0, 0+20);
				
		 			   1  2  3  4  5  6  7
				 T[i]  3  5  1  1  2  4  2
				 P[i] 10 20 10 20 15 40 200
				dp[i]  0  0  0 10  0  0  20
				
				i==3일 때,
				dp[3] = 0 이므로 max = 0
				day = 3+1
				dp[4] = Math.max(10, 0+10);
				dp[4]에는 기존에 10이 들어있었기 때문에 (10,0+10)이지만, 같은 값이기에 변하지 않음.
				
		 			   1  2  3  4  5  6  7
				 T[i]  3  5  1  1  2  4  2
				 P[i] 10 20 10 20 15 40 200
				dp[i]  0  0  0 10  0  0  20
				
				*/
				dp[day] = Math.max(dp[day], max+P[i]);
				//그 중 가장 큰 값을 저장해놓고 출력하면 가장 많이 벌 수 있는 금액이 나옴
				max2 = Math.max(max2, dp[day]);
			}
		}
		System.out.println(max2);
		
	}

}
