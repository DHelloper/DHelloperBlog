package _0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_부녀회장이될테야 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] apt = new int[15][15];
		apt[0][0] = 1;
		int T = Integer.parseInt(st.nextToken());
		for(int i=0; i<15;i++)
		{
			apt[i][1] = 1;	// i층 1호
			apt[0][i] = i;	// 0층 i호

		}
		for(int i=1; i<15;i++)
		{
			for (int j=2; j<15;j++)
			{
				apt[i][j] = apt[i][j-1] + apt[i-1][j];
			}
		}
		for(int t=0;t<T;t++)
		{
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			System.out.println(apt[k][n]);
		}
	}

}
//a층의 b호에 살려면, a-1층의 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다.
//아파트에 비어있는 집은 없고, 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때,
//양의정수 k와 n에 대해, k층에 n호에는 몇명이 살고 있는지 출력하라.
//단, 아파트는 0층부터 있고, 각 층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
