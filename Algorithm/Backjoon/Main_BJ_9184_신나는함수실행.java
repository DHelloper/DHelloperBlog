package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9184_신나는함수실행 {
	static int[] arr = new int[3];
	static int[][][] dp = new int[21][21][21]; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A :while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<3;i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			if(arr[0]==-1 && arr[1] == -1 && arr[2] == -1)
			{
				break A;
			}
			System.out.println("w("+arr[0]+", "+arr[1]+", "+arr[2]+") = "+w(arr[0],arr[1],arr[2]));
			
		}
		
	}
	public static int w(int a, int b, int c)
	{
		//a,b,c의 범위를 0 ~ 20까지로 지정해주고, dp[a][b][c]에 값이 차 있을 때는 있는 값을 꺼내 줌
		if(a<=20 && b<=20 && c<=20 && 0<=a && 0<=b && 0<=c && dp[a][b][c]>0)
		{
			return dp[a][b][c];
		}
		//0보다 작을 경우는 그냥 1 리턴
		if(a <= 0 || b <= 0 || c <= 0)
		{
			return 1;
		}
		//20보다 큰 경우는 w[20][20][20]으로 고정 후 dp에 값 넣어줌
		if(a > 20 || b > 20 || c > 20)
		{
			dp[20][20][20] = w(20,20,20);
			return dp[20][20][20];
		}
		//dp[a][b][c]에 해당 결과 값 넣어 줌
		if(a < b && b < c)
		{
			dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c); 
			return dp[a][b][c];
		}
		//해당하지 않는다면 주어진 식을 수행하고 나온 결과를 dp[a][b][c]에 넣어줌
		else {
			dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
			return dp[a][b][c];
		}
	}
}
