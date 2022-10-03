package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_20546_기적의매매법 {
	static int[] arr;
	static int jun_wntlr, sung_wntlr;
	static int jun_money, sung_money;
	static int day=14; // 14일 고정
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int money = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		
		//주식의 가격이 들어 있는 배열 
		arr = new int[14];
		
		for(int i=0; i<day; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//각각 money를 매개변수로 메서드 호출
		int j = Jun(money);
		int s = Sung(money);
		if(j>s)
		{
			System.out.println("BNP");
		}
		else if(j==s){
			System.out.println("SAMESAME");
		}
		else {
			System.out.println("TIMING");
		}
		
	}
	
	public static int Jun(int money)
	{
		//14일이 고정이기 때문에 14회 반복
		for(int i=0; i<14; i++)
		{
			//나눠지는데까지 나눠서 주식 저장
			jun_wntlr += money/arr[i];
			//주식을 산 만큼 돈 차감
			money = money%arr[i];
		}
		// 남은 돈 + 주식의 갯수*마지막날의 주식가격 리턴
		return money+jun_wntlr*arr[arr.length-1];
	}
	public static int Sung(int money)
	{
		//연속으로 올랐는지 내렸는지를 확인하기 위한 변수 선언
		int up_cnt=0, down_cnt=0;
		//14일이 고정이기 때문에 14회 반복
		for(int i=0; i<14; i++)
		{
			//만약 3일 연속 올랐다면
			if(up_cnt==3)
			{
				//주식의 갯수 * 해당 날의 주식 가격을 money에 더함
				money += sung_wntlr*arr[i];
				//주식 갯수 0으로 초기화
				sung_wntlr=0;
			}
			//만약 3일 연속 내려갔다면
			if(down_cnt==3)
			{
				//나눠지는데까지 나눠서 주식을 구매
				sung_wntlr += money/arr[i];
				//주식을 산 만큼 돈 차감
				money = money%arr[i];
			}
			//올랐는지 판별
			if(i<13&&arr[i]<arr[i+1])
			{
				//3일 경우에는 유지하고 아닐 경우에는 up_cnt ++
				if(up_cnt!=3) up_cnt++;
			}
			//오르지 않았다면 
			else
			{
				//up_cnt 0으로 초기화
				up_cnt=0;
			}
			//내렸는지 판별
			if(i<13&&arr[i]>arr[i+1])
			{
				//3일일 경우에는 유지하고 아닐 경우에는 down_cnt ++
				if(down_cnt!=3) down_cnt++;
			}
			//내려가지 않았다면
			else
			{
				//down_cnt 0으로 초기화
				down_cnt=0;
			}
		}
		// 남은 돈 + 주식의 갯수 * 마지막 날의 주식 가격 리턴
		return money+sung_wntlr*arr[arr.length-1];
	}

}
