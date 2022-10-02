package _0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17281_야구 {
	static class Player
	{
		int player_num;
		int innings;
		int score;
		public Player(int player_num, int innings, int score) {
			super();
			this.player_num = player_num;
			this.innings = innings;
			this.score = score;
		}
	}
	
	static int[] player_num = new int[9];
	static int[] hit_perm = new int[9];
	static boolean[] check = new boolean[9];
	static Queue<Integer> hit_que;
	static Player[][] player;
	static int N,max;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		player = new Player[N][9];
		max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<9; j++)
			{
				player[i][j] = new Player(j,i,Integer.parseInt(st.nextToken()));
			}
		}
		for(int i=0; i<9; i++)
		{
			player_num[i] = i;
		}
		do {
			if(player_num[3] == 0)
			{
				hit_que = new LinkedList<>();
				for(int i=0; i<9; i++)
				{
					hit_que.add(player_num[i]);
				}
				play();
			}
		}while(np());
		
		System.out.println(max);
	}
	
	
	
	public static boolean np() { // numbers 배열의 상태를 근거로 다음 순열 생성, 다음 순열이 존재하면 true, 아니면 false
		
		int N =player_num.length;
		// 1. 꼭대기 찾기
		int i=N-1;
		while(i>0 && player_num[i-1]>=player_num[i]) --i;
		
		if(i==0) return false; // 내가 가장 크기 때문에 만들 수 있는 가장 큰 순열이 되었음, 다음 순열을 만들 수 없음
		
		//2. 꼭대기의 바로 앞자리(i-1)의 값을 크게 만들 교환 값 뒤쪽에서 찾기
		int j = N-1;
		while(player_num[i-1]>=player_num[j]) --j;
		
		//3. i-1 위치값과 j 위치값 교환
		swap(player_num, i-1, j);
		
		//4. i위치부터 맨 뒤까지의 수열을 가장 작은 형태의 오름차순으로 변경
		int k = N-1;
		while(i<k)
		{
			swap(player_num, i++, k--);
		}
		return true;
	}
	
	
	public static void swap(int[] numbers, int i, int j)
	{
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
		
	}
	
	public static void play()
	{
		int sum=0;
		for(int innings=0; innings<N;innings++)
		{
			int cnt = 0;
			int base_1 = 0;
			int base_2 = 0;
			int base_3 = 0;
			A : while(true)
			{
				for(int i=0; i<9;i++)
				{
					int hit_num = hit_que.poll();
					if(player[innings][hit_num].score == 0)
					{
//						System.out.println("아웃");
						cnt++;
					}
					else if(player[innings][hit_num].score == 1)
					{
						if(base_3 == 1)
						{
							sum+=1;
							base_3=0;
						}
						if(base_2 == 1)
						{
							base_2 = 0;
							base_3 = 1;
						}
						if(base_1 == 1)
						{
							base_1 = 0;
							base_2 = 1;
						}
						base_1=1;
					}
					else if(player[innings][hit_num].score == 2)
					{
						if(base_3 == 1)
						{
							sum+=1;
							base_3=0;
						}
						if(base_2 == 1)
						{
							sum+=1;
							base_2 = 0;
						}
						if(base_1 == 1)
						{
							base_3 = 1;
							base_1 = 0;
						}
						base_2 = 1;
					}
					else if(player[innings][hit_num].score==3)
					{
						if(base_3 == 1)
						{
							sum+=1;
							base_3 = 0;
						}
						if(base_2 == 1)
						{
							sum+=1;
							base_2 = 0;
						}
						if(base_1 == 1)
						{
							sum+=1;
							base_1 = 0;
						}
						base_3=1;
					}
					else if(player[innings][hit_num].score==4)
					{
						sum += base_1+base_2+base_3+1;
						base_1=0;
						base_2=0;
						base_3=0;
					}
					if(cnt==3)
					{
						hit_que.add(hit_num);
						break A;
					}
					hit_que.add(hit_num);
				}
			}
			
		}
		max = Math.max(max, sum);
	}
}
