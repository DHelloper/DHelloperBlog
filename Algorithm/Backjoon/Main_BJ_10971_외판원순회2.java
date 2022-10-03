package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_10971_외판원순회2_정도형 {
	static int[][] map;
	static int N;
	static int[] result;
	static boolean[] check;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		check = new boolean[N];
		result = new int[N];
		int sum=0;
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++)
		{
			dfs(i,i,0,0);
		}
		System.out.println(min);
	}

	public static void dfs(int start, int i, int cnt, int sum) {
		//start가 i가 되면, 시작 지점으로 돌아왔다는 뜻
		if(cnt == N && start==i) {
			//최솟값
			min = Math.min(min, sum);
			return;
		}
		
		for(int idx=0; idx<N; idx++) {
			//만약 값이 0이면 무시하고 넘김
			if(map[i][idx]==0)
				continue;
			
			//DFS 탐색 진행
			if(!check[i] && map[i][idx]>0) {
				check[i] = true;
				sum += map[i][idx];
				dfs(start, idx, cnt+1, sum);
				check[i] = false;
				sum -= map[i][idx];
			}
		}
    }
}
