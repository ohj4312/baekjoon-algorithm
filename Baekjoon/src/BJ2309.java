

import java.util.Arrays;
import java.util.Scanner;

//Number 2309 일곱난쟁이
public class BJ2309 {
	private static int[] person=new int[9];
	private static void comb(int select,int[] seven,int start) {
		if(select==7) {
			int sum=0;
			for(int n=0;n<seven.length;n++) {
				sum+=seven[n];
			}
			if(sum==100) {
				Arrays.sort(seven);
				for(int n=0;n<seven.length;n++) {
					System.out.println(seven[n]);
				}
			}
			return; //start 조건고민
		}
		
		for(int i=start;i<9;i++) {
			seven[select]=person[i];
			comb(select+1,seven,i+1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<9;i++) {
			person[i]=sc.nextInt();
		}
		
		comb(0,new int[7],0);
		
	}
}
