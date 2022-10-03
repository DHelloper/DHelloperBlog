package _0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2961_도영이가만든맛있는음식_정도형 {
    static int[] A,B;
    static int result_A=1, result_B=1;
    static int N;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[N];
        check = new boolean[N];
        for(int i=0; i<N;i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        subSet(0);
        System.out.println(min);
    }
    public static void subSet(int cnt)
    {
        result_A=1;
        result_B=0;
        if(cnt==N)
        {
            for(int i=0; i<N; i++)
            {
                if(check[i]) {
                    result_A *= A[i];
                    result_B += B[i];
                    min = Math.min(min, Math.abs(result_A-result_B));
                }
                
            }
            
            return;
        }
        
        check[cnt] = true;
        subSet(cnt+1);
        
        check[cnt] = false;
        subSet(cnt+1);
    }
}