

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] n=br.readLine().toCharArray();
		int[] check=new int[10];
		
		//숫자별로 필요한 개수 카운트
		for(int i=0;i<n.length;i++) {
			if(n[i]=='6'||n[i]=='9') {
				check[9]++;
			}else {
				check[n[i]-'0']++;
			}
		}
/*		
	//	int cnt=0;
		//if((check[6]==0&&check[9]!=0)||(check[6]!=0&&check[9]==0)) cnt=1;
		
		//while(cnt==1) {
			int temp=Math.abs(check[6]-check[9]);
			while(temp>1) {
				if(check[6]>check[9]) {
					if(temp%2!=0) check[6]+=1;
					check[6]-=temp/2;
					check[9]+=temp/2;
				}else {
					if(temp%2!=0) check[9]+=1;
					check[9]-=temp/2;
					check[6]+=temp/2;
				}
				temp=temp/2;
			}
		//}
*/		int answer=0;
		for(int i=0;i<10;i++) {
			if(i==9) {
				if(check[9]%2!=0) {
					check[9]=check[9]/2+1;
				}else {
					check[9]=check[9]/2;					
				}
			}
			if(check[i]>answer) answer=check[i];
		}
		
		System.out.println(answer);
		
	}
}
