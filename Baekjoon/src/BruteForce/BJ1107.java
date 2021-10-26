package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1107 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cnt=0,start=100;
		//int n=Integer.parseInt(br.readLine());
		char[] n=br.readLine().toCharArray();
		int m=Integer.parseInt(br.readLine());
		boolean[] num=new boolean[10];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<m;i++) {
			num[Integer.parseInt(st.nextToken())]=true;
		}
		
		outer: for(int i=0;i<n.length;i++) {
			for(int j=0;j<num.length;j++) {
				if(!num[n[i]]) cnt++; //누를 수 있다면 누른다.
				else { //누를 수 없다면
					//가장 가까운 수를 찾는다.
					
					//1의 자리가 아닐 때
					if(i<m-1) {
						int temp=n[i];
						int plus=1;
						while(plus<=10) {
							if(n[i+1]>=5) {
								temp=temp+plus;
							}else {
								temp=temp-plus;
							}
							if(!num[temp]) {
								cnt++; //누른다.
								break;
							}
						}
					}else { //1의 자리일때
						int temp=n[i];
						int plus=1;
						while(plus<=10) {
							temp=temp+plus;
							if(!num[temp]) {
								cnt++; //누른다.
								break;
							}
							temp=temp-plus;
							if(!num[temp]) {
								cnt++; //누른다.
								break;
							}
						}
					}
					//그 아래 수를 가장 가까운 수로 만든다.
					
					
					
					break outer;
				}
			}
		}
		
	}
}
