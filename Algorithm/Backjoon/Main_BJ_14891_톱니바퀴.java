package Study_09_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_14891_톱니바퀴 {

	static int[][] arr = new int[4][8];
	static int N,M,sum; 
	static int[] deltas= {-1,1};
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<4; i++)
		{
			char[] temp = br.readLine().toCharArray();
			//입력 값 정수형으로 변경
			for(int j=0; j<temp.length; j++)
			{
				arr[i][j] = temp[j]-'0';				
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		//톱니바퀴 선택, 회전 방향 입력
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int target = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			//방문배열을 매번 초기화
			visited = new boolean[4];
			//rotate 함수에 톱니바퀴 번호와 회전 방향 넘겨줌
			rotate(target,dir);
		}
		//현재 톱니바퀴 상태로 결과값을 구하는 함수
		result_sum();
		//결과 출력
		System.out.println(sum);
		
	}
	
	//회전 함수
	public static void rotate(int target, int dir) {
		//왼쪽 오른쪽 탐색을 위한 left, right 선언
		int left = target-1;
		int right = target+1;
		//해당 톱니바퀴 방문처리
		visited[target] = true;
		
		//만약 범위 안에 있고, 방문되지 않았으며, 현재 배열의 6번째 인덱스와 왼쪽 배열의 2번째 인덱스가 다르다면
		//만약 왼쪽의 톱니바퀴가 돌아가야 한다면.
		if(0<=left && !visited[left] && arr[target][6]!=arr[left][2])
		{
			//왼쪽의 톱니바퀴를 인자로 주고, 방향을 *-1을 해줌으로써 반대 방향으로 돌 수 있도록 함
			rotate(left,dir*-1);
			
		}
		
		//만약 범위 안에 있고, 방문되지 않았으며, 현재 배열의 2번째 인덱스와 오른쪽 배열의 6번째 인덱스가 다르다면
		//만약 오른쪽의 톱니바퀴가 돌아가야 한다면.
		if(right < 4 && !visited[right]&& arr[target][2]!=arr[right][6])
		{
			//오른쪽의 톱니바퀴를 인자로 주고, 방향을 *-1 해줌으로써 반대 방향으로 돌 수 있도록 함
			rotate(right,dir*-1);
			
		}
		//톱니바퀴 회전할 때 인덱스 관리를 위해 deque 사용
		Deque<Integer> deque = new LinkedList<>();
		//deque에 값 삽입
		for(int i=0; i<8; i++)
		{
			deque.add(arr[target][i]);
		}
		//만약 방향이 1(시계방향) 이라면
		if(dir==1)
		{
			//마지막 요소를 뽑아서 맨 앞에다 붙임
			deque.addFirst(deque.pollLast());
		}
		//만약 방향이 -1(반시계방향) 이라면
		else if(dir==-1)
		{
			//처음 요소를 뽑아서 마지막에다 붙임 
			deque.addLast(deque.poll());
		}
		//deque의 사이즈만큼 반복
		int size = deque.size();
		for(int i=0; i<size;i++)
		{
			//배열에 덮어씌우기
			arr[target][i] = deque.poll();
		}
		
	}
	//톱니바퀴 12시방향의 값들을 더하는 함수
	public static void result_sum()
	{
		if(arr[0][0] == 1)
		{
			sum+=1;
		}
		if(arr[1][0] == 1)
		{
			sum+=2;
		}
		if(arr[2][0] == 1)
		{
			sum+=4;
		}
		if(arr[3][0] == 1)
		{
			sum+=8;
		}
	}
}
