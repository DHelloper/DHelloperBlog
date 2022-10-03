package _0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2839_설탕배달_정도형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		while(true)
		{
			if(N%5==0)
			{
				sum+=N/5;
				N = N%5;
			}
			else {
				N -= 3;
				sum+=1;
			}
			
			if(N<0)
			{
				sb.append("-1");
				break;
			}
			else if(N==0) 
			{
				sb.append(sum);
				break;
			}
		}
		System.out.println(sb);
	}

}
