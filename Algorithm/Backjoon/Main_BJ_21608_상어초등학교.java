 package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_21608_상어초등학교 {

	static int[][] map, friends;
	static int N,set_x,set_y,i;
	static int[][] deltas = {{-1,0},{0,-1},{0,1},{1,0}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		map = new int[N+2][N+2];
		friends = new int[N*N+1][N+2];
		int x = 0;
		int y = 0;
		for(i=1; i<=N*N; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			if(i==1)
			{
				map[2][2] = Integer.parseInt(st.nextToken());
				for(int j=1; j<=4;j++)
				{
					friends[1][j] = Integer.parseInt(st.nextToken());
				}
				set_x = 2;
				set_y = 2;
			}
			else{
				System.out.println(i+"번째");
				map[set_x][set_y] = Integer.parseInt(st.nextToken());
				for(int j=1; j<=4;j++)
				{
					friends[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			find(set_x,set_y);
		}
		System.out.println(Arrays.deepToString(map));
		System.out.println(Arrays.deepToString(friends));
	}
	public static void set(int x, int y) {
		
	}
	public static void find(int x,int y) {
		int r = x;
		int c = y;
		int max = Integer.MIN_VALUE; 
		for(int i=0; i<4; i++)
		{
			r+=deltas[i][0];
			c+=deltas[i][1];
			System.out.println("x : "+r + " y : "+c);
			find_friends();
			if(0<r && r<=N && 0<c && c<=N && map[r][c]==0)
			{
				int check = Math.max(max, check(r,c));
				System.out.println(check);
				if(max<check)
				{
					max = check;
					set_x = r;
					set_y = c;
				}
			}
			r-=deltas[i][0];
			c-=deltas[i][1];
		}
		System.out.println("다음 위치  x : "+set_x + " y : "+set_y);
//		map[set_x][set_y] = 3; 
//		System.out.println(max);
	}
	public static int check(int x, int y)
	{
		int r = x;
		int c = y;
		int cnt=0;
		int cnt_2=0;
		for(int i=0; i<4; i++)
		{
			r+=deltas[i][0];
			c+=deltas[i][1];
			if(0<r && r<=N && 0<c && c<=N && map[r][c]==0)
			{
				cnt_2++;
			}
			r-=deltas[i][0];
			c-=deltas[i][1];
		}
		return Math.max(cnt, cnt_2);
	}
	public static void find_friends()
	{
		for(int i=1; i<=N; i++)
		{
			for(int j=1; j<=N; j++)
			{
				int cnt = 0;
				for(int k=0; k<4;k++)
				{
					int r = i+deltas[k][0];
					int c = j+deltas[k][1];
					if(0<r && r<=N && 0<c && c<=N)
					{
						
					}
					r=i-deltas[k][0];
					c=j-deltas[k][1];
				}
//				System.out.println(i+", "+j+" 중 인접한 친구의 값 : "+cnt);
			}
		}

	}
}
