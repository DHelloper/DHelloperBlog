package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_Backjoon_7568_덩치 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		int[] arr2 = new int[N];
		int count=0;
		
		// 2차원 배열에 각 몸무게와 키 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//탐색 시작
		for(int i=0; i<N; i++) {
			count=1;
			for(int j=0; j<N; j++) {
				//i 번째 사람에 대하여 , j번째 사람의 몸무게, 키와 비교했을 때, i번 째 사람이 더 작다면 count++
				// 해당 count가 등수가 됨.
				// 몸무게는 작지만 키가 큰 경우는 더 크다고 말할 수 없기 때문에 동일 등수 나올 수 있다는 조건 때문
				if(arr[i][0] < arr[j][0] && arr[i][1]<arr[j][1]) {
					count++;
				}
			}
			// 등수를 arr2[i]에 저장
			arr2[i] = count;
		}
		for(int p=0; p<N;p++) {
			System.out.print(arr2[p]+" ");
		}
		
	}

}
