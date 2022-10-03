package _0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_10798_세로읽기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		ArrayList<char[]> list = new ArrayList<>();
		
		for(int i=0; i<5; i++)
		{
			list.add(br.readLine().toCharArray());
			max = Math.max(max, list.get(i).length);
		}
		for(int i=0; i<max; i++)
		{
			for(int j=0;j<5;j++)
			{
				if(list.get(j).length > i)
				{
					System.out.print(list.get(j)[i]);
				}
			}
		}
	}

}
