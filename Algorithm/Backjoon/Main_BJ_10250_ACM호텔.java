package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Backjoon_10250_ACM호텔 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t=1; t<=T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
//			System.out.println(N%H);
//			System.out.println(N/H+1);
			if(N%H==0) {
				System.out.println((H*100)+(N/H));
			}
			else {
				System.out.println((N%H)*100+(N/H+1));
			}
			
			
		}
	}

}
