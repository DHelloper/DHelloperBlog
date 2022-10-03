package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Backjoon_5622_다이얼 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"");
		String[] test = {"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		String str = st.nextToken();
		
		for(int i=0; i<str.length();i++) {
			for(int j=0; j<test.length;j++) {
				if(test[j].contains(""+str.charAt(i))) {
					sum+=j+1;
				}
			}
		}
		System.out.println(sum);
	}
}
