package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기_정도형3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		// 스위치 상태가 들어갈 배열 선언
		int[] arr = new int[N];
		
		// 스위치 상태 입력받기
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 학생의 수
		int P = Integer.parseInt(br.readLine());
		// 학생들의 상태 남학생 1, 여학생 2, 학생이 받은 자연수
		int[][] state = new int[P][2];
		for(int i=0; i<P; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<2; j++)
			{
				state[i][j] = Integer.parseInt(st.nextToken());				
			}
			//남학생의 경우,
//			System.out.println(Arrays.toString(arr));
			if(state[i][0] == 1) {
				for(int k=0; k<N;k++) {
					if(k%state[i][1]==0 && k>0)
					{
						arr[k-1] = Math.abs(arr[k-1]-1);
					}
				}
			}
			//여학생의 경우,
			else if(state[i][0]==2) {
				int check=1;
				while(true) {
					int r = state[i][1]-1-check;
					int c = state[i][1]-1+check;
//					System.out.println("minus : "+r+" plus : "+c);
					
					if((0<=r && c<=N)&& arr[state[i][1]-1-check] == arr[state[i][1]-1+check]) {
						arr[state[i][1]-1-check] = Math.abs(arr[state[i][1]-1-check]-1);
						arr[state[i][1]-1+check] = Math.abs(arr[state[i][1]-1+check]-1);
						check++;
					}
					else {
						arr[state[i][1]-1] = Math.abs(arr[state[i][1]-1]-1);
						break;
					}
					
				}
					
			}
			
		}
		System.out.println(Arrays.toString(arr));
	}

}
