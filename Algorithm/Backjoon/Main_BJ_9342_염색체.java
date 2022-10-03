package Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9342_염색체_정도형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		/* 정규식 사용
		 * ^는 시작을 의미하고 $는 끝을 의미함
		 * [A-F]? A부터 F까지 중에 하나가 0번 혹은 1번 발생
		 * A+F+C+ A문자 1번 이상 발생, F 문자 한번 이상 발생,  C 문자 한번 이상 발생
		 * [A-F]? A부터 F까지 중에 하나가 0번 혹은 1번 발생
		 */
		String check = "^[A-F]?A+F+C+[A-F]?$";
		for (int t=1; t<=T;t++)
		{
			String str = br.readLine();
			//matches는 패턴을 체크 해줌
			if(str.matches(check))
			{
				System.out.println("Infected!");
				continue;
			}
			System.out.println("Good");
		}
	}
}
