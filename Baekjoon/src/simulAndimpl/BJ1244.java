package simulAndimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int[] sw=new int[n+1];
		sw[0]=2;
		for(int i=1;i<=n;i++) {
			sw[i]=Integer.parseInt(st.nextToken());
		}
		int s=Integer.parseInt(br.readLine());
		int x,y;
		for(int i=0;i<s;i++) {
			st=new StringTokenizer(br.readLine()," ");
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			
			if(x==1) { //남학생
				while(y<=n) {
					sw[y]=(sw[y]==0)?1:0;
					x++;
					y=y*x;
				}
			}else {
				int p=1;
				sw[y]=(sw[y]==0)?1:0;
				while(y-p>0&&y+p<=n&&sw[y-p]==sw[y+p]) {
					sw[y+p]=sw[y-p]=sw[y-p]==0?1:0;
					p++;
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			System.out.print(sw[i]+" ");
			if(i%20==0) 
				System.out.println("");
		}
		
	}
}
