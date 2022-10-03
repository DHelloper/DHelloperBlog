package _0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Backjoon_1010_다리놓기 {
	static boolean[] check;
	static int N,R;
	static int[][] result = new int[31][31];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int t=1; t<=T; t++)
		{
			st = new StringTokenizer(br.readLine()," ");
			R = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(N==R) {
				System.out.println(1);
				continue;
			}
			else if(R==1)
			{
				System.out.println(N);
				continue;
			}
			System.out.println(comb(N, R));
		}

	}
	static int comb(int N, int R)
	{
		if(result[N][R]>0)
		{
			return result[N][R];
		}
		if(R==0 || N==R)
		{
			return 1;
		}
		result[N][R] = comb(N-1, R-1) + comb(N-1, R);
		return result[N][R];
	}

}
