package _0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16236_아기상어_정도형 {
	static class Shark{
	    int x,y,size,eat,dis;

	    public Shark(int x, int y, int size, int eat, int dis) {
	        this.x = x;
	        this.y = y;
	        this.size = size;
	        this.eat = eat;
	        this.dis = dis;
	    }
	    
	}
	
	static int[][] deltas= {{-1,0},{0,-1},{1,0},{0,1}};
	static boolean[][] visited;
	static int[][] map;
	static int N,sum;
	static Shark shark;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9)
				{
					//처음 상어의 정보를 Shark클래스에 맞게 입력
					shark = new Shark(i,j,2,0,0);
				}
			}
		}
		//BFS 수행
		BFS();
		System.out.println(sum);
	}
	
	public static void BFS() 
	{
		//상어의 정보를 활용할 Queue 선언
		Queue<Shark> que = new LinkedList<>();
		//처음 상어의 상태를 que에 offer
		que.offer(new Shark(shark.x,shark.y,shark.size,shark.eat,shark.dis));
		//상어의 먹잇감의 정보를 상어에 더해서 관리하기 위한 우선순위 큐 선언
		//람다식으로 거리 -> x -> y순으로 정렬
		PriorityQueue<Shark> pq = new PriorityQueue<>((o1,o2) ->  {
			int temp = Integer.compare(o1.dis, o2.dis);
			temp = temp == 0 ? Integer.compare(o1.x, o2.x) : temp;
			return temp == 0 ? Integer.compare(o1.y, o2.y) : temp;
		});
		//먹이가 떨어질 때 까지 반복
		while(true) 
		{
			//현재 상어의 위치를 0으로 바꿔줌 
			map[que.peek().x][que.peek().y] = 0;
			//방문 체크를 위한 visited 선언
			visited = new boolean[N][N];
			//큐가 빌때까지 반복
			while(!que.isEmpty())
			{
				// 상어의 정보를 큐에서 빼냄
				Shark cur = que.poll();
				// 현재 상어의 자리를 방문처리
				visited[cur.x][cur.y] = true;
				// 4방향 탐색을 위한 반복문
				for(int i=0; i<4; i++)
				{
					//현재 위치에 deltas 값 더하기
					int r = cur.x+deltas[i][0];
					int c = cur.y+deltas[i][1];
					// 범위를 벗어나지 않고, 가리키는 곳이 상어의 크기보다 작거나 같고, 방문하지 않았을 경우.
					if(0<=r && r<N && 0<=c && c<N && map[r][c]<=cur.size && !visited[r][c])
	                {
						//만약 가리키는 곳이 0보다 크고 상어의 사이즈보다 작을 때
	                    if(0<map[r][c]&&map[r][c]<cur.size)
	                    {
	                    	// 먹잇감의 정보를 우선순위 큐에 넣음 (먹이를 먹었을 때 변화하는 상어의 상태값)
	                    	// 한번 쭉 탐색하면서 우선순위에 적재하고, 현재 자신보다 가까이 있는것만 활용하고 나머지는 다 제거할 예정
	                        pq.offer(new Shark(r,c,cur.size,cur.eat+1,cur.dis+1));
	                    }
	                    // 이동하는 경우, 상어의 위치와 거리를 update하듯이 큐에 넣음
                        que.offer(new Shark(r,c,cur.size,cur.eat,cur.dis+1));
                        // 방문처리
                        visited[r][c] = true;
	                }
				}
			}
			//만약 먹을 물고기가 없다면 return
			if(pq.isEmpty()) 
			{
				return;
			}
			//EAT을 수행한 상어를 que에 offer
			que.offer(EAT(pq.poll()));
			//뒤에 남아있는 큐들은 다 비움
			pq.clear();
		}
	}
	//제일 가까이 있는 물고기를 먹어야 하기 때문에 우선순위에서 우선순위 큐에서 가장 앞에 있는 것만 poll해서 EAT으로 넘겨줌
	public static Shark EAT(Shark shark)
	{
		//만약 현재 상어의 크기와 상어가 먹은 횟수가 같다면
		if(shark.size == shark.eat)
		{
			//상어 크기 늘려주고 먹은 횟수 0으로 초기화
			shark.size++;
			shark.eat=0;
		}
		//상어가 먹은 물고기의 자리를 0으로 바꿔줌
		map[shark.x][shark.y]=0;
		//상어가 이동한 거리를 sum에 +해줌
		sum += shark.dis;
		//현재 상어의 상태 return
		return new Shark(shark.x,shark.y,shark.size,shark.eat,0);
	}
}
