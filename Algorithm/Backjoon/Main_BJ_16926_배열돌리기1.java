package _0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Backjoon_16926_배열돌리기1 {

	static int[][] arr;
	static int N,M,R;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M;j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<R;i++)
		{
			rotate();			
		}
		print_arr();
	}
	/*
	 * 1. 배열의 값을 하나씩 당기면서 회전 수행
	 * 		맨 처음 값은 temp에 저장해놓고 다음 회전 수행의 마지막 인덱스 자리에 끼워넣으면 손실 없음
	 * 		다음 값에 저장하기 전에 temp를 얻어야 해서 pastTemp 사용하여 당김의 마지막 요소를 찾기 전까지 저장하고 있음
	 * 		x1, y1, x2, y2를 활용해서 수행
	 * 		회전은 테두리 돌리기를 반복해서 수행하는식.
	 * 		회전의 횟수는 N과 M중 작은걸 /2 하면 구할 수 있음
	 * 		회전이 진행 될 수록 범위를 좁혀감 
	 */		
	
	/*
	 * 1  2  3  4
	 * 5  6  7  8
	 * 9  10 11 12
	 * 13 14 15 16
	 * 
	 * arr[x1][y1] = 1
	 * arr[x1][y2] = 4
	 * arr[x2][y1] = 13
	 * arr[x2][y2] = 16 과 같이 범위 지정
	 * 이 범위는 횟수가 증가할수록 
	 * x1, y1 은 +를 해주고 x2, y2는 -를 해주어 범위를 좁힐 수 있음
	 * 
	 * 1. 시작 지점인 1을 temp에 넣고 오른쪽으로 이동하며 한칸씩 당김
	 * 
	 *    1 2 3 4 -> 2 3 4 4 가 됨
	 *    
	 * 2. Temp에 있던 1값을 pastTemp로 바꾸고 시작지점인 13을 Temp에 넣음
	 *    위로 이동하며 한칸씩 당김
	 *    현재 위치 -1 이 x1과 같을 경우 pastTemp의 1값을 현재 위치에 넣음.
	 *    
	 *    2  ->  2  ->  2
	 *    5  ->  5  ->  1
	 *    9  ->  5  ->  5
	 *    5  ->  9  ->  9
	 *    
	 * 3. Temp에 있던 13값을 pastTemp로 바꾸고 시작 지점인 16을 Temp에 넣음
	 *    왼쪽으로 이동하며 한칸씩 당김
	 *    현재 위치 -1 이 y2와 같을 경우 pastTemp의 13 값을 현재 위치에 넣음.
	 *    
	 *    9 14 15 16 -> 9 14 14 15 -> 9 13 14 15
	 *    
	 * 4. Temp에 있던 16 값을 pastTemp로 바꿈, 시작 위치x1, y2에 있는 2 3 4 4 중, 맨 오른쪽 4는 필요없는 값이기에 덮어 씌워도 됨
	 *    아래쪽으로 이동하며 한칸씩 당김
	 *    현재 위치 +1이 x2와 같을 경우,pastTemp의 16 값을 현재 위치에 넣음.
	 *    4   ->  8   ->  8
	 *    8   ->  12  ->  12
	 *    12  ->  12  ->  16
	 *    15  ->  15  ->  15
	 * 
	 */
	static void rotate()
	{
		int temp, pastTemp;
		int S = Math.min(N, M)/2;
		for(int s=0; s<S; s++)
		{
			int x1 = 0 + s;
			int y1 = 0 + s;
			int x2 = N - s -1;
			int y2 = M - s -1;
			//위쪽변 당김 수행
			temp = arr[x1][y1];
			for (int y = y1; y < y2; y++)
			{
				arr[x1][y] = arr[x1][y+1];
			}
			
			//왼쪽 변 당김 수행
			pastTemp=temp;
			temp = arr[x2][y1];
			for (int x = x2; x > x1; x--)
			{
			      if (x - 1 == x1) {
			    	  /*
			    	   * 당김의 마지막 자리에는 그 전 당김을 수행할 때 빼뒀었던 Temp를 넣음
			    	   * A[1][6]이 A[2][6]이 되는 것.
			    	   */
			        arr[x][y1] = pastTemp;
			        continue;
			      }
				arr[x][y1] = arr[x-1][y1];
			}
			
			//아래쪽 변 당김 수행
			pastTemp=temp;
			temp = arr[x2][y2];
			for(int y=y2; y>y1; y--)
			{
				if (y - 1 == y1) {
			    	  /*
			    	   * 당김의 마지막 자리에는 그 전 당김을 수행할 때 빼뒀었던 Temp를 넣음
			    	   * A[1][6]이 A[2][6]이 되는 것.
			    	   */
			        arr[x2][y] = pastTemp;
			        continue;
			      }
				arr[x2][y] = arr[x2][y-1];
			}
			
			pastTemp=temp;
			for (int x = x1; x < x2; x++) {
		      if (x + 1 == x2) {
		        arr[x][y2] = pastTemp;
		        continue;
		      }

		      arr[x][y2] = arr[x+1][y2];
		    }
		}
	}
	static void print_arr()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
