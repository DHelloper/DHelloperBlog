package _0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_3040_백설공주와일곱난쟁이_정도형 {
	static int[] arr = new int[9];
	static int[] arr2 = {0,0,1,1,1,1,1,1,1};
	static int sum=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i] = Integer.parseInt(st.nextToken());
		}
		do {
			sum=0;
			for(int i=0; i<9;i++)
			{
				if(arr2[i]!=0)
				{
					sum+=arr[i];
				}
			}
			if(sum==100)
			{
				for(int i=0; i<9;i++)
				{
					if(arr2[i]!=0)
					{
						System.out.println(arr[i]);
					}
				}
			}
		} while (np_comb(arr2));
	}

	
	public static boolean np_comb(int[] arr)
	{
		int N= arr.length; //요소의 갯수
		int i=N-1; // 꼭대기 인덱스 담을 변수
		while(i>0 && arr[i-1]>=arr[i]) i--;
		if(i==0) return false;
		
		int j=N-1;
		while(arr[i-1]>=arr[j]) j--;
		swap(arr, i-1, j);
		
		int k=N-1;
		while(i<k)
		{
			swap(arr, i++, k--);
		}
		return true;
	}
	
	public static void swap(int[] arr, int i,int j)
	{
		int temp=arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
