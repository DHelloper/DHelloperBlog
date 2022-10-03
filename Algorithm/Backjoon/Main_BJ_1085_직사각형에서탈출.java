package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Backjoon_1085 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		double x_w = w/2;
		double y_h = h/2;
		
		if(x_w<x) 
		{
			x = w-x;
		}
		if(y_h<y)
		{
			y = h-y;
		}
		System.out.println(Math.min(x, y));
		
	}

}



//import java.util.*;
//interface Main
//{
//	static void main(String[]a)
//	{
//		Scanner s=new Scanner(System.in);
//		int A[]={0,0,0,0},i=0;
//		while(i<4)A[i]=s.nextInt()-A[i++%2];
//		System.out.print(Arrays.stream(A).min().getAsInt());
//	}
//}