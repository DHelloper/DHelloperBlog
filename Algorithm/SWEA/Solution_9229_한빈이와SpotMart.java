package _0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart_정도형 {
	static int[] sum, arr;
	static int N, result,weight;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int i=0; i<T; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			arr = new int[N+2];
			sum = new int[2];
			result=0;
			st = new StringTokenizer(br.readLine()," ");
			
			//과자 무게 입력
			for(int j=1; j<=N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			//과자 봉지가 2개밖에 없을 경우.
			if(N==2) {
				if(arr[1]+arr[2]<=weight) result = arr[1]+arr[2];
			}
			else comb(0,1);
			
			//결과 출력
			if(result==0) sb.append("#"+(i+1)+" -1\n");
			else sb.append("#"+(i+1)+" "+result+"\n");
		}
		System.out.println(sb);
	}
	static void comb(int cnt, int start) {
		int sum2=0;
		if(cnt==2) {
			sum2 = sum[0] + sum[1];
			if(sum2<=weight) result = Math.max(result, sum2);
			return;
		}
		for(int i = start; i<=N; i++) {
			sum[cnt] = arr[i];
			comb(cnt+1, i+1);
		}		
	}
}
