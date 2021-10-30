package BruteForce.NAndM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15651 {
	private static int n,m;
	private static int[] arr,ans;
	private static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr=new int[n];
		ans=new int[m];
		for(int i=0;i<n;i++) {
			arr[i]=i+1;
		}
		
		perm(0);
		
		System.out.println(sb.toString());
	}

	private static void perm(int cnt) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				sb.append(ans[i]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		
		
		for(int i=0;i<n;i++) {
			ans[cnt]=arr[i];
			perm(cnt+1);
			
		}
		
	}
}
