package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_Backjoon_16139_인간컴퓨터상호작용 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		String str = st.nextToken();
		//문자열을 읽어 옴  
		st = new StringTokenizer(br.readLine()," ");
		//질문의 갯수 p
		int p = Integer.parseInt(st.nextToken());
		//계산 결과를 미리 담아 놓을 배열 check_arr
		int[][] check_arr = new int[str.length()][26];
		//문자열seungjaehwang 일 때 
		//str.charAt(0) = s / s-a번째 인덱스를 ++해줌 (문자열의 첫번째 문자 처리하고 시작) 
		check_arr[0][str.charAt(0)-'a']++;
		//1부터 문자열의 길이-1만큼 반복 ( 첫번째 문자 처리는 해줬기 때문에 1부터 시작 )
		
		//문자열 만큼 반복을 돌면서 각 문자 a에 대해 check[i][a-'a']를 ++ 해줌
		//check_arr[i] 는 문자열의 탐색 위치 / check_arr[i][j]는 문자열의 i번째까지 탐색했을 때, 문자-'a'에 대한 카운트를 의미, 
		//누적을 위해 check_arr[i][j] = check_arr[i-1][j]해서 문자열을 탐색하며 진행한 정보를 계속 이어감.
		//a는 문자열 중 i번째 문자
		for(int i=1; i< str.length(); i++)
		{
			char a = str.charAt(i);
			for(int j=0; j<26; j++)
			{
				check_arr[i][j] = check_arr[i-1][j];
			}
			//a-'a'는 항상 문자 a의 값이 있기 때문에, 해당 인덱스를 ++
			check_arr[i][a-'a']++;
		}
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine()," ");
			char cha = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// start가 0이면 뺄 것 없이, 처음부터 end 부분까지의 누적된 문자의 합 출력.
			if(start==0) sb.append(check_arr[end][cha-'a']+"\n");
			// start가 0이 아니면, start-1지점부터 end 부분까지 누적된 문자의 합 출력.
			else sb.append(check_arr[end][cha-'a'] - check_arr[start-1][cha-'a']+"\n");
		}
		System.out.println(sb);
	}

}
