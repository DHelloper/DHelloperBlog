package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Backjoon_10816_숫자카드2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int[] check = new int[20000002];
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) 
		{
			check[10000000+Integer.parseInt(st.nextToken())] += 1 ;
		}
		st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<M; i++)
		{
			sb.append(check[10000000+Integer.parseInt(st.nextToken())]).append(" ");
		}
		System.out.println(sb);
	}
}
