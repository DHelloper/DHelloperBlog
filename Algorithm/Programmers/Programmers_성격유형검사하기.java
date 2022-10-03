package Study_09_02;

public class Programmers_성격유형검사하기 {
	class Solution {
	    public String solution(String[] survey, int[] choices) {
	    	//알파벳에 해당하는 정수형 배열을 만들어 성격유형 점수 카운트
	        int[] count = new int[26];
	        String answer = "";
	        for(int i=0; i<survey.length; i++)
			{
	     		// 1번째 유형과 2번째 유형을 입력받고 choices에 해당하는 점수++
	        	// R, T 일 때, cha1 = R, cha2 = T
	        	// C, F 일 때, cha1 = C, cha2 = F

				char cha1 = survey[i].charAt(0);
				char cha2 = survey[i].charAt(1);
				if(choices[i]==7)
				{
					count[cha2-'A'] += 3;
				}
				else if(choices[i]==6)
				{
					count[cha2-'A'] += 2;
				}
				else if(choices[i]==5)
				{
					count[cha2-'A'] += 1;
				}
	            //모르겠음 선택일 경우 아무것도 하지 않고 continue
				else if(choices[i]==4)
				{
					continue;
				}
				else if(choices[i]==3)
				{
					count[cha1-'A'] += 1;
				}
				else if(choices[i]==2)
				{
					count[cha1-'A'] += 2;
				}
				else if(choices[i]==1)
				{
					count[cha1-'A'] += 3;
				}
			}
			//성격 유형 두 가지 중 큰 값을 판별해서 answer에 +
			if(count['R'-'A'] >= count['T'-'A'])
			{
				answer+="R";
			}
			else {
	            answer+="T";
			}
			if(count['C'-'A'] >= count['F'-'A'])
			{
	            answer+="C";
			}
			else {
	            answer+="F";
			}
			if(count['J'-'A'] >= count['M'-'A'])
			{
	            answer+="J";
			}
			else {
	            answer+="M";
			}
			if(count['A'-'A'] >= count['N'-'A'])
			{
	            answer+="A";
			}
			else {
	            answer+="N";
			}
	        return answer;
	    }
	}
}
