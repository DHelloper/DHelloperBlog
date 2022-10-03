package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Backjoon_2475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int sum=0;
		int num=0;
		for(int i =0; i<5; i++)
		{
			num = Integer.parseInt(st.nextToken());
			sum += num*num;
		}
		System.out.println(sum%10);
		
	}
}
