package BruteForce.recursive;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ1759 {
	private static char[] answer;
	private static char[] carr;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int l=sc.nextInt();
		int c=sc.nextInt();
		sc.nextLine();
		String arr=sc.nextLine();
		carr=new char[c];
		answer=new char[l];
		
		//보충 때 들었던 짝수로 뽑기!
		int i=1;
		carr[0]=arr.charAt(0);
		for(int cinput=1;cinput<c;cinput++) {
			i=cinput*2;
			carr[cinput]=arr.charAt(i);
		}
		Arrays.sort(carr);
		comb(0,0);
	}
	
	private static void comb(int cnt,int start) {
		if(cnt==answer.length) {
			int check=0;
			int t=0;
			StringBuilder sb=new StringBuilder();
			for(int b=0;b<cnt;b++) {
				t++;
				if("aioue".contains(answer[b]+"")) check++;
				sb.append(answer[b]);
			}
			if(check>=1&&(t-check)>=2) System.out.println(sb);
			return;
		}
		
		for(int i=start;i<carr.length;i++) {
			if(cnt==0) {
				answer[cnt]=carr[i];
				comb(cnt+1,i+1);
			}else if(cnt>=1&&answer[cnt-1]<carr[i]) {
				answer[cnt]=carr[i];
				comb(cnt+1,i+1);
			}
		}
	}

}
