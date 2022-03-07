import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ13904 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		int[][] input=new int[n][2];
		int d=n;
		int day=1;
		int sum=0;
		//입력
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			input[i][0]=Integer.parseInt(st.nextToken());
			if(d<input[i][0]) d=input[i][0];
			input[i][1]=Integer.parseInt(st.nextToken());			
		}
		int[] select=new int[d+1];
		//정렬
		Arrays.sort(input,(o1,o2)->{
			if(o1[1]==o2[1]) {
				return Integer.compare(o1[1], o2[1]);
			}else {
				return Integer.compare(o2[1], o1[1]);
			}
		});
		
		
		int temp=0;
		for(int i=0;i<n;i++) {
			if(select[input[i][0]]!=0) {
				temp=input[i][0];
				while(temp-->1) {
					if(select[temp]==0) {
						select[temp]=input[i][1];
						break;
					}
				}
			}else
				select[input[i][0]]=input[i][1];
		}
		
		
		for(int i=1;i<select.length;i++) {
			sum+=select[i];
		}
		
		System.out.println(sum);
	}
}
//반례
/*
5
2 100
3 100
2 500
2 50
3 40
* */
