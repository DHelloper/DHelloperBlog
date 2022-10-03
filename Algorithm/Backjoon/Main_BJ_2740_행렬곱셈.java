package Study_08_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2740_행렬곱셈 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];
		
		// A 배열 입력받기
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++)
			{
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] B = new int[M][K];
		
		//B 정렬 입력받기
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<K; j++)
			{
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		행렬 곱셈 시작, 
//		A = N * M
//		B = M * K 이기 때문에,
//		C = N * K 의 크기
		int[][] C = new int[N][K];
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<K; j++)
			{
				for(int k=0; k<M; k++)
				{
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		for(int i=0; i<N; i++)
		{
			for (int j=0; j<K; j++)
			{
				System.out.print(C[i][j]+" ");
			}
			System.out.println();
		}
	}
}
