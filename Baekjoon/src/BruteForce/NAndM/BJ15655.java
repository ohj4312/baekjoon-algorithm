package BruteForce.NAndM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15655 {
	private static int n,m;
	private static int[] arr,ans;
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine()," ");
		
		ans=new int[m];
		arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		com(0,0);
		
		
	}
	
	private static void com(int cnt, int start) {
		if(cnt==m) {
			sb=new StringBuilder();
			for(int i=0;i<m;i++) {
				sb.append(ans[i]+" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
			return;
		}
		
		
		for(int i=start;i<n;i++) {
			ans[cnt]=arr[i];
			com(cnt+1,i+1);
		}
	}
	
}
