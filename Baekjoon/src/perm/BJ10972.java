package perm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10972 {
	private static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		StringBuilder sb=null;
		arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		if(np(arr)) {
			sb=new StringBuilder();
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]+" ");
			}
			sb.setLength(sb.length()-1);			
			System.out.println(sb.toString());
		}
		else
			System.out.println("-1");
	}
	
	private static boolean np(int[] numbers) {
		int N=numbers.length;
		
		//step1. 꼭대기 (i)를 찾는다. 꼭대기를 통한 교환위치(i-1) 찾기
		int i=N-1; //만약 N이 numbers.length-1 이라면 N으로 준다.
		
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		//반복문을 빠져나오는 것은 i가 0이되어 가장 큰순열일 때, 혹은 꼭대기를 찾았을때 이다.
		
		if(i==0) return false;
		
		//step2. i-1의 위치값과 교환할 다음으로 큰 값 찾기
		int j=N-1;
		
		while(numbers[i-1]>=numbers[j]) --j;
		//numbers[i-1]과 교한할 것은 항상있다 . 왜냐면 i라는 꼭대기보다 작은것이기 때문에 꼭대기는 무조건 크다.
		
		//step3. i-1 위치 값과 j 위치값 교환
		swap(numbers,i-1,j);
		
		//step4. 꼭대기부터 맨뒤까지 내림차순 형태의 순열을 오름차순으로 처리
		int k=N-1;
		while(i<k) {
			swap(numbers,i++,k--); //후위 연산자이므로 swap하고 와서 증가하고, 감소한다.
		}
		
		return true;
	}
	
	private static void swap(int[] numbers,int i,int j) {
		int temp=numbers[i];
		numbers[i]=numbers[j];
		numbers[j]=temp;
	}
}
