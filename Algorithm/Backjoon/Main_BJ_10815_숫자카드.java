package Study_08_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_10815_숫자카드 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//숫자 카드의 갯수
		int N = Integer.parseInt(st.nextToken());
		//숫자 카드 담을 배열
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		
		//숫자 카드 입력받기
		for(int i=0; i<N; i++)
		{
			 arr[i] = Integer.parseInt(st.nextToken()); 
		}
		//이분 탐색을 위한 정렬
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine()," ");
		//찾아야 되는 숫자 카드의 갯수
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		
		//찾아야 하는 숫자 카드 입력받기
		for(int i=0; i<M; i++)
		{
			int target = Integer.parseInt(st.nextToken());
			System.out.print(find(N-1,0,target,arr)+" ");
		}
	}
	
	//이분 탐색 진행
	static int find(int max, int min, int target,int[] arr)
	{
		//왼쪽 끝 지점과 오른쪽 끝 지점이 만나면 종료
		while(min<=max)
		{
//			탐색할 중간 지점 구하기
			int mid = (max+min)/2;
			
//			만약 찾아야 할 숫자가 중간지점보다 작으면
			if(target < arr[mid])
			{
//			최대를 중간의 -1지점으로 옮겨서 왼쪽만 탐색할 수 있도록 함
				max = mid-1;
			}
//			만약 찾아야 할 숫자가 중간지점보다 크면
			else if(target > arr[mid])
			{
//			최소를 중간의 +1지점으로 옮겨서 오른쪽만 탐색할 수 있도록 함	
				min = mid+1;
			}
//			찾았을 경우 1을 리턴해서 1을 출력할 수 있도록 함
			else {
				return 1;
			}
		}
		//못찾았을 경우 0을 출력하도록 0 리턴
		return 0;
	}
}
