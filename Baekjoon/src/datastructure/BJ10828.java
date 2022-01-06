package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n]; // 스택 배열
		int tail=-1; //
		
		//입력 처리
		StringTokenizer st=null;
		String temp=null;
		
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			
			temp=st.nextToken();
			switch(temp) {
			case "push":
				arr[++tail]=Integer.parseInt(st.nextToken());
				break;
			case "pop":
				if(tail==-1) System.out.println(-1);//empty일경우
				else{
					System.out.println(arr[tail--]);
					//arr[tail--]=0; //위 코드를 arr[tail] -> arr[tail--]로 바꾸면서 52ms 절약, 굳이 0으로 바꾸지 않아도 tail로 관리하니까!
				}
				break;
			case "size":
				System.out.println(tail+1);
				break;
			case "empty":
				if(tail==-1) System.out.println(1);
				else System.out.println(0);
				break;
			case "top":
				if(tail==-1) System.out.println(-1);
				else System.out.println(arr[tail]);
				break;
			}
		}
	}
}
