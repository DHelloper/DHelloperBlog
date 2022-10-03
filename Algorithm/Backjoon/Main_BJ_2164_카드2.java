package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2164_카드2_정도형 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Queue<Integer> queue = new LinkedList(); 
		int n = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++)
		{
			queue.add(i+1);
		}
		while(queue.size()!=1)
		{
			queue.remove();
			queue.add(queue.poll());
		}
		System.out.println(queue.poll());
	}

}
