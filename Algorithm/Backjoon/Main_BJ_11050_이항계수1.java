package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Backjoon_11050_이항계수1 {
	static int N,R,result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		nCr(N,R);
		System.out.println(result);
	}
	static int nCr(int n, int r) {
		if (r == 0 || r == n) {
			result++;
			return 1;
		}
		return nCr(n - 1, r) + nCr(n - 1, r - 1);

	}

}
