package Study_08_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11053_가잔긴증가하는부분수열 {
	static int N;
	static int[] dp,arr; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int temp=0;
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		// 카운트용 배열
		dp = new int[N];
		
		// 자기 자신을 포함하면 최소 길이는 무조건 1이기에 0번째에 1을 넣어줌
		dp[0] = 1;
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++)
		{
			//최솟값 설정.
			if(arr[i]<min)
			{
				min = arr[i];
			}
			//만약 i가 범위 안이고, 현재 가리키는 숫자가 최솟값 보다 클 경우
			if(i>0&&arr[i]>min)
			{
				/*
				 * dp_arr(arr[1],i,1)을 수행할 경우,
				 * arr의 처음부터 해당 인덱스 까지 arr[i]보다 작은 수를 카운트해서 되돌려줌. 그렇기 때문에 +1 해주면 자기 자신의 길이가 나옴 
				 */
				int dp_cnt = dp_arr(arr[i],i)+1;
				// dp[i]에 결과값 저장.
				dp[i] = dp_cnt;
			}
			else
			{
				// 자기 자신이 최솟값이라면. i번째의 부분 수열의 길이는 1.
				dp[i] = 1;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++)
		{
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	public static int dp_arr(int num,int index) {
		// 더 큰 값을 구하기 위해 max변수를 MIN 값으로 선언.
		int max = Integer.MIN_VALUE;
		// 0번째부터 입력받아온 index까지 반복
		for(int i=0; i<index;i++)
		{
			// 만약 arr[i]보다 num이 더 클 경우.
			// dp[i]에 있는 값과 max를 서로 비교해 보며 max 갱신
			if(arr[i]<num)
			{
				//해당 과정에서 자기 자신보다 바로 아랫 단계의 dp값을 가져올 수 있음
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}

}
