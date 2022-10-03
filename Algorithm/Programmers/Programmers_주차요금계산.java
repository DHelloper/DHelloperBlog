package Study_09_02;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Programmers_주차요금계산 {
	class Solution {
	    public int[] solution(int[] fees, String[] records) {
	        //누적 주차 요금을 저장할 Int형 배열
	        int[] result = new int[10000];
	        //누적 주차 시간을 저장할 Int형 배열
			int[] time_list = new int[10000];
	        //10000개의 번호중 입,출차된 차량의 정보만 처리하기 위해 list 생성
	        List<Integer> list_answer = new ArrayList<>();
			A : for(int i=0; i<records.length;i++)
			{
				StringTokenizer st = new StringTokenizer(records[i]);
				String time = st.nextToken();
	            // :을 기준으로 시간과 분을 나눠서 hour[0] : 시간, hour[1] : 분으로 활용
				String[] hour = time.split(":");
	            // 차량 번호
				String number = st.nextToken(); 
	            // IN인지, OUT인지 판별하기 위함
				String state = st.nextToken();
	            // 만약 i번째의 값이 IN이라면
				if(state.equals("IN"))
				{
	            	//i 이후부터 탐색하며 number가 같은 값을 찾음
					for(int j=i+1; j<records.length; j++)
					{
						st = new StringTokenizer(records[j]);
						String time2 = st.nextToken();
						String[] hour2 = time2.split(":");
						String number2 = st.nextToken(); 
						String state2 = st.nextToken();
	                    //j번째 번호가 i번째 번호와 같다면, 입차 다음은 출차이기 때문에 조건 성립
						if(number.equals(number2))
						{
	                    	// 입차 시간을 분으로 환산
							int startmin = Integer.parseInt(hour[0])*60 + Integer.parseInt(hour[1]);
	                        // 출차 시간을 분으로 환산
							int endmin = Integer.parseInt(hour2[0])*60 + Integer.parseInt(hour2[1]);
	                        // time_list에 차량번호번째 인덱스에 출차시간-입차시간으로 주차 시간 누적
							time_list[Integer.parseInt(number)] += endmin-startmin;
	                        // 아래로 진행하지 않기 위해 continue
							continue A;
						}
					}
					//만약 IN 기록은 있지만 OUT이 없는 경우.
	                //hour2에 23:59를 넣어서 계산
					String[] hour2 = {"0","0"};
					hour2[0] = "23";
					hour2[1] = "59";
					int startmin = Integer.parseInt(hour[0])*60 + Integer.parseInt(hour[1]);
					int endmin = Integer.parseInt(hour2[0])*60 + Integer.parseInt(hour2[1]);
					time_list[Integer.parseInt(number)] += endmin-startmin;
				}
				
			}
	        //0000번부터 9999번까지 탐색을 하면서, 누적 시간이 있는 경우에만 이후 진행
			for(int i=0; i<10000; i++)
			{
				if(time_list[i]!=0)
				{
	            	// 누적 요금에 기본 요금 더하기
					result[i] += fees[1];
	                // 누적 시간 - 기본 시간
					int result_time = time_list[i]-fees[0];
	                // 만약, 결과가 0보다 작으면 0으로 바꿔 계산하지 않도록 함.
					if(result_time<0) result_time=0;
	                // 소숫점을 올림해서 요금 계산을 해야 함.
					result[i] += Math.ceil((float)result_time/fees[2])*fees[3];
	                // 결과를 list_answer에 담음
	                list_answer.add(result[i]);
				}
			}
	        // list_answer의 값을 answer로 옮김
	        int[] answer = new int[list_answer.size()];
	        for(int i=0; i<list_answer.size(); i++)
	        {
	            answer[i] = list_answer.get(i);
	        }
	        return answer;
	    }
	}
}
