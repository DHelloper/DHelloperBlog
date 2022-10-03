package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_21318_피아노체조 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N+2];
		//합을 저장해 놓을 miss[] 선언
		int miss[] = new int[N+2];
		st = new StringTokenizer(br.readLine()," ");
		int cnt=0;
		for(int i=1;i<=N;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
			//i가 배열의 범위 안이고 arr의 전 값이 현재의 값보다 클 때
			//N까지이기 때문에 N에서는 count를 하지 않음
			if(i>0&&arr[i]<arr[i-1])
			{
				//실수 횟수 ++
				cnt++;
			}
			//합 저장
			miss[i] = cnt;
		}
		st = new StringTokenizer(br.readLine()," ");
		int Q = Integer.parseInt(st.nextToken());
		for(int i=0; i<Q; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			System.out.println(miss[y]-miss[x]);
		}
	}

}
