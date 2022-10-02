package _0929;

import java.util.Deque;
import java.util.LinkedList;

public class programmers_크레인인형뽑기 {
	public static void main(String[] args)
	{
		int answer = 0;
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
        int N = board.length;
        Deque<Integer> deque = new LinkedList<>();
        deque.add(0);
        A : for(int i=0; i<moves.length-1;i++)
        {
        	for(int j=0; j<N; j++)
        	{
        		if(board[j][moves[i]-1]!=0)
        		{
//        			System.out.println(board[j][moves[i]-1]);
        			if(deque.peekLast()==board[j][moves[i]-1])
        			{
        				answer+=2;
        				deque.pollLast();
        			}
        			else
        			{
        				deque.addLast(board[j][moves[i]-1]);
        			}
        			board[j][moves[i]-1] = 0;
        	        continue A;
        		}
        	}
        }
        System.out.println(answer);
	}
}
