package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Backjoon_1316_그룹단어체커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int t=0; t<T; t++) 
		{
			StringBuilder sb = new StringBuilder();
			boolean check = true;
			//문자열 입력받기
			String str = br.readLine();
			//문자열의 길이
			int length = str.length();
			//문자를 나눠서 담을 배열
			char[] arr = new char[length+2];
			arr = str.toCharArray();
			
			//문자열의 길이만큼 반복
			for(int i=0; i<length;i++) 
			{
				if(i==0) 
				{
					//스트링 빌더에 문자 더함
					sb.append(arr[i]);
				}
				//현재의 문자와 전의 문자가 다를 때,
				else if(i-1 >= 0 &&arr[i]!=arr[i-1]) {
					//sb안에 현재의 문자가 포함되어 있는지 확인
					if(sb.toString().contains(arr[i]+""))
					{
						//있으면 false 후 break
						check = false;
						break;
					}
					else 
					{
						//sb안에 문자가 없다면 sb안에 추가
						sb.append(arr[i]);
					}
				}

			}
			//check가 false가 안되었으면 cnt++
			if(check) cnt++;
		}
		System.out.println(cnt);
	}

}
