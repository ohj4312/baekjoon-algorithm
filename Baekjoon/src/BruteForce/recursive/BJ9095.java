package BruteForce.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9095 {
	private static int cnt=0;
	private static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		arr=new int[n+1];
		if(n>=3) arr[3]=7; //111/12/21/3
		if(n>=2) arr[2]=2;
		if(n>=1) arr[1]=1;
		rec(n);
	}
	private static int rec(int n) {
		if(n==0||n==1) return arr[n]=n;
		if(arr[n]!=0) return arr[n];
		else if(n/3>0) return arr[n]=rec(3)+rec(n-3);
		else if(n/2>0) return arr[n]=rec(2)+rec(n-2);
		else return arr[n]=rec(1)+rec(n-1);
	}
}
