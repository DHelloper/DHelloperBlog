package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1966_프린터큐 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t=1; t<=T; t++)
		{
//			PriorityQueue<int[]> arr = new PriorityQueue<>(Collections.reverseOrder());
			Queue<int[]> arr = new LinkedList<int[]>();
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			int max =0;
//			int[] arr = new int[N];
			int cnt =0;
			int temp =0;
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++)
			{
				int a = Integer.parseInt(st.nextToken());
				arr.add(new int[] {i,a});
				max = Math.max(a, max);
			}
			
			while(!arr.isEmpty())
			{
				int[] ex = arr.peek();
				for(int q[] : arr)
				{
					if(ex[1]<q[1])
					{
						arr.add(arr.poll());
					}
				}
				if(arr.poll()[0]==target)
				{
					break;
				}
				cnt++;
			}
			System.out.println(cnt);
			
		}
	}
}
