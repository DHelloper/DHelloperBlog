package Study_09_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_디저트카페 {

	static int[][] map;
	// 대각선 방향의 deltas
	static int[][] deltas = {{1,1},{1,-1},{-1,-1},{-1,1}};
	// T, N, max는 최대로 탐색한 값. result는 각 회차마다의 결과
	static int T, N, max,result;
	// 중복 확인을 위해 리스트 활용
	static List<Integer> check_list;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		//테스트 케이스 시작
		for(int t=1; t<=T; t++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			//max값(최종 결과) 초기화
			max = Integer.MIN_VALUE;
			result=0;
			//중복 체크를 위한 List 생성
			check_list = new ArrayList<>();
			
			//데이터 입력받기. 
			for(int i=0; i<N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//각 위치마다 탐색 시작
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					//리스트에 첫번째 요소를 넣고 DFS 탐색 시작
					check_list.add(map[i][j]);
					DFS(i,j,i,j,0,0);
					//DFS가 끝나면 리스트 비워줌 
					check_list.clear();
				}
			}
			//만약 3보다 작으면 -1 출력
			if(max<3)
				System.out.println("#"+ t +" "+(-1));
			else
			//그게 아니라면 max 출력
				System.out.println("#"+t+" "+max);
		}

	}
	
	//현재의 위치 x,y 시작위치 start_x,start_y
	//몇번 이동했는지 cnt, 방향 dlr 
	public static void DFS(int x, int y,int start_x, int start_y, int cnt, int dir)
	{
		// 4방향 탐색 진행 for문
		A : for(int i=dir; i<4; i++)
		{
			//현재 위치에 방향 값을 더한 r,c
			int r = x+deltas[i][0];
			int c = y+deltas[i][1];
			
			//만약 이동하려는 r과 c가 범위 안이라면.
			if(0<=r && r<N && 0<=c && c<N)
			{
				// 만약 시작지점으로 돌아왔다면?
				if(r==start_x && c==start_y)
				{
					// 자기 자신도 포함해야 하기 때문에 cnt에 1을 더함
					result = cnt+1;
					// result와 max를 비교하여 최댓값만 저장
					max = Math.max(max, result);
					return;
				}
				// 시작지점이 아님
				// check_list 안에 들어 있는 값인지 확인해야 하기 때문에 반복문 돌림
				for(int chk=0; chk<check_list.size();chk++)
				{
					// 만약 가야하는 위치의 디저트의 수가 check_list 안에 있다면?
					if(map[r][c] == check_list.get(chk))
					// 그냥 넘김
						continue A;
				}
				// check_list에도 없는 값이면 추가
				check_list.add(map[r][c]);
				// 쭉 그 방향으로 DFS 진행
				DFS(r,c,start_x,start_y,cnt+1,i);
				// check_list에서 맨 뒤의 값을 빼줌.(더 이상 뻗어 나갈 수 없는 위치의 디저트 수를 빼는 것) 
				check_list.remove(check_list.size()-1);
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
