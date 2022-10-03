package Study_09_02;

public class Programmers_2xn타일링 {
	class Solution {
		// dp 담을 배열 선언
	    static long[] dp;
	    public long solution(int n) {
	    	//정답 answer
	        long answer = 0;
	        // dp 배열의의 사이즈는 주어지는 숫자 n + 1 
	        dp = new long[n+1];
	        answer = dp_memoization(n);
	        return answer;
	    }
	    // 메모이제이션 메서드
	    public long dp_memoization(int n)
	    {
	    	// 만약 n이 3 미만이면 그냥 그대로 return.
	        if(n < 3) return n;
	        // 만약 n이 이미 계산 되어 있는 수라면.
	        if(dp[n]!=0)
	        {
	        	// dp[n] 리턴
	            return dp[n];
	        }
	        // 피보나치 알고리즘 수행
	        dp[n] = dp_memoization(n-1) + dp_memoization(n-2);
	        // 나머지를 해서 저장해야 값이 변하기 전에 담을 수 있음.
	        dp[n] = dp[n] % 1000000007;
	        // dp[n] 리턴
	        return dp[n];
	    }
	}
}
