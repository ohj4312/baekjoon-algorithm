package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10819 {
	private static int n,sum=0,max=0;
	private static int[] arr,result;
	private static boolean[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr=new int[n];
		result=new int[n];		
		check=new boolean[n];
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		perm(0);
		
		System.out.println(max);
	}

	private static void perm(int c) {
		if(c==n) {
			if(max<sum) max=sum;
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(check[i]) continue;
			result[c]=arr[i];
			if(c>0)sum+=Math.abs(result[c-1]-result[c]);
			check[i]=true;
			
			perm(c+1);
			check[i]=false;
			if(c>0) sum-=Math.abs(result[c-1]-result[c]);
		}
		
		
	}
}
