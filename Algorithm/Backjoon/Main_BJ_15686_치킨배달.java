package _0812;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_15686_치킨배달_정도형 {
	static int N,M;
	static int[][] arr;
	static int[] arr2,result;
	static int sum_min;

	static boolean[] check;
	
	static List<Integer> index_i,index_j;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+2][N+2];
		index_i = new ArrayList<>();
		index_j = new ArrayList<>();
		sum_min = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=N; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2)
				{
					arr[i][j] = 0;
					index_i.add(i);
					index_j.add(j);
				}
			}
			
		}
		arr2 = new int[index_i.size()];
		result = new int[M];
		check = new boolean[index_i.size()];
		for(int k=0; k<index_i.size();k++)
		{
			arr2[k] = k;
		}
		System.out.println(Arrays.toString(arr2));
		comb(0,0);			

		System.out.println(sum_min);
	}
	//치킨 거리 구하는 메서드
	public static void dis(int[][] arr)
	{
		int dis=0;
		int r=0;
		int c=0;
		int sum=0;
		
		for(int i=1; i<=N; i++)
		{
			for(int j=1; j<=N; j++)
			{
				if(arr[i][j]==1)
				{
					int min=Integer.MAX_VALUE;
					r = i;
					c = j;
					for(int o=1; o<=N; o++)
					{
						for(int p=1; p<=N; p++) 
						{
							if(arr[o][p] == 2)
							{
								dis = Math.abs(r-o) + Math.abs(c-p);
								min = Math.min(dis, min);
							}
						}
					}
					sum+=min;
				}
			}
		}
		sum_min = Math.min(sum, sum_min);
	}
	
	public static void comb(int cnt, int start)
	{
		int[][] arr_copy = new int[N+2][N+2];
		//원본 배열 복사
		// cnt가 M이 되었을 때, 조합의 결과를 Index로 해당 치킨집 2로 바꿈
		if(cnt==M)
		{
			for(int i=1; i<=N; i++)
			{
				for(int j=1; j<=N; j++)
				{
					arr_copy[i][j] = arr[i][j];
				}
			}
			for(int i=0; i<M; i++)
			{
				arr_copy[index_i.get(result[i])][index_j.get(result[i])] = 2;
			}
			dis(arr_copy);
			return;
		}
		for(int i=start;i<index_i.size();i++)
		{
			if(!check[i])
			{
				result[cnt] = arr2[i];
				check[i] = true;
				comb(cnt+1,i+1);
				check[i] = false;
			}
		}
	}
}
