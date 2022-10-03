package _0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수_정도형 {
    static int[] parent;
    public static void add(int x)
    {
        parent[x] = x;
    }
    
    public static int find(int x)
    {
        if(parent[x]==x)
        {
            return x;
        }
        else
        {
            int y = find(parent[x]);
            parent[x] = y;
            return y;
        }
    }
    
    public static boolean union(int x, int y)
    {
        x = find(x);
        y = find(y);
        if(x!=y)
        {
            parent[y] = x;
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int T = Integer.parseInt(st.nextToken());
        for(int t=1; t<=T; t++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt=0;
            parent = new int[N+1];
            for(int i=1; i<N; i++)
            {
            	add(i);
            }
            for (int i=0; i<M; i++)
            {
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                    union(x,y);
            }
            HashSet<Integer> set = new HashSet<>();
            for(int i=1;i<=N;i++)
            {
            	set.add(find(i));
            }
            System.out.println("#"+t+" "+set.size());
        }
    }
}