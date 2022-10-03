package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Backjoon_13458_시험감독 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// 시험장의 갯수 N
		int N = Integer.parseInt(st.nextToken());
		// 응시자의 수 배열
		int[] class_arr = new int[N];
		// 총감독관의 수
		long main = 0;
		// 부감독관의 수
		long sub = 0;
		// 총 감독관의 수와 부 감독관의 수를 더한 값
		double sum=0;
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N;i++) {
			class_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		//반의 수 마다 계산
		for(int i=0; i<N;i++) {
			// 총감독관은 한명 있어야하기 때문에 ++
			main++;
			//반의 인원 - 총 감독관이 관리할 수 있는 수, 0 중 큰걸 고름
			sum = Math.max(class_arr[i]-B, 0);
			// 남은 반의 인원 / C를 올림으로 해서 더함.
			sub += Math.ceil(sum/C);
		}
		//총 감독관의 수 + 부 감독관의 수
		System.out.println(main+sub);
	}

}
