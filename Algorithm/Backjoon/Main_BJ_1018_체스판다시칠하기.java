package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Backjoon_1018 {
	public static boolean[][] check;
	public static int min=64;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		check = new boolean[N][M];
		for(int i=0; i<N; i++)
		{
			String str = br.readLine();
			for(int j=0; j<M; j++)
			{
				if(str.charAt(j) == 'W')
				{
					check[i][j] = true;
				}
				else
				{
					check[i][j] = false;
				}
			}
			
		}
		
		int N_row = N-7;
		int M_col = M-7;
		
		for(int i=0; i<N_row;i++)
		{
			for(int j=0; j<M_col;j++)
			{
				find(i,j);
			}
		}
		System.out.println(min);
	}
	public static void find(int x, int y)
	{
		int end_x = x+8;
		int end_y = y+8;
		int count=0;
		boolean first = check[x][y];
		for(int i=x; i<end_x; i++)
		{
			for(int j=y;j<end_y;j++)
			{
				if(check[i][j]!=first)
				{
					count++;
				}
				first = !first;
			}
			first = !first;
		}
		count = Math.min(count, 64-count);
		min = Math.min(min, count);
	}

}
