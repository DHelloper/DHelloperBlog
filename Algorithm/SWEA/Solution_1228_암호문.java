package _0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_암호문_정도형 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> link = new LinkedList<>();
		
		for(int t=1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N;i++) 
			{
				link.add(i, Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<M;i++) 
			{
				st.nextToken();
				int ins = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				for(int j=0; j<cnt;j++)
				{
					link.add(ins++, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#"+t+" ");
			for(int i=0; i<10;i++)
			{
				System.out.print(link.get(i)+" ");
			}
			System.out.println();
		}
	}
}
