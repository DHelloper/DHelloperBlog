package _0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact_정도형 {
	static int[][] map;
	static int N,start;
	static boolean visited[];
	static int max,max_count,result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10;t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			map = new int[N+1][N+1];
			max = Integer.MIN_VALUE;
			visited = new boolean[N+1];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N/2; i++)
			{
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}
			bfs(start);
			System.out.println("#"+t+" "+result);
		}
	}
	
	public static void bfs(int start)
	{
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		visited[start] = true; // 시작하는 지점 방문처리
		queue.offer(start); // 시작하는 지점 큐에 삽입
		while(!queue.isEmpty())
		{
			max = Integer.MIN_VALUE;
			int cnt=0;
			for(int depth=1; depth<=queue.size();depth++)
			{
				cnt++;
				
				int cur = queue.poll();
				for(int i=1; i<=N;i++)
				{
					if(!visited[i] && map[cur][i]!=0)
					{
						visited[i] = true;
						queue.offer(i);
						max = Math.max(max, i);
					}
				}
				System.out.print("원소는 ? : "+cur+"\t");
				
			}
			System.out.println("몇층일까? : "+cnt); 
			if(max!=Integer.MIN_VALUE)
			{
				result = max;
			}
		}
	}
}
