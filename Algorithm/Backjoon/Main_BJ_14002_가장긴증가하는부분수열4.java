package Study_09_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_14002_가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력값을 담아 놓을 배열 선언
        int arr[] = new int[n + 1];
        //dp를 사용할 배열 선언
        int dp[] = new int[n + 1];

        //값 입력받기
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //dp의 첫번째는 자기 자신의 길이이기 때문에 1 넣고 시작
        dp[1] = 1;
        //정답도 1 넣고 시작
        int ans = 1;
        //i는 2부터 시작 해서 n까지 반복 진행
        for (int i = 2; i <= n; i++) {
        	// 자기 자신을 포함해서 무조건 1이기 때문에 1 대입
            dp[i] = 1;
            // 맨 처음부터 탐색 진행
            for (int j = 1; j < i; j++) {
            	//만약 현재 값이 j의 값보다 크고, dp에 저장된 내 길이가, dp에 저장된 j의 값보다 작거나 같을 때,
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                	//내 길이를 담아놓은 dp를 j의 길이 + 1로 바꿔줌
                    dp[i] = dp[j] + 1;
                }
            }
            //ans는 최대 길이
            ans = Math.max(ans, dp[i]);
        }


        // 역추적

        // 최대 길이값을 value로 지정
        int value = ans;
        // 스택 사용
        // 가장 긴 dp값을 가진 요소를 먼저 넣기 때문에 후입선출, stack 자료구조 사용
        Stack<Integer> stack = new Stack<>();

        // i는 n으로 설정, 그 이유는 뒤에서부터 추적해야 하기 때문. 1이 될 때 까지
        for (int i = n; i >= 1; i--) {
        	//만약 최대 길이와 i번째 값의 길이가 같다면?
            if (value == dp[i]) {
            	//스택에 i번째 값 넣기.
                stack.push(arr[i]);
                //길이 하나 빼기
                value--;
            }
        }

        //스택이 빌 때 까지
        while (!stack.isEmpty()) {
        	//스트링빌더에 pop해서 하나씩 넣기
            sb.append(stack.pop() + " ");
        }

        System.out.println(ans);
        System.out.println(sb);

    }
}