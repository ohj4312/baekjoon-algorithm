

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//으앙 포기
public class BJ15683 {
	private static int[] dx= {0,-1,0,1}; //좌상우하
	private static int[] dy= {-1,0,1,0}; //좌상우하
	private static int min;
	private static List<int[]> cctv;
	private static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str, " ");
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		arr=new int[x][y];
		int zeroCnt=0;
		cctv=new ArrayList<>();
		
		for(int i=0;i<x;i++) {
			str=br.readLine();
			st=new StringTokenizer(str," ");
			for(int j=0;j<y;j++) {
				arr[x][y]=Integer.parseInt(st.nextToken());
				if(arr[x][y]==0) zeroCnt++;
				else if(arr[x][y]!=6) cctv.add(new int[] {arr[x][y],0,x,y});
			}
		}
		
		min=zeroCnt;
		
		
	}
	
	
	private static void ohno(int cnt,int del,int start,int zero) { //조합
		//사각지대가 최소인가
		if(zero<min) {
			min=zero;
			return;	 
		}
		if(cnt==cctv.size()) {
			return;
		}
		
		switch(cctv.get(start)[0]) { //cctv 번호에 따라 동작
		case 1:
			for(int i=0;i<4;i++) {
				ohno(cnt+1,del+1,start+1,zero-0);
			}
			break;
		case 2:
			for(int i=0;i<2;i++) {
				ohno(cnt+1,del+1,start+1,zero-0);
			}
			break;
		case 3:
			for(int i=0;i<4;i++) {
				ohno(cnt+1,del+1,start+1,zero-0);
			}
			break;
		case 4:
			for(int i=0;i<4;i++) {
				ohno(cnt+1,del+1,start+1,zero-0);
			}
			break;
		case 5:
			ohno(cnt+1,del+1,start+1,zero-0);			
			break;
		}
		
		
	}
}
