package BruteForce.NAndM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15653 {
	private static StringBuilder sb;
	private static int n,m;
	private static int[] arr,ans;
	private static boolean[] ck;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr=new int[n];
		ck=new boolean[n];
		ans=new int[m];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		perm(0);
	}
	private static void perm(int cnt) {
		if(cnt==m) {
			sb=new StringBuilder();
			for(int i=0;i<m;i++) {
				sb.append(ans[i]+" ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(ck[i]) continue;
			ans[cnt]=arr[i];
			ck[i]=true;
			
			perm(cnt+1);
			ck[i]=false;
		}
	}
}
