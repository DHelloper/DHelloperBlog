package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Backjoon_14501_퇴사 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+2][2];
		int data =0;
		int max = 0;
		for(int i=1; i<=N; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<2;j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) 
		{
			data=0;
			for(int j=1; j<=N; j++) 
			{
				if(i+j>N) break;
				if(i+j==N) {
					if(arr[i+j][0] == 1) {
					}
					else break;
				}
				data += arr[i+j][1];
				j += arr[i+j][0]-1;
				
	
			}
			max = Math.max(max, data);
		}
		System.out.println(max);
	}

}
