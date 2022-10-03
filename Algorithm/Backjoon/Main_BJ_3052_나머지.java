package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main_Backjoon_3052 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> h = new HashSet<Integer>();
		int cnt=0;
		for(int i=0; i<10; i++)
		{
			h.add(Integer.parseInt(br.readLine()) % 42);
		}
		System.out.println(h.size());
			
	}

}
