package _0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS와BFS {
	static int N, M, V;
	static int arr[][];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=M; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[to][from] = arr[from][to] = 1; // 무향 그래프
		}
		dfs(V);
		System.out.println();
		bfs(V);
	}
	
	private static void dfs(int cur) {
		
		visited[cur] = true;
		
		System.out.print(cur+" ");
		for(int i=1; i<=N; i++)
		{
			if(!visited[i] && arr[cur][i]!=0)
			{
				dfs(i);
			}
		}
	}
	
	private static void bfs(int cur) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		visited[cur] = true;
		queue.offer(cur);
		// 큐에 V가 먼저 들어가고 방문처리, 
		/*
		 * 	 1 2 3 4
		 * 1 0 1 1 1
		 * 2 1 0 0 1
		 * 3 1 0 0 1
		 * 4 1 1 1 0
		 */
		while(!queue.isEmpty()) {
			cur = queue.poll();
			System.out.print(cur+" ");
			for(int i=1; i<=N; i++)
			{
				if(!visited[i] && arr[cur][i]!=0)
				{
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		System.out.println();
	}

}
