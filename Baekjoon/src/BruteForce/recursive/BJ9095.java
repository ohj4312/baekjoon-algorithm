package BruteForce.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ9095 {
	private static int cnt=0,n;
	private static int[] arr=new int[] {1,2,3},ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			n=Integer.parseInt(br.readLine());
			ans=new int[n];
			rec(0);
			
			System.out.println(cnt);
			cnt=0;
		}
	}
	private static void rec(int sum) {
		if(sum>=n) {
			if(sum==n) {
				cnt++;
			}
			sum=0;
			return;
		}
		
		
		for(int i=0;i<3;i++) {
			int tempsum=sum;
			tempsum+=arr[i];
			rec(tempsum);
			
		}
	}
}
