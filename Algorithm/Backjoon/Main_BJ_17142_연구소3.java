package Study_09_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17142_연구소3 {
	//바이러스의 위치를 담을 Virus 클래스 생성
	public static class Virus{
		int x;
		int y;
		public Virus(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	//조합의 결과를 담을 result
	static int[] result;
	//0~바이러스의 갯수만큼 담아놓을 배열 (조합용)
	static int[] arr;
	//맵을 저장할 2차원 배열
	static int[][] map;
	//방향 델타
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	//N = 맵 크기, M = 바이러스 활성화 갯수, min= 최솟값 저장용
	static int N,M,min;
	//리스트에 virus 저장 ( 몇개 인지 모르기 때문에 )
	static List<Virus> virus = new ArrayList<Virus>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		result = new int[M];
		min = Integer.MAX_VALUE;
		//맵에 0 갯수를 세기 위함 - 맵에 0이 없으면 0 바로 출력하고 끝내면 됨
		int zero=0;
		
		// map에 데이터 입력부분
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				//만약 해당 위치가 바이러스라면?
				if(map[i][j] == 2)
				{
					//리스트에 x,y값 추가
					virus.add(new Virus (i,j));
				}
				//만약 해당 위치가 0이라면 ?
				if(map[i][j] == 0)
				{
					//zero ++ 해줌으로써 0의 갯수가 0이 아니라는 것을 확인함
					zero++;
				}
			}
		}
		//arr(조합용 배열)의 크기는 바이러스의 갯수만큼 주고, 값을 0부터 바이러스 크기만큼 채움
		arr = new int[virus.size()];
		for(int i=0; i<virus.size(); i++)
		{
			arr[i] = i;
		}
		
		//만약 맵에 0이 하나도 없으면 ?
		if(zero==0)
		{
			//바로 0출력하고 종료
			System.out.println(0);
			return;
		}
		//조합 시작
		comb(0,0);
		//만약 최종적인 결과가 MAX_VALUE라면 어떠한 경우에도 모두 감염시킬 수 없다는 뜻
		if(min==Integer.MAX_VALUE)
		{
			//-1 출력 후 종료
			System.out.println(-1);
			return;
		}
		System.out.println(min);
	}
	
	//조합 코드 - 바이러스의 인덱스 번호를 조합해서 뽑는 것
	public static void comb(int cnt,int start)
	{
		if(cnt==M)
		{
			//조합이 완성되면 bfs 실행
			bfs();
			return;
		}
		for(int i=start; i<virus.size(); i++)
		{
			result[cnt] = arr[i];
			comb(cnt+1,i+1);
		}
	}
	
	
	public static void bfs()
	{
		//bfs에 활용할 queue 선언
		Queue<Virus> queue = new ArrayDeque<>();
		//맵 방문처리용 2차원 boolean배열
		boolean[][] visited_bfs = new boolean[N][N];
		//맵에 표시하기 위해 depth를 1부터 시작
		int depth=1;
		//맵 복사
		int[][] map_copy = new int[N][N];
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				map_copy[i][j] = map[i][j];
				//복사하는 도중에 바이러스가 있다면 전부 다 -1로 바꿔줌
				if(map_copy[i][j] == 2)
				{
					map_copy[i][j] = -1;
				}
			}
		}
		//뽑아야 하는 바이러스의 갯수만큼 반복
		for(int i=0; i<result.length; i++)
		{
			//조합의 결과로 얻어낸 숫자들을 바이러스 list의 접근 인덱스로 활용
			int x = virus.get(result[i]).x;
			int y = virus.get(result[i]).y;
			//해당 위치를 1로 바꿈
			//활성화된 바이러스 = 1
			//비활성화 바이러스 = -1
			map_copy[x][y] = 1;
			//큐에 해당 바이러스들의 x,y값을 넣음
			queue.add(new Virus(x,y));
			//해당 바이러스들 방문처리
			visited_bfs[x][y] = true;
		}
		//큐가 빌 때까지 반복
		while(!queue.isEmpty())
		{
			//4방향 탐색을 위한 qSize 선언
			int qSize = queue.size();
			//깊이를 활용하기 위해 for문 하나 씌워줌
			for(int level=0; level<qSize; level++)
			{
				//queue에서 첫번째 바이러스를 뽑음
				Virus temp = queue.poll();
				//방향 탐색 시작
				for(int i=0; i<4;i++)
				{
					int nx = temp.x + deltas[i][0];
					int ny = temp.y + deltas[i][1];
					//범위 안에 있고, 방문하지 않았다면
					if(0<=nx && nx<N && 0<=ny && ny<N && !visited_bfs[nx][ny])
					{
						//만약 가리키는 위치가 0이라면 ? (빈 공간이라면 ?)
						if(map_copy[nx][ny] == 0)
						{
							//바이러스를 확산시킨다는 의미,
							//활성화된 바이러스에서부터 떨어진 거리를 입력
							map_copy[nx][ny] = depth;
							//방문처리
							visited_bfs[nx][ny] = true;
							//큐에 감염시킨 자리를 다시 넣음
							queue.add(new Virus(nx, ny));
						}
						//만약 가리키는 위치가 -1이라면? (비활성 바이러스라면?)
						else if(map_copy[nx][ny]==-1)
						{
							//방문처리하고 큐에 다시 넣음
							visited_bfs[nx][ny] = true;
							queue.add(new Virus(nx,ny));
						}
						//위 과정을 통해 벽을 만난 경우는 que에 다시 저장하지 않고,
						//비활성 바이러스를 만났을 경우에는 깊이를 표시하지 않기 때문에 조건 처리 가능
					}
				}
			}
			//깊이 ++
			depth++;
		}
		//최솟값을 구하는데 비교 대상은 sum함수를 실행해서 리턴된 결과
		min = Math.min(min, sum(map_copy));
	}
	
	//해당 맵에서 가장 큰 값 구하기
	static int sum(int[][] map_copy)
	{
		//비교용 max 변수 선언
		int max = Integer.MIN_VALUE;
		for(int i=0 ;i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				//배열을 돌면서 0이 남아있으면?
				//bfs가 끝났는데 0이 남아 있다는 것은 감염시키지 못하는 위치가 있다는 것. MAX_VALUE를 returnㅎ마
				if(map_copy[i][j]==0)
				{
					return Integer.MAX_VALUE;
				}
				//그게 아니라면 매번 다음 값과 비교하면서 맵에서 가장 큰 값을 찾음
				max = Math.max(max, map_copy[i][j]);
			}
		}
		//맵에서 찾은 가장 큰 값 return
		return max;
	}
}
