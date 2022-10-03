package _0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_17135_캐슬디펜스_정도형 {
    static int [][] map;
    static int [] comb_arr,result;
    static List<int[]> mob = new ArrayList<>();
    
    static int N,M,D,fin_max;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N+1][M];
        comb_arr = new int[M];
        result = new int[3];
        check = new boolean[M];
        fin_max = Integer.MIN_VALUE;
        for(int i=0; i<N;i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)
                {
                    mob.add(new int[] {i,j});
                }
            }
            if(i==N-1)
            {
                for(int k=0; k<M; k++)
                {
                    map[N][k] = 5;
                }
            }
        }
        for(int i=0; i<M;i++) comb_arr[i] = i;
        comb(0,0);
        System.out.println(fin_max);
    }
    public static void comb(int cur, int start)
    {

        if(cur==3)
        {
            int[][] map_copy= new int[N+1][M];
            for(int i=0; i<N+1; i++)
            {
                for(int j=0; j<M; j++)
                {
                    map_copy[i][j] = map[i][j];
                }
            }
            set_bow(result,map_copy);
            return;
        }
        for(int i=start;i<M;i++)
        {
            if(!check[i])
            {
                check[i] = true;
                result[cur] = comb_arr[i];
                comb(cur+1,start+1);
                check[i] = false;
            }
        }
    }
    public static void set_bow(int[] result,int[][] map_copy)
    {
        List<int[]> arc = new ArrayList<>();
        for(int i=0; i<3; i++)
        {
            map_copy[N][result[i]] = 6;
            arc.add(new int[] {N,result[i]});
        }
        play(map_copy,arc);
        return;
    }
    
    public static void printarr(int[][] map) 
    {
        for(int i=0; i<N+1; i++)
        {
            for(int j=0; j<M; j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void play(int[][] map, List<int[]> arc)
    {
        List<int[]> mob2 = new ArrayList<>();
        List<Integer> delete = new ArrayList<>();
        for(int i=0; i<mob.size(); i++)
        {
        	mob2.add(new int[] {mob.get(i)[0],mob.get(i)[1]});
        }
        int cnt=0;
        
        while(!mob2.isEmpty())
        {
        	List<int[]> target = new ArrayList<>();
        	int[] tar_arr = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
            A : for(int i=0; i<3; i++)
            {
            	int min = Integer.MAX_VALUE;
            	int min_x = 0;
            	int min_y = 0;
            	int min_target=0;
                B : for(int j=0; j<mob2.size();j++)
                {
                	int dis = (Math.abs(arc.get(i)[0] - mob2.get(j)[0]) + Math.abs(arc.get(i)[1] - mob2.get(j)[1]));
                    if(dis <= D)
                    {
                    	if(min>dis)
                    	{
                    		min = dis;
                    		min_x = mob2.get(j)[0];
                    		min_y = mob2.get(j)[1];
                    		tar_arr[i] = j;// j = 몹의 인덱스, 몇번째 몹인지. remove 하면 index가 바뀜
                    	}
                    	else if(min==dis && min_y>mob2.get(j)[1])
                    	{
                    		min = dis;
                    		min_x = mob2.get(j)[0];
                    		min_y = mob2.get(j)[1];
                    		tar_arr[i] = j;
                    	}
                    }
                }
                if(min<Integer.MAX_VALUE)
                {
                	if(min!=0)
                	{
                		if(!target.isEmpty())
                		{
                			for(int z = 0; z<target.size();z++)
                			{
                				if(target.get(z)[0] == min_x && target.get(z)[1] == min_y)
                				{
                					continue A;
                				}
                			}
                			target.add(new int[] {min_x,min_y});
                		}
                		else {
                			target.add(new int[] {min_x,min_y});
                		}
                	}
                }
            }
        	Arrays.sort(tar_arr);
        	int temp_tar=Integer.MAX_VALUE;
        	for(int i=tar_arr.length-1; i>=0;i--)
        	{
        		if(tar_arr[i]!=Integer.MAX_VALUE)
        		{
        			if(temp_tar==tar_arr[i])
        			{
        				continue;
        			}
        			mob2.remove(tar_arr[i]);
        			temp_tar=tar_arr[i];
        		}
        	}
            int size = target.size();
            for(int k=0; k<size;k++)
            {
                map[target.get(0)[0]][target.get(0)[1]] = 0;// 디버깅을 위해서 만든 장치인데, 이거때문에 디버깅 오래걸림
                target.remove(0);
                cnt++;
            }
            for(int m=1; m<N;m++)
            {
            	if(m==1)
            	{
            		for(int i=0;i<M;i++)
            		{
            			if(map[N-1][i] == 1 && mob2.size()!=0) {
            				mob2.remove(mob2.size()-1);
            			}
            		}
            	}
            	map[N-m] = map[N-m-1];
            }
            if(!mob2.isEmpty())
            {
            	for(int i=0; i<mob2.size();i++)
            	{
            		mob2.get(i)[0]+=1;
            	}
            }
        }
        fin_max = Math.max(fin_max, cnt);
        return ;
    }

}