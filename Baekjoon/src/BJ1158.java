

import java.util.Arrays;
import java.util.Scanner;

public class BJ1158 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); //입력값이 크지 않으므로 사용하기 편한 스캐너 이용
 		int n=sc.nextInt(); //사람 수 받기
		int k=sc.nextInt(); //k번째 사람 제거
		int[] arr=new int[n]; // 자리에 앉은 사람들 ex) 1~7
		int[] ans=new int[n]; // 유세푸스 순열을 담는 배열
		
		//자리에 앉는 사람들 번호 매김
		for(int i=0;i<n;i++) {
			arr[i]=i+1;
		}
		
		int idx=k-1;								   //제거할 사람을 찾는 인덱스 변수
		int cnt=0; 									   //k번째 사람인지 확인하기 위한 count 변수
		for(int j=0;j<n;j++) {
			ans[j]=arr[idx]; 					       //유세푸스 순열에 추가
			System.out.println(Arrays.toString(ans));  //ans[j] 출력 확인
			arr[idx]=0;                                //순열에 추가된 사람 0으로 제거
			if(j==n-1) break;                		   //j=n-1일때 ans 배열이 다 차고 arr배열이 모두 0이되어있다. (while문으로 들어가면 무한루프에 빠지게됨)
			while(cnt!=k) {                    		   //k만큼 이동한 후의 idx를 저장하고 빠져나오는 반복문
				if(idx+1>=n) {                 		   //idx를 하나씩 증가시킬때, idx+1이 배열의 끝까지 가게된다면 처음으로 돌아가도록 설정
					idx=0;
				}else {                     		   //아닐 경우 idx를 하나씩 증가시킨다.
					idx++;
				}
				if(arr[idx]!=0) {		               //이미 제거된 것이 아니면 cnt를 증가시켜 k명수 전까지 명수를 센다.
					cnt++;
				}
			}
			cnt=0; 	//cnt 초기화
		}
		
		//출력
		System.out.println("--------정답-------");
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		for(int a=0;a<n;a++) {
			sb.append(ans[a]+", "); //,+" " 공백까지 있음 ->setLength할때 -2를 해줘야함.
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
		
		sc.close();
	}
}
