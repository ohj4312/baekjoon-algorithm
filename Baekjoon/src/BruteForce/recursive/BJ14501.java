package BruteForce.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		
		int[][] tp=new int[n+1][2]; //입력배열
		int[][] dp=new int[n+1][n+1]; //동적테이블 
		boolean[] ck=new boolean[n+1]; //상담이 잡힌날 제외

		for(int t=1;t<=n;t++) {
			st=new StringTokenizer(br.readLine()," ");
			tp[t][0]=Integer.parseInt(st.nextToken());
			tp[t][1]=Integer.parseInt(st.nextToken());
		}
		
		
		/*		for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						//||j+tp[i][0]>n
						if(j-tp[i][0]<0||i+tp[i][0]>n) dp[i][j]=dp[i-1][j]; //일수가 안되면 패쓰
						else {
							dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-tp[i][0]]+tp[i][1]); //점화식
							if(dp[i][j]!=dp[i-1][j]) {
								
							}
						}
					}
				}*/
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				//||j+tp[i][0]>n
				if(i-tp[j][0]<0||j+tp[i][0]>n) dp[j][i]=dp[j-1][i]; //일수가 안되면 패쓰
				else {
					dp[j][i]=Math.max(dp[j-1][i], dp[j-1][i-tp[j][0]]+tp[j][1]); //점화식
				
				}
			}
		}
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(dp[n][n]);
	}
}
