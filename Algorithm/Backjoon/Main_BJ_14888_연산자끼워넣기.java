package Study_08_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_14888_연산자끼워넣기{
	static int[] num,notnum;
	static char[] arr,result;
	static boolean[] check;
	static int N,R,max,min;
	
	static List<Character> list_a = new ArrayList<Character>();
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		
		// 숫자들을 담을 배열
		num = new int[N];
		// 연산자의 갯수를 담을 배열
		notnum = new int[4];
		// 연산자를 담을 배열
		arr = new char[N-1];
		// 순열을 돌리기 위한 배열
		result = new char[N-1];
		// 방문 체크 배열
		check = new boolean[N-1];
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine()," ");
		//숫자들을 입력받아 num[] 배열에 저장
		for(int i=0; i<N; i++)
		{
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		
		//연산자를 입력받을 건데, 갯수로만 주어짐
		for(int i=0; i<4; i++)
		{
			// i가 0이면 +, 1이면 -, 2면 *, 3이면 / 갯수만큼 List에 넣음
			int A = Integer.parseInt(st.nextToken());
			for(int j=0; j<A; j++)
			{
				if(i==0)
				{
					list_a.add('+');
				}
				else if(i==1)
				{
					list_a.add('-');
				}
				else if(i==2)
				{
					list_a.add('*');
				}
				else if(i==3)
				{
					list_a.add('/');
				}
			}
		}
		for(int i = 0; i<list_a.size();i++)
		{
			//순열을 돌리기 위해 0부터 연산자의 갯수만큼 숫자로 넣어줌
			arr[i] = list_a.get(i);
		}
		perm(0);
		//최댓값 출력
		System.out.println(max);
		//최솟값 출력
		System.out.println(min);
	}
	public static void perm(int cnt)
	{
		int sum = 0;
		int[] num2 = new int[N];
		//원본 배열을 유지하기 위해 복사해서 사용
		for(int i=0; i<N; i++)
		{
			num2[i] = num[i];
		}
		//만약 순열이 완성 되었으면
		if(cnt==N-1)
		{
			//앞의 수 부터 연산 수행하며 i+1번째에 누적시킴
			//result 배열에는 순열을 돌린 결과로 연산자가 들어있음.
			for(int i=0; i<N-1;i++)
			{
				if(result[i] == '+')
				{
					sum = num2[i] + num2[i+1];
					num2[i+1] = sum;
				}
				else if(result[i] == '-')
				{
					sum = num2[i] - num2[i+1];
					num2[i+1] = sum;
				}
				else if(result[i] == '*')
				{
					sum = num2[i] * num2[i+1];
					num2[i+1] = sum;
				}
				else if(result[i] == '/')
				{
					//나눗셈 연산의 앞 값이 음수일 경우
					if(num2[i] < 0)
					{
						//양수로 바꿈
						num2[i] *= -1;
						//몫을 취한 후 -1을 곱해서 음수로 바꿈
						sum = (num2[i] / num2[i+1]) * -1;
						num2[i+1] = sum;
					}
					//나눗셈 연산의 앞 값이 양수일 경우에는 그냥 수행 
					else {
						sum = num2[i] / num2[i+1];
						num2[i+1] = sum;
					}
				}
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		for(int i=0; i<N-1;i++)
		{
			if(!check[i])
			{
				check[i] = true;
				result[cnt] = arr[i];
				perm(cnt+1);
				check[i] = false;
			}
		}
	}
}
