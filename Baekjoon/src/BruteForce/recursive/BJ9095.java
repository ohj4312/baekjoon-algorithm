package BruteForce.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9095 {
	private static int cnt=0,sum=0,n;
	private static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		arr=new int[n];
		
		for(int i=1;i<n;i++) {
			arr[i]=i;
		}
		
		rec();
		
		System.out.println(cnt);
		
	}
	private static void rec() {
		if(sum>=n) {
			if(sum==n) cnt++;
			sum=0;
			return;
		}
		
		
		for(int i=1;i<n;i++) {
			sum+=arr[i];
			System.out.println(sum);
			rec();
		}
		
	}
}
