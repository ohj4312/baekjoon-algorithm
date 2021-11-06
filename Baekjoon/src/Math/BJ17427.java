package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17427 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int answer=0;
		
		/*	//시간 초과		
		  for(int i=1;i<=n;i++) {
					for(int j=1;j<=i;j++) {
						if(i%j==0) answer+=j;
					}
				}*/
		
		for(int i=1;i<=n;i++) {
			answer+=i*(n/i);
		}
		
		System.out.println(answer);
	}
}
