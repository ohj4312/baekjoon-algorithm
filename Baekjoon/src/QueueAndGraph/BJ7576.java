package QueueAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
	
	private static int t=0,result=-1;
	private static int[][] arr;
	private static Queue<int[]> q=new LinkedList<int[]>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		
		arr=new int[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) t++;
				else if(arr[i][j]==1) q.offer(new int[] {i,j});
			}
		}
		
		if(t==0) System.out.println(0);
		else {
			bfs();
			if(t!=0) System.out.println(-1);
			else System.out.println(result);
		}
	}

	private static void bfs() {
		int[] dx= {-1,1,0,0}; //상하좌우
		int[] dy= {0,0,-1,1};
		int tempx,tempy;
		int s=q.size();
		int[] current=new int[2];
		
		while(!q.isEmpty()) {
			s=q.size();
			
			while(s-->0) {
				current = q.poll();
				for(int i=0;i<4;i++) {
					tempx=current[0]+dx[i];
					tempy=current[1]+dy[i];
					
					if(tempx<0||tempy<0||tempx>=arr.length||tempy>=arr[0].length) continue;
					
					if(arr[tempx][tempy]==0) { 
						arr[tempx][tempy]=1;
						t--;
						q.offer(new int[] {tempx,tempy});
					}
					
				}
			}
			result++;
		}
	}
}
