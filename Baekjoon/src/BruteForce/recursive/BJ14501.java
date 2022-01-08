package BruteForce.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501 {
	
	private static int n,max=0,sum=0;
	private static int[][] tp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		
		tp=new int[n+1][2]; //입력배열

		for(int t=1;t<=n;t++) {
			st=new StringTokenizer(br.readLine()," ");
			tp[t][0]=Integer.parseInt(st.nextToken());
			tp[t][1]=Integer.parseInt(st.nextToken());
		}
		
		solve(1);
		
		System.out.println(max);
		
	}

	private static void solve(int s) {
		//퇴사일 이면 끝
		if(s>=n) {
			if(sum>max) max=sum;
			System.out.println(s+"퇴사일"+sum+" max:"+max);
			return;
		}
		
		for(int i=s;i<n;i++) {
			if(i+tp[i][0]>n) {
				if(sum>max) max=sum;
				System.out.println("sum : "+sum);
				continue;
			}
			sum+=tp[i][1];
			System.out.println(s+" checke : "+sum+" , "+i+" 몇을 더하냐면? "+tp[i][0]);
			solve(i+tp[i][0]);
			sum-=tp[i][1];
		}
	}
}
