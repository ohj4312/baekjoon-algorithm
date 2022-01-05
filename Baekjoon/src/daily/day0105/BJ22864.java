package daily.day0105;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ22864 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int a=Integer.parseInt(st.nextToken()); //피로도
		int b=Integer.parseInt(st.nextToken()); //일할 수 있는 양
		int c=Integer.parseInt(st.nextToken()); //휴식 하면 떨어지는 피로도
		int m=Integer.parseInt(st.nextToken()); //피로도 한계
		
		int p=0,ans=0,cnt=0;
		
		for(int i=0;i<24;i++) { //하루 일하기=
			if(p+a>m) { //왕피곤할경우.
				p-=c;
				if(p<0) p=0;
			}else{
				p+=a;
				ans+=b;
				
			}
		}
		System.out.println(ans);
		
	}
}
