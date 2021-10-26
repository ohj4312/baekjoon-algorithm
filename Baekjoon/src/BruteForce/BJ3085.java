package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3085 {
	private static char[][] map,temp;
	private static int n,max=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		n=Integer.parseInt(br.readLine());
		map=new char[n][n];
		
		for(int i=0;i<n;i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		copy();
		eat();
		
		char num;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
		
				//다른 사탕을 움직여 먹어
				if(j>0&&map[i][j-1]!=map[i][j]) {
					copy();
					num=temp[i][j];
					temp[i][j]=temp[i][j-1];
					temp[i][j-1]=num;
					eat();
				}
				
				if(i>0&&map[i-1][j]!=map[i][j]) {
					copy();
					num=temp[i][j];
					temp[i][j]=temp[i-1][j];
					temp[i-1][j]=num;
					eat();
				}
				
			}
		}
		
		System.out.println(max);
		
	}

	private static void eat() {
		//완탐 - 가장 큰 것 찾기
		int csum=0,rsum=0;
		char cstore='0',rstore='0';
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				//행이 같을때
				if(j>0&&(temp[i][j]==temp[i][j-1]||temp[i][j]==rstore)) {
					rsum++;
					rstore=temp[i][j];
				}else {
					rstore='0';
					if(max<rsum) max=rsum;
					rsum=0;
				}
				
				//열이 같을때
				if(j>0&&(temp[j][i]==temp[j-1][i]||temp[j][i]==cstore)) {
					csum++;
					cstore=temp[j][i];
				}else {
					cstore='0';
					if(max<csum) max=csum;
					csum=0;
				}
			}
		}
		
	}

	private static void copy() {
		//temp에 복사하기
		temp=new char[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				temp[i][j]=map[i][j];
			}
		}
		
	}
}
