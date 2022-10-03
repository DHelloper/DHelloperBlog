package _0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_피보나치함수 {
	static int dp_one[];
	static int dp_zero[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=0; t<T; t++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			dp_one = new int[41];
			dp_zero = new int[41];
			dp_zero[0] = 1;
			dp_zero[1] = 0;
			dp_one[0] = 0;
			dp_one[1] = 1;
			
			 for(int k = 2; k <= n; k++){
	                dp_zero[k] = dp_zero[k-1] + dp_zero[k-2];
	                dp_one[k] = dp_one[k-1] + dp_one[k-2];
	            }
			System.out.println(dp_zero[n]+" "+dp_one[n]);
		}
	}
}
