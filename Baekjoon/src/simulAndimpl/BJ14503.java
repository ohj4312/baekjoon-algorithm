package simulAndimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14503 {
	private static int n,m;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		int result=0;
		
		st=new StringTokenizer(br.readLine()," ");
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken()); //북동남서
		int[][] dir= {{0,-1},{1,0},{0,1},{-1,0}}; //서남동북
		
		map=new int[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
	
		int dx=0,dy=0,cnt=0;
		boolean check=true;
		while(check) {
			if(d==4) d=0;
			
			if(map[r][c]==0) {
				result++;
				map[r][c]=1;
			}
			
			dx=r+dir[d][0];
			dy=c+dir[d][1];
			if(dx<0||dy<0||dx>=n||dy>=m) {
				d++; cnt++;
				continue;
			}
			if(map[dx][dy]==1) {
				d++; cnt++;
				continue;
			}
			
			
			if(cnt==4) {
				if(d==0) dx=r+1;
				else if(d==1) dy=c-1;
				else if(d==2) dx=r-1;
				else dy=c+1;
				
				if(dx<0||dy<0||dx>=n||dy>=m) {
					check=false;
					break;
				}
				if(map[dx][dy]==1) {
					check=false;
					break;
				}
			    
				cnt=0;
			}
			
			r=dx; c=dy;
			System.out.println(r+" "+c);
			
		}
		
		System.out.println(result);
		
		
	}
}
