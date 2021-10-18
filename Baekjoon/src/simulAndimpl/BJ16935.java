package simulAndimpl;


import java.util.Arrays;
import java.util.Scanner;

public class BJ16935 {
	private static int[][] arr;
	
	public static void method1() {
		int[] temp;
		for(int i=0;i<arr.length/2;i++) {
			temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
	}
	public static void method2() {
		int temp;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length/2;j++) {
				temp=arr[i][j];
				arr[i][j]=arr[i][arr[0].length-1-j];
				arr[i][arr[0].length-1-j]=temp;
			}
		}
	}
	public static void method3() {
		
		int temp[][]=new int[arr[0].length][arr.length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				temp[j][arr.length-1-i]=arr[i][j];
			}
		}
		
		arr=new int[arr[0].length][arr.length];
		arr=temp;
	}
	public static void method4() {
		
		int temp[][]=new int[arr[0].length][arr.length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				temp[arr[0].length-1-j][i]=arr[i][j];
			}
		}
		
		arr=new int[arr[0].length][arr.length];
		arr=temp;
	}
	
	public static int[][] split(){
		
		int[][] check=new int[arr.length][arr[0].length];
		
		for(int i=0;i<check.length;i++) {
			for(int j=0;j<check[0].length;j++) {
				if(i<check.length/2) {
					if(j<check[0].length/2) check[i][j]=1;
					else check[i][j]=2;
				}else {
					if(j<check[0].length/2) check[i][j]=4;
					else check[i][j]=3;
					
				}
			}
		}
		
		/*for(int a=0;a<check.length;a++) {
			System.out.println(Arrays.toString(check[a]));
		}*/
		return check;
	}
	
	
	public static void method5() {
		int[][] check=split();
		int[][] temp=new int[arr.length][arr[0].length];
		for(int i=0;i<temp.length;i++) {
			for(int j=0;j<temp[0].length;j++) {
				switch(check[i][j]) {
				case 1:
					temp[i][j+(temp[0].length/2)]=arr[i][j];
					break;
				case 2:
					temp[i+(temp.length/2)][j]=arr[i][j];
					break;
				case 3:
					temp[i][j-(temp[0].length/2)]=arr[i][j];
					break;
				case 4:
					temp[i-(temp.length/2)][j]=arr[i][j];
					break;
				}
			}
		}
		
		arr=temp;
	}
	public static void method6() {
		int[][] check=split();
		int[][] temp=new int[arr.length][arr[0].length];
		for(int i=0;i<temp.length;i++) {
			for(int j=0;j<temp[0].length;j++) {
				switch(check[i][j]) {
				case 1:
					temp[i+(temp.length/2)][j]=arr[i][j];
					break;
				case 2:
					temp[i][j-(temp[0].length/2)]=arr[i][j];
					break;
				case 3:
					temp[i-(temp.length/2)][j]=arr[i][j];
					break;
				case 4:
					temp[i][j+(temp[0].length/2)]=arr[i][j];
					break;
				}
			}
		}
		arr=temp;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int r=sc.nextInt();
		sc.nextLine();
		arr=new int[n][m];
		int[][] temp=split();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
			}
			sc.nextLine();
		}
		
		for(int a=0;a<r;a++) {
			int re=sc.nextInt();
			switch(re) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 4:
				method4();
				break;
			case 5:
				method5();
				break;
			case 6:
				method6();
				break;
			}
		}
		
		for(int o=0;o<arr.length;o++) {
			for(int u=0;u<arr[0].length;u++) {
				System.out.print(arr[o][u]+" ");
			}
			System.out.println();
		}
	}
}
