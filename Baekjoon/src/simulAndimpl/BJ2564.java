package simulAndimpl;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2564 {
	
	public static int x,y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		y=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(br.readLine());
		int[][] map=new int[x+1][y+1];
		int[][] sum=new int[n][2]; //[][0] 은 시계합, [][1]은 반시계합
		int ans=0; //시계합과 반시계합중 큰거 더한게 답
		int[] mv=new int[2];
		//서북동남 (시계방향) 동북서남(반시계)
		int[] wdx= {0,-1,0,1};
		int[] wdy= {-1,0,1,0};
		int[] ndx= {0,-1,0,1};
		int[] ndy= {1,0,-1,0};
		
		//동근이
		int[] dg=new int[2];
		st=new StringTokenizer(br.readLine()," ");
		dg=dest(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int[] temp=dest(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			map[temp[0]][temp[1]]=i;
		}
		
		//동근이 출발!
		int i=0;
		while(dg[0]!=mv[0]&&dg[1]!=mv[1]) {
			mv[0]=dg[0]+wdx[i];
			mv[1]=dg[1]+wdx[i];
			
			if(mv[0]<0&&mv[1]<0&&mv[0]>x&&mv[1]>y) i++;
			
			
			
		}
		
	}

	private static int[] dest(int a, int b) {
		int[] temp=new int[2];
		switch(a) {
		case 1:
			temp[0]=b;
			temp[1]=0;
			break;
		case 2:
			temp[0]=b;
			temp[1]=y;
			break;
		case 3:
			temp[0]=0;
			temp[1]=b;
			break;
		case 4:
			temp[0]=x;
			temp[1]=b;
			break;
		}
		return temp;
	}
}
