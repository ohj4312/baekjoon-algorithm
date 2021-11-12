package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1697 {
	private static boolean check[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		check=(n<k)?new boolean[k*2+1]:new boolean[n*2+1];
		bfs(n,k);
	}

	private static void bfs(int n,int k) {
		
		Queue<Integer> queue=new LinkedList<Integer>();
		int cnt=0;
		queue.offer(n);
		check[n]=true;
		int temp=0,size=0;
		
		
		while(!queue.isEmpty()) {
			
			size=queue.size();
			System.out.println(size);
			while(size-->0) {
				temp=queue.poll();
				System.out.println("temp :"+temp);
				if(temp==k) break;
				
				if(temp>=1&&!check[temp-1]) {
					queue.offer(temp-1);
					check[temp-1]=true;
				}
				if(temp+1<check.length&&!check[temp+1]) {
					queue.offer(temp+1);
					check[temp+1]=true;
				}
				if(temp*2<check.length&&!check[temp*2]) {
					queue.offer(temp*2);
					check[temp*2]=true;
				}
				
			}
			
			if(temp==k) break;
			cnt++;
		}
		
		System.out.println(cnt);
		
	}
}
