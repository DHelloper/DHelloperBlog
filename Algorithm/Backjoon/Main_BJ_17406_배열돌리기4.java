package _0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Bj_17406_배열돌리기4_정도형 {
	static int N,M,RT,r,s,c,min;
	static int[][] arr,arr_copy,rotate_per;
	static int[] per,result;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		RT = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		check = new boolean[RT];
		per = new int[RT];
		result = new int[RT];
		rotate_per = new int[RT][3];
		//2차원 배열 받아오기
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<M; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
		}
		//회전 연산의 갯수에 따라 데이터 받아오기
		for(int i=0; i<RT; i++)
		{
			min=Integer.MAX_VALUE; // 최솟값을 비교하기 위해 min 선언
			st = new StringTokenizer(br.readLine()," ");
			per[i] = i; // 순열을 뽑기 위해 0부터 회전 횟수만큼 데이터 넣기
			r = Integer.parseInt(st.nextToken()); // 회전 연산의 정보 r
			c = Integer.parseInt(st.nextToken()); // 회전 연산의 정보 c
			s = Integer.parseInt(st.nextToken()); // 회전 연산의 정보 s
			rotate_per[i][0] = r; // 순열의 결과값을 활용하기 위해 배열에 넣고 Index로 접근 가능하도록 데이터 적재 
			rotate_per[i][1] = c; // 순열의 결과값을 활용하기 위해 배열에 넣고 Index로 접근 가능하도록 데이터 적재
			rotate_per[i][2] = s; // 순열의 결과값을 활용하기 위해 배열에 넣고 Index로 접근 가능하도록 데이터 적재
			
		}
		perm(0); // 순열 시작, 모든 경우의 수에 대해 rotate()를 실행하고, 각 min값을 갱신
		System.out.println(min); // 최종적으로 나온 min 출력
	}
	/*
	 * 1. 순열을 구함
	 * 2. 순열의 결과를 기반으로 rotate() 진행 
	 * 		result = [0,1]이면 
	 * 			rotate_per[0]번의 데이터를 기반으로 회전 수행
	 * 			rotate_per[1]번의 데이터를 기반으로 회전 수행
	 * 		result = [1,0]이면
	 * 			rotate_per[1]번의 데이터를 기반으로 회전 수행
	 * 			rotate_per[0]번의 데이터를 기반으로 회전 수행
	 * 		위의 과정에서 순열마다 원본 배열을 활용하기 위해 arr2 배열 선언 후 깊은 복사 수행
	 * 3. 하나의 순열에 대해 회전이 마쳤을 경우, 해당 배열에 대해 min을 구함
	 */
	static void perm(int cnt)
	{
		// 원본 배열 유지를 위해 arr2를 만들어 순열이 한번 돌때마다 원본 배열 복사하여 활용
		int[][] arr2 = new int[N][M];
		for(int i=0; i<N; i++)
		{
				for(int j=0; j<M; j++)
				{
					arr2[i][j] = arr[i][j];
				}
		}
		
		/*
		 * 만약 순열의 결과가 나오면,(회전 연산의 갯수가 기준이 됨)
		 * 회전 연산이 3개일 경우
		 * 1, 2, 3
		 * 2, 1, 3
		 * 3, 2, 1와 같이 3개 단위로 끊어질 것이기 때문.
		 */
		if(cnt==RT)
		{
			//result 배열의 크기만큼 (경우의 수 만큼)
			for(int ro=0; ro<result.length;ro++)
			{
				/*
				 * ro = 0,result = [0,1]일 때
				 * rotate_per[0][2] = 회전 연산의 s 정보를 나타냄
				 * 곧 s만큼 반복한다는 뜻
				 */
				for(int j=0; j<rotate_per[result[ro]][2];j++)
				{
					/*
					 * x1, x2, y1, y2 좌표를 지정해서 rotate의 매개변수로 사용
					 * x1 = rotate_per[0][0] - rotate_per[0][2]+j-1 이 구문은 r에서 s를 뺀 후, j만큼 더한 후에 1을 뺌
					 *  (3, 4, 2) 일 때 , 3 - 2 - 0 - 1 = 0이 됨
					 * y1 = rotate_per[0][1] - rotate_per[0][2]+j-1 이 구문은 c에서 s를 뺀 후, j만큼 더한 후에 1을 뺌
					 *  (3, 4, 2) 일 때 , 4 - 2 - 0 - 1 = 1이 됨
					 *  예시에서 A[1][2]이지만, 인덱스를 똑같이 안했으므로 -1을 해주어 A[0][1]과 같이 만듬
					 *  
					 *  j를 빼주는 이유는 회전의 사이즈를 조절하기 위함
					 */
					
					int x1 = rotate_per[result[ro]][0] - rotate_per[result[ro]][2]+j-1;
					int y1 = rotate_per[result[ro]][1] - rotate_per[result[ro]][2]+j-1;
					int x2 = rotate_per[result[ro]][0] + rotate_per[result[ro]][2]-j-1;
					int y2 = rotate_per[result[ro]][1] + rotate_per[result[ro]][2]-j-1;
					/*
					 * 구해진 좌표들과 복사된 arr2 배열을 인자로 rotate 메소드 호출 후 return값으로 수정된 arr2를 받음
					 * 하지만 순열 하나가 마쳐지고 다시 수행 될 경우 arr2는 초기화 됨
					 */
					arr2 = rotate(x1,x2,y1,y2,arr2);
				}
				/*
				 * 만약 순열 하나에 대한 rotate() 수행을 마쳤을 경우,
				 * 리턴 받은 arr2를 가지고 min 값을 구함
				 */
				if(ro==result.length-1)
				{
			    	for(int i=0; i<N;i++)
				    {
				    	int sum=0;
				    	for(int j=0; j<M; j++)
				    	{
				    		sum += arr2[i][j];
				    	}
			    		min = Math.min(min, sum);
				    }
				}
			}
			return;
		}
		
		
		//순열 구하는 곳
		for(int i=0; i<RT; i++)
		{
			if(!check[i])
			{
				result[cnt] = per[i];
				check[i]=true;
				perm(cnt+1);
				check[i]=false;
			}
		}
	}
	
	/*
	 * 1. 배열의 값을 하나씩 당기면서 회전 수행
	 * 		오른쪽으로 -> 아래로 -> 왼쪽으로 -> 위로
	 * 		맨 처음 값은 temp에 저장해놓고 다음 회전 수행의 마지막 인덱스 자리에 끼워넣으면 손실 없음
	 * 		다음 값에 저장하기 전에 temp를 얻어야 해서 pastTemp 사용하여 당김의 마지막 요소를 찾기 전까지 저장하고 있음
	 */		
	static int[][] rotate(int x1, int x2, int y1, int y2,int[][] arr2 )
	{
		int temp, pastTemp;
	    // 진행 1 : 오른쪽으로
		temp = arr2[x1][y2];
		for (int y = y2; y > y1; y--)
		{
			arr2[x1][y] = arr2[x1][y-1];
		}
	    // 진행 2 : 오른쪽변
		pastTemp = temp;
	    temp = arr2[x2][y2];

	    for (int x = x2; x > x1; x--) {
	      if (x - 1 == x1) {
	    	  /*
	    	   * 당김의 마지막 자리에는 그 전 당김을 수행할 때 빼뒀었던 Temp를 넣음
	    	   * A[1][6]이 A[2][6]이 되는 것.
	    	   */
	        arr2[x][y2] = pastTemp;
	        continue;
	      }
	      arr2[x][y2] = arr2[x - 1][y2];
	    }
	    
	    // 진행 3 : 아랫변
	    pastTemp = temp;
	    temp = arr2[x2][y1];

	    for (int y = y1; y < y2; y++) {
	      if (y + 1 == y2) {
	        arr2[x2][y] = pastTemp;
	        continue;
	      }

	      arr2[x2][y] = arr2[x2][y + 1];
	    }

	    // 진행 4 : 왼쪽변
	    pastTemp = temp;
	    for (int x = x1; x < x2; x++) {
	      if (x + 1 == x2) {
	        arr2[x][y1] = pastTemp;
	        continue;
	      }

	      arr2[x][y1] = arr2[x + 1][y1];
	    }
	    //회전을 마친 배열을 리턴
	    return arr2;

	}	
}
