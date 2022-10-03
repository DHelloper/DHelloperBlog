package Study_09_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2792_보석상자 {

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      //아이들의 수 N, 보석 색상의 수 M 입력받기
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int[] arr = new int[M];
      int left = 1;
      int right = 0; 
      int mid = 0; 
      int sum = 0; 
      int answer = 0;
      
      //보석의 종류만큼 반복
      for(int i=0; i<M; i++)
      {
         st = new StringTokenizer(br.readLine());
         // arr 배열에 각 보석의 갯수를 입력받음
         arr[i] = Integer.parseInt(st.nextToken());
         // 그 중에 가장 많은 보석의 값을 right로 설정
         right = Math.max(right, arr[i]);
      }
     
      // 이분 탐색으로 탐색이 끝날때까지 반복
      while (left <= right) {
         // 이분 탐색을 위한 mid 값 설정
         mid = (left + right) / 2;
         //탐색의 범위가 바뀔때마다 sum은 초기화 해줘야 함
         sum = 0;
         // 보석의 갯수만큼 반복
         for (int i = 0; i < M; i++) {
        	// sum에  (i번째 보석의 갯수 / mid값)을 더해줌
        	// 해당 과정을 통해 보석을 mid 갯수 만큼 나눠줄 때 필요한 사람을 구할 수 있음 
            sum += arr[i] / mid;
            // 만약, mid로 나눠서 나눠줬는데 그러고도 보석이 남는다면?
            if (arr[i] % mid != 0) {
            // 한 사람이 더 필요하기 때문에 sum을 ++해줌
               sum++;
               System.out.println(sum);
            }
         }
         // 필요한 사람(sum)이 주어진 사람N보다 많을 경우에는
         if (sum > N) {
        	// 한번에 더 많이 나눠줘야 하기 때문에 left를 mid+1로 해줌
            left = mid + 1;
         }
         // 보석을 나눠줄 수 있는 경우
         else {
        	// 나눠주는 보석의 갯수를 줄이기 위해 범위를 좁힘
            right = mid - 1;
            answer = mid;
         }
      }
      // 이분 탐색을 통해 나온 최솟 값 출력
      System.out.println(answer);
   }

}