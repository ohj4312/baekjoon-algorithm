package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ13913 {
	
	private static int k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		dfs(0,n,new ArrayList<Integer>());
		
	}

	private static void dfs(int i, int n, ArrayList<Integer> list) {
		if(n==k) {
			System.out.println(i);
			StringBuilder sb=new StringBuilder();
			for(int a=0;a<list.size();a++) {
				sb.append(list.get(a)+" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
		}
		
		list.add(n);
		dfs(i++,n+1,list);
		dfs(i++,n-1,list);
		dfs(i++,n*2,list);
		
		
	}
}
