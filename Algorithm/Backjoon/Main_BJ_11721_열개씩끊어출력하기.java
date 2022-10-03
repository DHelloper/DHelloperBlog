package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Backjoon_11721_열개씩끊어출력하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		String str = st.nextToken();
		for(int i=1; i<=str.length(); i++) {
			System.out.print(str.charAt(i-1));
			if(i%10==0) {
				System.out.println();
			}
			
		}
		
	}

}
