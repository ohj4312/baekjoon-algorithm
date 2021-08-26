

import java.util.Scanner;

public class BJ3040 {
	private static int[] input=new int[9];
	private static int[] real=new int[7];
	public static void comb(int start,int cnt) {
		if(cnt==7) {
			int sum=0;
			for(int a=0;a<real.length;a++) {
				sum+=real[a];
			}
			if(sum==100) {
				for(int b=0;b<real.length;b++) {
					System.out.println(real[b]);
				}
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			real[cnt]=input[i];
			comb(i+1,cnt+1);
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<9;i++) {
			input[i]=sc.nextInt();
			sc.nextLine();
		}
		
		//호출
		comb(0,0);
		
	}
}
