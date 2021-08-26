

import java.util.Scanner;

public class BJ2961 {
	private static int[] sarr,barr;
	private static int ssum=1,bsum=0,answer=Integer.MAX_VALUE;
	
	private static void subset(int cnt,boolean[] isSelected) {
		if (cnt == sarr.length) {
			int check=0;
			for (int i = 0; i < sarr.length; i++) {
				if (isSelected[i]) {
					ssum*=sarr[i];
					bsum+=barr[i];
					check++;
				}
			}
			if(check==0) return;
			
			int m=(ssum>bsum)?ssum-bsum:bsum-ssum;
			
			if(answer>m) answer=m;
			ssum=1; bsum=0;
			return;
		}

		//선택
		isSelected[cnt]=true;
		subset(cnt+1, isSelected);
		//비선택
		isSelected[cnt]=false;
		subset(cnt+1, isSelected);
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		sarr=new int[n];
		barr=new int[n];
		
		//입력
		for(int i=0;i<n;i++) {
			sarr[i]=sc.nextInt();
			barr[i]=sc.nextInt();
			sc.nextLine();
		}
		
		subset(0, new boolean[n]);
		
		//출력
		System.out.println(answer);
	}
}
