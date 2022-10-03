package _0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21610_마법사상어와비바라기 {
	
	static class Cloud
	{
		int x,y;

		public Cloud(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int[][] deltas = {{0,0},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
	static int[][] deltas2 = {{-1,-1},{-1,1},{1,1},{1,-1}};
	static int[][] map;
	static boolean[][] check;
	static int N,M;
	static Queue<Cloud> que = new LinkedList<>();
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int sum=0;
		for(int i=0; i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++)
			{
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		que.offer(new Cloud(N-1,0));
		que.offer(new Cloud(N-1,1));
		que.offer(new Cloud(N-2,0));
		que.offer(new Cloud(N-2,1));
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			move(a,b);
		}
//		move(1,3);
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
	
	public static void move(int dir, int cnt)
	{
		int size= que.size();
		for(int i=0; i<size;i++)
		{
			Cloud select_cloud = que.poll();
			int r = select_cloud.x;
			int c = select_cloud.y;
			
			for(int j=0; j<cnt;j++)
			{
				r  = select_cloud.x+deltas[dir][0];
				c  = select_cloud.y+deltas[dir][1];
				if(r<0)
				{
					r = N-1;
				}
				if(c<0)
				{
					c = N-1;
				}
				if(N<=r) 
				{
					r = 0;
				}
				if(N<=c)
				{
					c = 0;
				}
				select_cloud.x = r;
				select_cloud.y = c;
				
			}
			que.add(new Cloud(r,c));
		}
		drop_rain(que);
		copy_water(que);
	}
	public static void drop_rain(Queue<Cloud> que)
	{
		int size = que.size();
		for(int i=0; i<size; i++)
		{
			Cloud cloud = que.poll();
			map[cloud.x][cloud.y] +=1;
			que.add(new Cloud(cloud.x, cloud.y));
		}

	}
	public static void copy_water(Queue<Cloud> que)
	{
		int size = que.size();
		check = new boolean[N][N]; 
		for(int i=0; i<size; i++)
		{
			Cloud cloud = que.poll();
			for(int j=0; j<4; j++)
			{
				int r = cloud.x+deltas2[j][0];
				int c = cloud.y+deltas2[j][1];
				if(0<=r && r<N && 0<=c && c<N && map[r][c]!=0)
				{
					map[cloud.x][cloud.y] +=1;
				}
				check[cloud.x][cloud.y] = true;
			}
		}
		create_cloud();
	}
	public static void create_cloud()
	{
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(!check[i][j]&&map[i][j] > 1)
				{
					que.offer(new Cloud(i,j));
					map[i][j] -=2; 
				}
			}
		}
	}
	public static void printarr(int[][] map)
	{
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
